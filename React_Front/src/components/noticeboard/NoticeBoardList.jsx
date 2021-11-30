import React from 'react'
import styled from 'styled-components'
import NoticeBoardItem from './NoticeBoardItem'
import data from '../../DB/NoticeData'

const BoardArticleWrapper = styled.div``

const NoticeBoardList = () => {
  return (
    <BoardArticleWrapper>
      {data.map((p, i) => (
        <NoticeBoardItem data={p} key={i} />
      ))}
    </BoardArticleWrapper>
  )
}

export default NoticeBoardList
