import React, { useEffect, useState } from 'react'
import { Container } from 'react-bootstrap'
import 'react-quill/dist/quill.snow.css'
import Editor from '../components/Editor'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { useHistory, useParams } from 'react-router'
import axios from 'axios'

const Update = () => {
  const { articleNo } = useParams()
  const article_no = articleNo
  const history = useHistory()

  const [article, setArticle] = useState({
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
  })

  useEffect(() => {
    axios
      .get(`http://localhost:9000/article/view.do?articleNo=${article_no}`)
      .then((res) => {
        setArticle(res.data)
      })
      .catch((error) => console.log(error))
  }, [setArticle])

  return (
    <div>
      <Container>
        <section className="input-wrapper">
          <div className="input-group">
            <label htmlFor="">
              제목
              <br />
              <input
                type="text"
                value={article.articleTitle}
                onChange={(e) =>
                  setArticle({ ...article, ['articleTitle']: e.target.value })
                }
              />
            </label>
            <label htmlFor="">
              작성자
              <br />
              <input
                type="text"
                value={article.userId}
                onChange={(e) =>
                  setArticle({ ...article, ['userId']: e.target.value })
                }
              />
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
