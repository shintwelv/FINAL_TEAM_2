import React from 'react'
import { Link } from 'react-router-dom'
import { Container, Modal, Button, Form } from 'react-bootstrap'
import styled from 'styled-components'
import { useState } from 'react'
import axios from 'axios'

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

  const [loginInfo, setloginInfo] = useState({
    user_id: '',
    user_pw: '',
  })

  const handleValueChange = (event) => {
    // API 요청에 날릴 Form state에 정보를 추가합니다.
    console.log(loginInfo)
    setloginInfo({
      ...loginInfo,
      [event.target.name]: event.target.value,
    })
  }

  const config = {
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
  }

  const logOut = () => {
    setLogin(false)
  }

  const logIn = () => {
    const dataToSend = JSON.stringify(loginInfo)

    axios
      .post('user/chkUser', dataToSend, config)
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

  const showLogInOut = (login) => {
    if (login) {
      return (
        <>
          <UserInfoItem>{userInfo.nickname}님 환영합니다</UserInfoItem>
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
            <Form.Group controlId="user_id">
              <Form.Label>아이디</Form.Label>
              <Form.Control
                type="text"
                name="user_id"
                onChange={handleValueChange}
              />
            </Form.Group>
            <Form.Group controlId="user_pw">
              <Form.Label>비밀번호</Form.Label>
              <Form.Control
                type="password"
                name="user_pw"
                onChange={handleValueChange}
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
