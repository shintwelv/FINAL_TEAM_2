import React from 'react'
import { Container } from 'react-bootstrap'
import NoticeTitle from '../components/noticeboard/NoticeBoardTitle'
import NoticeBoardList from '../components/noticeboard/NoticeBoardList'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import PageController from '../components/PageController'
import { Link } from 'react-router-dom'

const Notice = ({ setBoard }) => {
  const setBoardProp = () => {
    setBoard('notice')
  }

  return (
    <Container>
      <NoticeTitle />
      <ButtonGroupWrapper>
        <Button type="button" onClick={setBoardProp}>
          <Link to="write">글쓰기</Link>
        </Button>
      </ButtonGroupWrapper>
      <NoticeBoardList />
      <ButtonGroupWrapper>
        <Button type="button" onClick={setBoardProp}>
          <Link to="write">글쓰기</Link>
        </Button>
      </ButtonGroupWrapper>
      <PageController />
    </Container>
  )
}

export default Notice
