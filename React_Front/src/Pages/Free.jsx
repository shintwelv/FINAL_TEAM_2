import React from 'react'
import { Container } from 'react-bootstrap'
import FreeBoardTitle from '../components/freeboard/FreeBoardTitle'
import FreeBoardList from '../components/freeboard/FreeBoardList'
import PageController from '../components/PageController'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { Link } from 'react-router-dom'

const Free = ({ setBoard }) => {
  const setBoardProp = () => {
    setBoard('free')
  }

  return (
    <Container>
      <FreeBoardTitle />
      <ButtonGroupWrapper>
        <Button type="button" onClick={setBoardProp}>
          <Link to="write">글쓰기</Link>
        </Button>
      </ButtonGroupWrapper>
      <FreeBoardList />
      <ButtonGroupWrapper>
        <Button type="button" onClick={setBoardProp}>
          글쓰기
        </Button>
      </ButtonGroupWrapper>
      <PageController />
    </Container>
  )
}

export default Free
