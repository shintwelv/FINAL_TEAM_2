import React from 'react'
import styled from 'styled-components'
import ReviewBoardItem from './ReviewBoardItem'
import data from '../../DB/ReviewData'
const BoardArticleWrapper = styled.div``

const BoardList = () => {
  return (
    <BoardArticleWrapper>
      {data.map((p, i) => (
        <ReviewBoardItem data={p} key={i} />
      ))}
    </BoardArticleWrapper>
  )
}

export default BoardList
