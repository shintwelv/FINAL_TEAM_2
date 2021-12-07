import React from 'react'
import { Link } from 'react-router-dom'
import { Container, Modal, Button, Form } from 'react-bootstrap'
import styled from 'styled-components'
import { useState, useEffect } from 'react'
import axios from 'axios'
import cookie from 'react-cookie'

const HeaderTopWrapper = styled.div`
  height: 24px;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  text-align: right;
  background-color: #0593f0;
  color: #fff;
  @media (max-width: 540px) {
    display: none;
  }
`

const UserInfo = styled.ul`
  font-size: 12px;
`

const UserInfoItem = styled.li`
  display: inline-block;
  margin-right: 16px;
  &:last-child {
    margin: 0;
  }
`
const HeaderTop = ({
  login,
  setLogin,
  setUserState,
  userInfo,
  setUserInfo,
}) => {
  const [modalShow, setModalShow] = useState(false)

  const handleModalClose = () => setModalShow(false)
  const handleModalShow = () => setModalShow(true)

  const [userId, setUserId] = useState('')
  const [userPw, setUserPw] = useState('')

  const logOut = () => {
    setUserInfo({
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
    setLogin(false)
  }

  const logIn = () => {
    axios
      .get(`http://localhost:9000/user/login?userId=${userId}&userPw=${userPw}`)
      .then((res) => {
        if (res.data) {
          setUserInfo(res.data)
          setLogin(true)
        } else {
          alert('로그인에 실패하였습니다')
        }
      })
      .catch((err) => alert(err))
    handleModalClose()
  }

  const changeUserState = (state) => {
    setUserState(state)
  }

  const showAdminConsole = (login, admin) => {
    if (login && admin == 'Y') {
      return (
        <UserInfoItem>
          <Link to="/Admin">관리자</Link>
        </UserInfoItem>
      )
    }
  }

  const showLogInOut = (login) => {
    if (login) {
      return (
        <>
          <UserInfoItem>{userInfo.nickName}님 환영합니다</UserInfoItem>
          <UserInfoItem onClick={() => changeUserState('update')}>
            <Link to="/UserInfo">마이페이지</Link>
          </UserInfoItem>
          <UserInfoItem onClick={logOut}>로그아웃</UserInfoItem>
        </>
      )
    } else {
      return (
        <>
          <UserInfoItem onClick={handleModalShow}>로그인</UserInfoItem>
          <UserInfoItem onClick={() => changeUserState('signUp')}>
            <Link to="/SignUp">회원가입</Link>
          </UserInfoItem>
          {/* {showAdminConsole(login, userInfo.admin)} */}
        </>
      )
    }
  }

  return (
    <>
      <Modal centered show={modalShow} onHide={handleModalClose}>
        <Modal.Header closeButton>
          <Modal.Title>로그인</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group controlId="userId">
              <Form.Label>아이디</Form.Label>
              <Form.Control
                type="text"
                name="userId"
                onChange={(e) => {
                  setUserId(e.target.value)
                }}
              />
            </Form.Group>
            <Form.Group controlId="userPw">
              <Form.Label>비밀번호</Form.Label>
              <Form.Control
                type="password"
                name="userPw"
                onChange={(e) => {
                  setUserPw(e.target.value)
                }}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button color="primary" onClick={logIn}>
            로그인
          </Button>{' '}
          <Button onClick={handleModalClose}>취소</Button>
        </Modal.Footer>
      </Modal>
      <HeaderTopWrapper>
        <Container>
          <UserInfo>{showLogInOut(login)}</UserInfo>
        </Container>
      </HeaderTopWrapper>
    </>
  )
}

export default HeaderTop
