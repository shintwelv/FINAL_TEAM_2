import React, { useEffect, useState } from 'react'
import styled from 'styled-components'
import BoardItem from '../components/Board/BoardItem'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import PageController from '../components/PageController'
import { Container } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import axios from 'axios'

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
  console.log(`board : ${boardType}`)

  let result = ''

  boardTypes.forEach((k) => {
    if (k[0] == boardType) {
      result = k[1]
    }
  })

  return result
}

const Board = ({ board, process, setProcess, login }) => {
  const [page, setPage] = useState(0)
  const [size, setSize] = useState(3)
  const [articleNum, setArticleNum] = useState(0)
  const [articleList, setArticeList] = useState([
    {
      articleCode: '',
      articleContent: '',
      articleImage: '',
      articleLike: 0,
      articleNo: 0,
      articleStar: 0,
      articleTitle: '',
      festivalDuration: null,
      festivalFee: 0,
      festivalLocation: null,
      festivalName: null,
      festivalOwner: null,
      userId: '',
      viewCount: 0,
      writeDate: 0,
    },
  ])

  const showWriteButton = (login) => {
    if (login && board != 'notice') {
      return (
        <ButtonGroupWrapper>
          <Button type="button" onClick={() => setProcess('write')}>
            <Link to="/write">글쓰기</Link>
          </Button>
        </ButtonGroupWrapper>
      )
    }
  }

  useEffect(() => {
    let processURL = ''
    let totalCountURL = ''
    if (board == 'notice') {
      totalCountURL = `notice/getArticleNum.do`
      processURL = `notice/pageNation.do?page=${page}&size=${size}`
    } else {
      totalCountURL = `http://localhost:9000/article/getArticleNum.do?articleCode=${board}`
      processURL = `http://localhost:9000/article/page.do?articleCode=${board}&page=${page}&size=${size}`
    }

    axios
      .get(totalCountURL)
      .then((res) => {
        setArticleNum(res.data)
        console.log(res.data)
      })
      .catch((error) => console.log(error))

    axios
      .get(processURL)
      .then((res) => setArticeList(res.data))
      .catch((error) => {
        console.log(error)
      })
  }, [board, page])

  return (
    <Container>
      <BoardTitleWrapper>
        <Title>{determineBoardTitle(board)}</Title>
      </BoardTitleWrapper>
      {showWriteButton(login)}
      <BoardArticleWrapper>
        {articleList.map((data) => (
          <BoardItem data={data} />
        ))}
      </BoardArticleWrapper>
      {showWriteButton(login)}
      <PageController
        page={page + 1}
        setPage={setPage}
        totalPage={
          articleNum % size > 0
            ? (articleNum - (articleNum % size)) / size + 1
            : articleNum / size
        }
        size={size}
        articleNum={articleNum}
      />
    </Container>
  )
}

export default Board
