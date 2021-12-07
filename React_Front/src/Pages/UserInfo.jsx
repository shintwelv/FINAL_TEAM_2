import axios from 'axios'
import React, { useEffect, useState } from 'react'
import {
  Col,
  Container,
  Form,
  Image,
  Row,
  Button,
  Modal,
} from 'react-bootstrap'
import { useHistory, useLocation } from 'react-router'
import PopupPostCode from '../components/PopupPostCode'
import './css/user_info.css'

function UserInfo({ userState, userInfo, setLogin }) {
  const location = useLocation()
  const history = useHistory()

  const [address, setAddress] = useState('')
  const [popup, setPopup] = useState(false)

  const handleClose = () => setPopup(false)
  const handleShow = () => setPopup(true)

  useEffect(() => {
    if (userInfo) {
      setNewUser(userInfo)
    }
  }, [])

  const [newUser, setNewUser] = useState({
    Image: null,
    userId: '',
    userPw: '',
    userName: '',
    nickName: '',
    birth: null,
    gender: '',
    email: '',
    phoneNumber: '',
    userBasicAddress: '',
    userDetailAddress: '',
    enabled: 0,
    admin: 'N',
  })

  const handleValueChange = (event) => {
    // API 요청에 날릴 Form state에 정보를 추가합니다.
    console.log(newUser)
    setNewUser({
      ...newUser,
      [event.target.name]: event.target.value,
    })
  }

  const onFileChangeHandler = (e) => {
    e.preventDefault()
    newUser['Image'] = e.target.files[0]
  }

  const userProcess = (userState) => {
    let formData = new FormData()

    for (var key in newUser) {
      console.log(key + ': ' + newUser[key])
      formData.append(key, newUser[key])
    }

    let requestURL = ''

    if (userState == 'signUp') {
      requestURL = 'insert'
    } else if (userState == 'update') {
      requestURL = 'update'
    }
    axios
      .post(`http://localhost:9000/user/${requestURL}`, formData)
      .then((res) => {
        alert('요청이 처리되었습니다')
        setLogin(false)
        history.push('/')
      })
      .catch((err) => alert('error: ' + err))
  }

  const btn_modifyORSignUp = (userState) => {
    if (userState == 'signUp') {
      return '회원가입'
    } else if (userState == 'update') {
      return '수정'
    }
  }

  return (
    <Container className="user-info-container">
      <Row>
        <Col xs={12} className="user-info-title mb-3 mt-3">
          <span>회원정보</span>
        </Col>
      </Row>
      <Row>
        <Col xs={12} className="user-info-profile-image mb-3 mt-3">
          <Image src="./img/default_Profile.jpg" />
        </Col>
      </Row>
      <Row>
        <Col xs={12}>
          <Form>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="userId"
            >
              <Form.Label className="user-info-label">아이디</Form.Label>
              <Form.Control
                className="user-info-input"
                type="text"
                name="userId"
                onChange={handleValueChange}
                value={newUser.userId}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="userPw"
            >
              <Form.Label className="user-info-label">비밀번호</Form.Label>
              <Form.Control
                className="user-info-input"
                type="password"
                name="userPw"
                onChange={handleValueChange}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="userName"
            >
              <Form.Label className="user-info-label">이름</Form.Label>
              <Form.Control
                className="user-info-input"
                type="text"
                name="userName"
                onChange={handleValueChange}
                value={newUser.userName}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="nickName"
            >
              <Form.Label className="user-info-label">닉네임</Form.Label>
              <Form.Control
                className="user-info-input"
                type="text"
                name="nickName"
                onChange={handleValueChange}
                value={newUser.nickName}
              />
            </Form.Group>
            <Form.Group className="user-info-form-group mt-3" controlId="birth">
              <Form.Label className="user-info-label">생년월일</Form.Label>
              <Form.Control
                className="user-info-input"
                type="date"
                name="birth"
                onChange={(e) => {
                  setNewUser({
                    ...newUser,
                    ['birth']: new Date(e.target.value),
                  })
                }}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="gender"
            >
              <Form.Label className="user-info-label">성별</Form.Label>
              <div className="user-info-radio">
                <Form.Check
                  inline
                  name="gender"
                  type="radio"
                  id="남성"
                  label="남"
                  value="남성"
                  onChange={handleValueChange}
                />
                <Form.Check
                  inline
                  name="gender"
                  type="radio"
                  id="여성"
                  label="여"
                  value="여성"
                  onChange={handleValueChange}
                />
              </div>
            </Form.Group>
            <Form.Group className="user-info-form-group mt-3" controlId="email">
              <Form.Label className="user-info-label">이메일</Form.Label>
              <Form.Control
                className="user-info-input"
                type="email"
                placeholder="example@example.com"
                name="email"
                onChange={handleValueChange}
                value={newUser.email}
              />
            </Form.Group>
            <Form.Group className="user-info-form-group mt-3" controlId="phone">
              <Form.Label className="user-info-label">전화번호</Form.Label>
              <Form.Control
                className="user-info-input"
                type="tel"
                pattern="010[0-9]{4}[0-9]{4}"
                placeholder="숫자만 입력하세요"
                name="phoneNumber"
                onChange={handleValueChange}
                value={newUser.phoneNumber}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="userBasicAddress"
            >
              <Form.Label className="user-info-label"></Form.Label>
              <Button
                onClick={() => {
                  handleShow()
                }}
              >
                주소 검색
              </Button>
              <Modal show={popup} onHide={handleClose}>
                <Modal.Header closeButton>
                  <Modal.Title>주소검색</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                  {PopupPostCode({ setNewUser, handleClose, newUser })}
                </Modal.Body>
              </Modal>
              <Form.Control
                className="user-info-input"
                type="text"
                name="userBasicAddress"
                onChange={handleValueChange}
                value={newUser.userBasicAddress}
              ></Form.Control>
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="userDetailAddress"
            >
              <Form.Control
                className="user-info-input"
                type="text"
                name="userDetailAddress"
                onChange={handleValueChange}
              ></Form.Control>
            </Form.Group>
            <Form.Group className="user-info-form-group mt-3">
              <Form.Label className="user-info-label">프로필사진</Form.Label>
              <Form.Control
                className="user-info-input-image user-info-input"
                type="file"
                name="Image"
                onChange={onFileChangeHandler}
              ></Form.Control>
            </Form.Group>
            <Button
              className="user-info-btn d-block mb-2 mt-3"
              type="button"
              onClick={() => userProcess(userState)}
            >
              {btn_modifyORSignUp(userState)}
            </Button>
            <Button className="user-info-btn d-block mb-3">취소</Button>
          </Form>
        </Col>
      </Row>
    </Container>
  )
}

export default UserInfo
