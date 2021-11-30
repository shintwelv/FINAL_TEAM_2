import React from 'react'
import { Container } from 'react-bootstrap'
import ReviewBoardTitle from '../components/reviewboard/ReviewBoardTitle'
import ReviewBoardList from '../components/reviewboard/ReviewBoardList'
import PageController from '../components/PageController'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { Link } from 'react-router-dom'

const Review = ({ setBoard }) => {
  const setBoardProp = () => {
    setBoard('review')
  }

  return (
    <Container>
      <ReviewBoardTitle />
      <ButtonGroupWrapper>
        <Button type="button" onClick={setBoardProp}>
          <Link to="write">글쓰기</Link>
        </Button>
      </ButtonGroupWrapper>
      <ReviewBoardList />
      <ButtonGroupWrapper>
        <Button type="button" onClick={setBoardProp}>
          <Link to="write">글쓰기</Link>
        </Button>
      </ButtonGroupWrapper>
      <PageController />
    </Container>
  )
}

export default Review
