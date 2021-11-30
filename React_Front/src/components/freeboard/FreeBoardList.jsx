import React from 'react'
import FreeBoardItem from './FreeBoardItem'
import data from '../../DB/FreeData'
import styled from 'styled-components'

const BoardArticleWrapper = styled.div``

const BoardList = () => {
  return (
    <BoardArticleWrapper>
      {data.map((p, i) => (
        <FreeBoardItem data={p} key={i} />
      ))}
    </BoardArticleWrapper>
  )
}

export default BoardList
