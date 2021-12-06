import React from 'react'
import { Link } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import styled from 'styled-components'

const FooterWrapper = styled.footer`
  height: 160px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #0593f0;
  color: #fff;
`

const FooterMenu = styled.ul`
  text-align: center;
  font-size: 16px;
  @media (max-width: 375px) {
    font-size: 12px;
  } ;
`

const FooterMenuItem = styled.li`
  margin-bottom: 8px;
  &::last-child {
    margin: 0;
  }
`

const Footer = () => {
  return (
    <FooterWrapper>
      <Container>
        <FooterMenu>
          <FooterMenuItem>
            <Link to="/">방방곡곡</Link>
          </FooterMenuItem>
          <FooterMenuItem>
            <Link to="/">지역축제</Link>
          </FooterMenuItem>
          <FooterMenuItem>
            <Link to="/">축제후기</Link>
          </FooterMenuItem>
          <FooterMenuItem>
            <span>Copyright 2021. KOSMO Team 2. All rights reserved</span>
          </FooterMenuItem>
        </FooterMenu>
      </Container>
    </FooterWrapper>
  )
}

export default Footer
