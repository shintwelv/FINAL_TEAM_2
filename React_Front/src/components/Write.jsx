import React from 'react'
import { Container } from 'react-bootstrap'
import 'react-quill/dist/quill.snow.css'
import Editor from './Editor'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { useHistory } from 'react-router'

const Write = ({ login, board }) => {
  console.log(board)
  const history = useHistory()

  const showEditor = (login) => {
    if (login) {
      return (
        <section className="text-editor">
          <Editor />
        </section>
      )
    } else {
      return (
        <div>
          <span>권한이 없습니다</span>
        </div>
      )
    }
  }

  return (
    <div>
      <Container>
        <section className="input-wrapper">
          <div className="input-group">
            <label htmlFor="">
              제목
              <br />
              <input type="text" />
            </label>
            <label htmlFor="">
              작성자
              <br />
              <input type="text" />
            </label>
          </div>
        </section>
        {/* <section className="text-editor">
          <Editor />
        </section> */}
        {showEditor(login)}
        <ButtonGroupWrapper>
          <Button onClick={history.goBack}>목록</Button>
          <div>
            <Button type="submit">글쓰기</Button>
            <Button>취소</Button>
          </div>
        </ButtonGroupWrapper>
      </Container>
    </div>
  )
}

export default Write
