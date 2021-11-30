import React from 'react'
import { Link } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import styled from 'styled-components'

const HeaderMidWrapper = styled.div`
  height: 56px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  text-align: center;
  font-size: 24px;
  background-color: #0593f0;
  color: #fff;
  @media (max-width: 540px) {
    display: none;
  }
`
const NavMenu = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  text-align: center;
`

const NavItem = styled.li`
  display: inline-block;
  margin-right: 16px;
  &:last-child {
    margin: 0;
  }
`

const HeaderMid = () => {
  return (
    <HeaderMidWrapper>
      <Container>
        <NavMenu>
          <div>
            <Link to="/">
              <p>방방곡곡</p>
            </Link>
          </div>
          <ul>
            <NavItem>
              <Link to="notice">공지사항</Link>
            </NavItem>
            <NavItem>
              <Link to="festival">지역축제</Link>
            </NavItem>
            <NavItem>
              <Link to="review">축제후기</Link>
            </NavItem>
            <NavItem>
              <Link to="free">자유게시판</Link>
            </NavItem>
          </ul>
        </NavMenu>
      </Container>
    </HeaderMidWrapper>
  )
}

export default HeaderMid
