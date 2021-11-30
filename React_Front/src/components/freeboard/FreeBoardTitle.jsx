import React from 'react'
import styled from 'styled-components'

export const BoardTitleWrapper = styled.div`
  height: 80px;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
`
const Title = styled.div`
  color: #0593f0;
  font-size: 24px;
  font-weight: 700;
`

const BoardHeader = () => {
  return (
    <BoardTitleWrapper>
      <Title>자유게시판</Title>
    </BoardTitleWrapper>
  )
}

export default BoardHeader
