import React from 'react'
import styled from 'styled-components'

const NotFoundWrapper = styled.div`
  height: auto;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #f86d7d;
`

export const NotFound = () => {
  return (
    <NotFoundWrapper>
      <h1>존재하지 않는 페이지입니다.</h1>
    </NotFoundWrapper>
  )
}

export default NotFound
