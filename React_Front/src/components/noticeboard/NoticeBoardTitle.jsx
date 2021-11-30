import React from 'react'
import styled from 'styled-components'

const BoardTitleWrapper = styled.div`
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
      <Title>공지사항</Title>
    </BoardTitleWrapper>
  )
}

export default BoardHeader
