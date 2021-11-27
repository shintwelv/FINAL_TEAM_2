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
  font-size: 24px;
  font-weight: 700;
`

const BoardHeader = () => {
  return (
    <BoardTitleWrapper>
      <Title>
        <span>게시판</span>
      </Title>
    </BoardTitleWrapper>
  )
}

export default BoardHeader
