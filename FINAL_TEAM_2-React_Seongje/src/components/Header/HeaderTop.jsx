import React from 'react'
import { Link } from 'react-router-dom'
import { Container } from 'react-bootstrap'

import styled from 'styled-components'

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

const HeaderTop = () => {
  return (
    <HeaderTopWrapper>
      <Container>
        <UserInfo>
          <UserInfoItem>
            <Link to="LogIn">로그인</Link>
          </UserInfoItem>
          <UserInfoItem>
            <Link to="SignUp">회원가입</Link>
          </UserInfoItem>
          <UserInfoItem>
            <Link to="MyPage">마이페이지</Link>
          </UserInfoItem>
        </UserInfo>
      </Container>
    </HeaderTopWrapper>
  )
}

export default HeaderTop
