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

const HeaderMid = ({ setBoard }) => {
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
              <Link
                onClick={() => {
                  setBoard('notice')
                }}
                to="/notice"
              >
                공지사항
              </Link>
            </NavItem>
            <NavItem>
              <Link
                onClick={() => {
                  setBoard('festival')
                }}
                to="/festival"
              >
                지역축제
              </Link>
            </NavItem>
            <NavItem>
              <Link
                onClick={() => {
                  setBoard('review')
                }}
                to="/review"
              >
                축제후기
              </Link>
            </NavItem>
            <NavItem>
              <Link
                onClick={() => {
                  setBoard('free')
                }}
                to="/free"
              >
                자유게시판
              </Link>
            </NavItem>
          </ul>
        </NavMenu>
      </Container>
    </HeaderMidWrapper>
  )
}

export default HeaderMid
