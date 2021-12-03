import React, { useState } from 'react'
import { Container, Form } from 'react-bootstrap'
import 'react-quill/dist/quill.snow.css'
import Editor from './Editor'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { useHistory } from 'react-router'
import styled from 'styled-components'
import axios from 'axios'

const TitleWriter = styled.input`
  type: text;
  border-bottom: 1px solid black;
`
// const config = {
//   headers: {
//     'content-Type': 'multipart/form-data',
//   },
// }

const Write = ({ login, board, userId, process, nickName }) => {
  const [article, setArticle] = useState({
    articleNo: null,
    articleCode: board,
    articleTitle: '',
    articleContent: '',
    userId: userId,
    writeDate: null,
    viewCount: 0,
    articleStar: 0.0,
    articleLike: 0,
    articleImage: null,
  })
  const history = useHistory()

  console.log(`process: ${process}`)

  const showEditor = (login) => {
    if (login) {
      return (
        <section className="text-editor">
          <Editor setArticle={setArticle} article={article} />
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

  const onFileChangeHandler = (e) => {
    e.preventDefault()
    article['articleImage'] = e.target.files[0]
  }

  const UpdateORWriteArticle = (process) => {
    // ['update', 'view', 'write']
    let processURL = ''

    if (process == 'update') {
      processURL = 'update.do'
    } else if (process == 'write') {
      processURL = 'insert.do'
    }

    axios
      .post(`http://localhost:9000/article/${processURL}`, article)
      .then((res) => {
        if (res.data === true) {
          alert('요청이 성공적으로 처리되었습니다')
        } else {
          alert('요청이 실패하였습니다')
        }
      })
      .catch((error) => console.log(error))
  }

  const showProcessButton = (process) => {
    // ['update', 'view', 'write']

    if (process == 'update') {
      return (
        <Button type="button" onClick={() => UpdateORWriteArticle('update')}>
          수정
        </Button>
      )
    } else if (process == 'write') {
      return (
        <Button type="button" onClick={() => UpdateORWriteArticle('write')}>
          등록
        </Button>
      )
    } else {
      return null
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
              <TitleWriter
                onChange={(e) =>
                  setArticle({ ...article, ['articleTitle']: e.target.value })
                }
              />
            </label>
            <label htmlFor="">
              작성자
              <br />
              <TitleWriter value={nickName} readOnly />
            </label>
          </div>
        </section>
        {showEditor(login)}
        <Form.Group controlId="articleImage" className="mb-3">
          <Form.Control
            type="file"
            onChange={onFileChangeHandler}
            name="articleImage"
            style={{ background: 'none', border: 'none' }}
          />
        </Form.Group>
        <ButtonGroupWrapper>
          <Button onClick={history.goBack}>목록</Button>
          <div>
            {showProcessButton(process)}
            <Button onClick={history.goBack}>목록</Button>
          </div>
        </ButtonGroupWrapper>
      </Container>
    </div>
  )
}

export default Write
