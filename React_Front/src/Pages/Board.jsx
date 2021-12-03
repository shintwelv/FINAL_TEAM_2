import React, { useEffect } from 'react'
import styled from 'styled-components'
import BoardItem from '../components/Board/BoardItem'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import PageController from '../components/PageController'
import { Container } from 'react-bootstrap'
import { Link } from 'react-router-dom'

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
const BoardArticleWrapper = styled.div``

const boardTypes = [
  ['notice', '공지사항'],
  ['free', '자유게시판'],
  ['review', '축제후기'],
]

const determineBoardTitle = (boardType) => {
  //notice, free, review
  console.log(`boardType : ${boardType}`)

  let result = ''

  boardTypes.forEach((k) => {
    if (k[0] == boardType) {
      console.log(`title: ${k[1]}`)
      result = k[1]
    }
  })

  return result
}

const Board = ({ data, setBoard, board, process, setProcess }) => {
  return (
    <Container>
      <BoardTitleWrapper>
        <Title>{determineBoardTitle(board)}</Title>
      </BoardTitleWrapper>
      <ButtonGroupWrapper>
        <Button type="button" onClick={() => setProcess('write')}>
          <Link to="/write">글쓰기</Link>
        </Button>
      </ButtonGroupWrapper>
      <BoardArticleWrapper>
        {/* {data.map((p, i) => (
          <BoardItem data={p} key={i} />
        ))} */}
      </BoardArticleWrapper>
      <ButtonGroupWrapper>
        <Button type="button" onClick={() => setProcess('write')}>
          <Link to="/write">글쓰기</Link>
        </Button>
      </ButtonGroupWrapper>
      <PageController />
    </Container>
  )
}

export default Board
