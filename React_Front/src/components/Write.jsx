import React, { useEffect, useState } from 'react'
import { Container, Form } from 'react-bootstrap'
import 'react-quill/dist/quill.snow.css'
import Editor from './Editor'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { useHistory, useParams } from 'react-router'
import styled from 'styled-components'
import axios from 'axios'

const TitleWriter = styled.input`
  type: text;
  border-bottom: 1px solid black;
`
const config = {
  headers: {
    'content-Type': 'multipart/form-data',
  },
}

const Write = ({ login, board, process, userInfo }) => {
  const [article, setArticle] = useState({
    articleNo: 0,
    articleCode: board,
    articleTitle: '',
    articleContent: '',
    userId: userInfo.user_id,
    writeDate: Date(),
    viewCount: 0,
    articleStar: 0.0,
    articleLike: 0,
    Image: null,
  })
  const history = useHistory()

  const { articleNo } = useParams()
  const [article_no, setArticle_no] = useState(articleNo)

  console.log('########### WRITE / UPDATE ############')
  console.log(`articleNo: ${article_no}`)
  console.log(`process: ${process}`)
  console.log(`board: ${board}`)

  useEffect(() => {
    if (article_no) {
      console.log('useEffect() if문 호출')
      axios
        .get(`http://localhost:9000/article/view.do?articleNo=${article_no}`)
        .then((res) => {
          console.log(res.data)
          setArticle(res.data)
        })
        .catch((error) => console.log(error))
    }
  }, [setArticle_no])

  const showEditor = (login) => {
    if (login) {
      return (
        <>
          <section className="text-editor">
            <Editor setArticle={setArticle} article={article} />
          </section>
          <Form.Group controlId="articleImage" className="mb-3">
            <Form.Control
              type="file"
              onChange={onFileChangeHandler}
              name="articleImage"
              style={{ background: 'none', border: 'none' }}
            />
          </Form.Group>
        </>
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
    article['Image'] = e.target.files[0]
    console.log(article)
  }

  const UpdateORWriteArticle = (process) => {
    // ['update', 'view', 'write']

    let formData = new FormData()

    for (var key in article) {
      formData.append(key, article[key])
    }

    let processURL = ''

    if (process == 'update') {
      processURL = 'update.do'
    } else if (process == 'write') {
      processURL = 'insert.do'
    }

    if (board == 'notice') {
      processURL = `notice/${processURL}`
      if (process == 'update') {
        processURL = `../${processURL}`
      }
      axios
        .post(processURL, formData, config)
        .then((res) => {
          if (res.data === true) {
            alert('요청이 성공적으로 처리되었습니다')
          } else {
            alert('요청이 실패하였습니다')
          }
        })
        .catch((error) => console.log(error))
    } else {
      processURL = `http://localhost:9000/article/${processURL}`
      axios
        .post(processURL, formData)
        .then((res) => {
          if (res.data === true) {
            alert('요청이 성공적으로 처리되었습니다')
          } else {
            alert('요청이 실패하였습니다')
          }
        })
        .catch((error) => console.log(error))
    }
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
                value={article.articleTitle}
              />
            </label>
            <label htmlFor="">
              작성자
              <br />
              <TitleWriter value={userInfo.nickname} readOnly />
            </label>
          </div>
        </section>
        {showEditor(login)}

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
