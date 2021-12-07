import React from 'react'
import BoardItem from './BoardItem'
import data from '../../DB/FreeData'
import styled from 'styled-components'

const BoardArticleWrapper = styled.div``

const BoardList = () => {
  return (
    <BoardArticleWrapper>
      {data.map((p, i) => (
        <BoardItem data={p} key={i} />
      ))}
    </BoardArticleWrapper>
  )
}

export default BoardList
