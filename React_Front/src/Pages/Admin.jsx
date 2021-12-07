import React from 'react'
import { Container } from 'react-bootstrap'
import styled from 'styled-components'

const BoardTitleWrapper = styled.div`
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
`
const AdminButtonWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 32px 0;
`

const AdminButton = styled.button`
  width: 240px;
  height: 80px;
  border-radius: 8px;
  font-weight: 700px;
  font-size: 32px;
  background-color: #0593f0;
  margin-bottom: 32px;
  color: white;
`

const Admin = () => {
  return (
    <Container>
      <BoardTitleWrapper>
        <h4>관리자</h4>
      </BoardTitleWrapper>
      <AdminButtonWrapper>
        <AdminButton>회원관리</AdminButton>
        <AdminButton>게시글관리</AdminButton>
        <AdminButton>인수인계</AdminButton>
      </AdminButtonWrapper>
    </Container>
  )
}

export default Admin
