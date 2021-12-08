import React, { useEffect, useState } from 'react'
import { useHistory, Link } from 'react-router-dom'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { Container, Image } from 'react-bootstrap'
import { HandThumbsUp } from 'react-bootstrap-icons'
import StarRating from '../components/StarRating'
import { useParams } from 'react-router'
import axios from 'axios'
import ReactQuill from 'react-quill'
import 'react-quill/dist/quill.bubble.css'

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

const showRating = (board) => {
  if (board != 'notice') {
    return (
      <div className="rating">
        <h4>평점</h4>
        <StarRating />
      </div>
    )
  }
}

const Read = ({ board, userInfo, login, setProcess }) => {
  const { articleNo } = useParams()
  const article_no = articleNo

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

  const [writerInfo, setWriterInfo] = useState({
    admin: '',
    birth: 0,
    email: '',
    gender: '',
    nickname: '',
    phone_number: '',
    profile_image: '',
    user_basic_address: '',
    user_detail_address: '',
    user_id: '',
    user_name: '',
    user_pw: '',
  })

  const [replies, setReplies] = useState([
    {
      replyNo: 0,
      articleCode: '',
      articleNo: 0,
      replyContent: '',
      userId: '',
      writeDate: 0,
      replyRating: 0.0,
    },
  ])

  const [newReply, setNewReply] = useState({
    replyNo: 0,
    articleCode: board,
    articleNo: 0,
    replyContent: '',
    userId: userInfo.userId,
    writeDate: new Date(),
    replyRating: 0.0,
  })
  const history = useHistory()

  const [number, setNumber] = useState(0)
  const increaseLike = () => {
    setNumber(number + 1)
  }

  useEffect(() => {
    axios
      .get(`http://localhost:9000/article/view.do?articleNo=${article_no}`)
      .then((res) => {
        setArticle(res.data)
        setNewReply({
          ...newReply,
          articleNo: res.data.articleNo,
        })
      })
      .catch((error) => console.log(error))

    axios
      .get(
        `http://localhost:9000/reply/page.do?articleNo=${article_no}&size=100&page=0`
      )
      .then((res) => setReplies(res.data))
      .catch((error) => console.log(error))
  }, [])

  // const getArticleInfo = (article_no) => {
  //   axios
  //     .get(`http://localhost:9000/article/view.do?articleNo=${article_no}`)
  //     .then((res) => {
  //       setArticle(res.data)
  //     })
  //     .catch((error) => console.log(error))
  // }

  const getWriterInfo = (user_id) => {
    axios
      .get(`../user/findUser?user_id=${user_id}`)
      .then((res) => setWriterInfo(res.data))
      .catch((error) => console.log(error))
  }

  const showModifyDelete = () => {
    if (login && article.userId == userInfo.userId) {
      return (
        <div>
          <Button type="button" onClick={() => setProcess('update')}>
            <Link to={`/update/${articleNo}`}>수정</Link>
          </Button>
          <Button type="button" onClick={() => deleteArticle(board, article)}>
            삭제
          </Button>
        </div>
      )
    }
  }

  const deleteArticle = (board, article) => {
    alert('삭제하시겠습니까?')

    let formData = new FormData()
    let processURL = ''

    // for (var key in article) {
    //   formData.append(key, article[key])
    // }

    formData.append('articleNo', article['articleNo'])

    // if (board == 'notice') {
    //   processURL = '../notice/delete.do'
    // } else {
    // }
    processURL = 'http://localhost:9000/article/delete.do'

    axios
      .post('http://localhost:9000/reply/deleteReplies.do', formData)
      .then((res) => {
        if (res.data) {
        } else {
          alert('요청이 실패했습니다')
        }
      })
      .then(
        axios
          .post('http://localhost:9000/article/delete.do', formData)
          .then((res) => {
            if (res.data) {
              alert('요청을 처리했습니다')
              history.push(`/${board}`)
            } else {
              alert('처리에 실패했습니다')
            }
          })
      )
      .catch((error) => console.log(error))
  }

  const makeReply = () => {
    console.log(newReply)
    const formData = new FormData()

    for (var key in newReply) {
      formData.append(key, newReply[key])
    }

    axios
      .post('http://localhost:9000/reply/insert.do', formData)
      .then((res) => {
        alert('요청이 처리되었습니다')
        console.log(res)
        history.push(`/${board}`)
      })
      .catch((error) => console.log(error))
  }

  const showReplyEditor = (login) => {
    if (login && board != 'notice') {
      return (
        <section className="comment-wrapper">
          <div className="comment-input">
            <textarea
              name="comment-input"
              id="comment-input"
              placeholder="인터넷은 우리가 함께 만들어가는 소중한 공간입니다."
              className=""
              onChange={(e) =>
                setNewReply({ ...newReply, ['replyContent']: e.target.value })
              }
            ></textarea>
          </div>
          <div className="comment-submit" onClick={makeReply}>
            <form action="">
              <button type="button">
                <p>댓글쓰기</p>
              </button>
            </form>
          </div>
        </section>
      )
    }
  }

  const showReplyDiv = (board) => {
    if (board != 'notice') {
      return (
        <section className="comment-list">
          {replies.map((reply) => (
            <div className="comment-item">
              <div className="comment">{reply.replyContent}</div>
              <div className="comment-info">
                <span>{reply.userId}</span> <span>ㅣ</span>{' '}
                <span>{`${new Date(reply.writeDate).getFullYear()}-${new Date(
                  reply.writeDate
                ).getMonth()}-${new Date(reply.writeDate).getDate()}`}</span>
              </div>
            </div>
          ))}
        </section>
      )
    }
  }

  return (
    <div className="article-read">
      <Container>
        <ButtonGroupWrapper>
          <Button onClick={history.goBack}>목록</Button>
          {showModifyDelete()}
        </ButtonGroupWrapper>
        <section className="view-wrapper">
          <div className="view-head">
            <span className="label">{determineBoardTitle(board)}</span>
            <p className="view-title">{article.articleTitle}</p>
            <div className="view-head-info">
              <span className="writer">{article.userId}</span> <span>ㅣ</span>
              <span className="article-date">{`${new Date(
                article.writeDate
              ).getFullYear()}-${new Date(
                article.writeDate
              ).getMonth()}-${new Date(article.writeDate).getDate()}`}</span>
              <span>ㅣ</span>{' '}
              <span className="view-count">{article.viewCount}</span>
            </div>
            <hr />
          </div>
          {/* {showRating(board)} */}
          <div className="view-body">
            <div className="view-contents">
              <ReactQuill
                onChange={() => {}}
                value={article.articleContent}
                theme="bubble"
                readOnly
              />
              <br />
              <Image
                src={'../img/' + article.articleImage}
                alt="poster"
                fluid
              />
            </div>
            <div className="middle-magic ">
              <div className="like-button-wrapper">
                <div className="like-button">
                  <div className="like-count">{number}</div>
                  <button onClick={increaseLike}>
                    <HandThumbsUp className="like-logo" />
                  </button>
                </div>
              </div>
            </div>
          </div>
        </section>
        {showReplyEditor(login)}
        {showReplyDiv(board)}
        <ButtonGroupWrapper>
          <Button onClick={history.goBack}>목록</Button>
          {showModifyDelete()}
        </ButtonGroupWrapper>
      </Container>
    </div>
  )
}

export default Read
