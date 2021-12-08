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

const Write = ({ login, board, process, userInfo }) => {
  const [article, setArticle] = useState({
    articleNo: 0,
    articleCode: board,
    articleTitle: '',
    articleContent: '',
    userId: userInfo.userId,
    writeDate: Date(),
    viewCount: 0,
    articleStar: 0.0,
    articleLike: 0,
    Image: null,
    festivalDuration: null,
    festivalFee: 0,
    festivalLocation: null,
    festivalName: null,
    festivalOwner: null,
  })
  const history = useHistory()

  const { articleNo } = useParams()
  const [article_no, setArticle_no] = useState(articleNo)

  useEffect(() => {
    if (article_no) {
      console.log('########### WRITE / UPDATE ############')
      console.log(`articleNo: ${article_no}`)
      console.log(`process: ${process}`)
      console.log(`board: ${board}`)
      console.log('useEffect() if문 호출')
      axios
        .get(`http://localhost:9000/article/view.do?articleNo=${article_no}`)
        .then((res) => {
          console.log(res.data)
          setArticle(res.data)
        })
        .catch((error) => console.log(error))
    }
  }, [article_no])

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
              name="Image"
              style={{ background: 'none', border: 'none' }}
            />
          </Form.Group>
        </>
      )
    } else {
      history.push('/')
      // return (
      //   <div>
      //     <span>권한이 없습니다</span>
      //   </div>
      // )
    }
  }

  const onFileChangeHandler = (e) => {
    e.preventDefault()
    article['Image'] = e.target.files[0]
    console.log(article)
  }

  const UpdateORWriteArticle = (process) => {
    // ['update', 'view', 'write']
    const parseDate = new Date(article.writeDate)

    setArticle({
      ...article,
      writeDate: parseDate,
    })

    let formData = new FormData()

    for (var key in article) {
      formData.append(key, article[key])
    }

    formData.set('writeDate', parseDate)

    let processURL = ''

    if (process == 'update') {
      processURL = 'update.do'
    } else if (process == 'write') {
      processURL = 'insert.do'
    }

    processURL = `http://localhost:9000/article/${processURL}`
    axios
      .post(processURL, formData)
      .then((res) => {
        if (res.data === true) {
          alert('요청이 성공적으로 처리되었습니다')
          history.push(`/`)
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
                value={article.articleTitle}
              />
            </label>
            <label htmlFor="">
              작성자
              <br />
              <TitleWriter value={userInfo.nickName} readOnly />
            </label>
          </div>
        </section>
        {showEditor(login)}

        <ButtonGroupWrapper>
          <Button onClick={history.goBack}>목록</Button>
          <div>{showProcessButton(process)}</div>
        </ButtonGroupWrapper>
      </Container>
    </div>
  )
}

export default Write
