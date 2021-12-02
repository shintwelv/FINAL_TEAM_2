import axios from 'axios'
import React, { useState } from 'react'
import { Col, Container, Form, Image, Row, Button } from 'react-bootstrap'
import { useHistory, useLocation } from 'react-router'
import './css/user_info.css'

function UserInfo({ userState }) {
  const location = useLocation()
  const history = useHistory()

  const [userInfo, setUserInfo] = useState({
    profile_image: null,
    user_id: '',
    user_pw: '',
    user_name: '',
    nickname: '',
    birth: null,
    gender: '',
    email: '',
    phone_number: '',
    user_basic_address: '',
    user_detail_address: '',
  })

  const handleValueChange = (event) => {
    // API 요청에 날릴 Form state에 정보를 추가합니다.
    console.log(userInfo)
    setUserInfo({
      ...userInfo,
      [event.target.name]: event.target.value,
    })
  }

  const onFileChangeHandler = (e) => {
    e.preventDefault()
    userInfo['profile_image'] = e.target.files[0]
  }

  const config = {
    headers: {
      'content-Type': 'multipart/form-data',
    },
  }

  const userProcess = (userState) => {
    let formData = new FormData()

    for (var key in userInfo) {
      console.log(key + ': ' + userInfo[key])
      formData.append(key, userInfo[key])
    }

    // for (var values in formData.values()) {
    //   console.log(values)
    // }
    let requestURL = ''

    if (userState == 'signUp') {
      requestURL = 'http://localhost:8999/user/insertProcess.do'
    } else if (userState == 'update') {
      requestURL = 'http://localhost:8999/user/updateProcess.do'
    }
    axios
      .post(requestURL, formData, config)
      .then((res) => console.log(res))
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
          <Image src={require('../img/profile2.jpg').default} />
        </Col>
      </Row>
      <Row>
        <Col xs={12}>
          <Form>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="user_id"
            >
              <Form.Label className="user-info-label">아이디</Form.Label>
              <Form.Control
                className="user-info-input"
                type="text"
                name="user_id"
                onChange={handleValueChange}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="user_pw"
            >
              <Form.Label className="user-info-label">비밀번호</Form.Label>
              <Form.Control
                className="user-info-input"
                type="password"
                name="user_pw"
                onChange={handleValueChange}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="user_name"
            >
              <Form.Label className="user-info-label">이름</Form.Label>
              <Form.Control
                className="user-info-input"
                type="text"
                name="user_name"
                onChange={handleValueChange}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="nickname"
            >
              <Form.Label className="user-info-label">닉네임</Form.Label>
              <Form.Control
                className="user-info-input"
                type="text"
                name="nickname"
                onChange={handleValueChange}
              />
            </Form.Group>
            <Form.Group className="user-info-form-group mt-3" controlId="birth">
              <Form.Label className="user-info-label">생년월일</Form.Label>
              <Form.Control
                className="user-info-input"
                type="date"
                name="birth"
                onChange={handleValueChange}
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
              />
            </Form.Group>
            <Form.Group className="user-info-form-group mt-3" controlId="phone">
              <Form.Label className="user-info-label">전화번호</Form.Label>
              <Form.Control
                className="user-info-input"
                type="tel"
                pattern="010[0-9]{4}[0-9]{4}"
                placeholder="숫자만 입력하세요"
                name="phone_number"
                onChange={handleValueChange}
              />
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="user_basic_address"
            >
              <Form.Label className="user-info-label">주소</Form.Label>
              <Form.Control
                className="user-info-input"
                type="text"
                name="user_basic_address"
                onChange={handleValueChange}
              ></Form.Control>
            </Form.Group>
            <Form.Group
              className="user-info-form-group mt-3"
              controlId="user_detail_address"
            >
              <Form.Control
                className="user-info-input"
                type="text"
                name="user_detail_address"
                onChange={handleValueChange}
              ></Form.Control>
            </Form.Group>
            <Form.Group className="user-info-form-group mt-3">
              <Form.Label className="user-info-label">프로필사진</Form.Label>
              <Form.Control
                className="user-info-input-image user-info-input"
                type="file"
                name="profile_image"
                onChange={onFileChangeHandler}
              ></Form.Control>
            </Form.Group>
            <Button
              className="user-info-btn d-block mb-2 mt-3"
              type="button"
              onClick={userProcess}
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
