import React from 'react'
import { Link } from 'react-router-dom'
import { Container } from 'react-bootstrap'

import styled from 'styled-components'
import { useState } from 'react'

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

const HeaderTop = ({ login, setLogin, nickName, setUserState }) => {
  const logOut = () => {
    setLogin(false)
  }

  const logIn = () => {
    setLogin(true)
  }

  const changeUserState = (state) => {
    setUserState(state)
  }

  const showLogInOut = (login) => {
    if (login) {
      return (
        <>
          <UserInfoItem>{nickName}님 환영합니다</UserInfoItem>
          <UserInfoItem onClick={() => changeUserState('update')}>
            <Link to="UserInfo">마이페이지</Link>
          </UserInfoItem>
          <UserInfoItem onClick={logOut}>로그아웃</UserInfoItem>
        </>
      )
    } else {
      return (
        <>
          <UserInfoItem onClick={logIn}>로그인</UserInfoItem>
          <UserInfoItem onClick={() => changeUserState('signUp')}>
            <Link to="SignUp">회원가입</Link>
          </UserInfoItem>
        </>
      )
    }
  }

  return (
    <HeaderTopWrapper>
      <Container>
        <UserInfo>{showLogInOut(login)}</UserInfo>
      </Container>
    </HeaderTopWrapper>
  )
}

export default HeaderTop
