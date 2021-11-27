import React from 'react'
import { Link } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import { Justify, PersonCircle } from 'react-bootstrap-icons'
import styled from 'styled-components'

const MobileHeaderWrapper = styled.div`
  width: 100%;
  font-size: 24px;
  background-color: #0593f0;
  color: #fff;
`

const MobileMenu = styled.ul`
  height: 80px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  @media (min-width: 541px) {
    display: none;
  }
`

const MobileMenuItem = styled.li`
  list-style: none;
`

const MobileHeader = () => {
  return (
    <MobileHeaderWrapper>
      <Container>
        <MobileMenu>
          <MobileMenuItem>
            <Link to="">
              <Justify />
            </Link>
          </MobileMenuItem>
          <MobileMenuItem>
            <Link to="">
              <h4>방방곡곡</h4>
            </Link>
          </MobileMenuItem>
          <MobileMenuItem>
            <Link to="">
              <PersonCircle />
            </Link>
          </MobileMenuItem>
        </MobileMenu>
      </Container>
    </MobileHeaderWrapper>
  )
}

export default MobileHeader
