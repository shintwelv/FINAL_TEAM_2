import React from 'react'
import { Container } from 'react-bootstrap'
import 'react-quill/dist/quill.snow.css'
import Editor from '../components/Editor'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { useHistory } from 'react-router'

const Update = () => {
  const history = useHistory()
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
        <section className="text-editor">
          <Editor />
        </section>
        <ButtonGroupWrapper>
          <div>
            <Button type="submit">수정</Button>
            <Button onClick={history.goBack}>취소</Button>
          </div>
        </ButtonGroupWrapper>
      </Container>
    </div>
  )
}

export default Update
