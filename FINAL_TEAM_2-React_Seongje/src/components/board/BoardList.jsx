import React from 'react'
import { Container } from 'react-bootstrap'
import styled from 'styled-components'

const Article = [
  {
    label: '공지사항',
    title: '제목1',
    name: '순이쵝오',
    resdate: '2021-11-12',
  },
  {
    label: '공지사항',
    title: '제목1',
    name: '순이쵝오',
    resdate: '2021-11-12',
  },
  {
    label: '공지사항',
    title: '제목1',
    name: '순이쵝오',
    resdate: '2021-11-12',
  },
]

const BoardArticleWrapper = styled.div`
  height: 92px;
`

const BoardList = () => {
  return (
    <div>
      <Container>
        <BoardArticleWrapper></BoardArticleWrapper>
      </Container>
    </div>
  )
}

export default BoardList
