import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { Container, Image } from 'react-bootstrap'
import { HandThumbsUp } from 'react-bootstrap-icons'
import StarRating from '../components/StarRating'

const ReviewRead = () => {
  const [number, setNumber] = useState(0)
  const increaseLike = () => {
    setNumber(number + 1)
  }
  console.log('좋아요가 1 증가합니다.')

  return (
    <div className="article-read">
      <Container>
        <section className="board-title-wrapper">
          <div className="board-title">
            <h4>축제후기</h4>
          </div>
        </section>
        <div className="button-group">
          <Link to="/review" className="list-btn">
            <button>목록</button>
          </Link>
          <div className="update-delete-btn">
            <Link to="update" className="update-btn">
              <button>수정</button>
            </Link>
            <Link to="write" className="write-btn">
              <button>글쓰기</button>
            </Link>
          </div>
        </div>
        <section className="view-wrapper">
          <div className="view-head">
            <span className="label">축제후기</span>
            <p className="view-title">
              2021년 전주 세계 소리 축제 다녀왔어요~~
            </p>
            <div className="view-head-info">
              <span className="writer">순이쵝오</span> <span>ㅣ</span>
              <span className="article-date">2021-11-12</span>
              <span>ㅣ</span> <span className="view-count">32</span>
            </div>
            <hr />
          </div>
          <div className="rating">
            <h4>평점</h4>
            <StarRating />
          </div>
          <div className="view-body">
            <div className="view-contents">
              집콕만 하다 2021 전주 소리축제에 다녀왔어용 전 세계의 다양한
              악기와 소리, 전주의 맛집 그리고 전주의 아름다운 풍경까지 함께
              즐기다 올 수 있어서 너무 만족 스러워요 ^^
              <br />
              <br />
              <Image
                src={require('../img/festival6.jpeg').default}
                alt="소리축제"
                fluid
              />
              <br />
            </div>
            <div className="middle-magic">
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
        <section className="comment-wrapper">
          <div className="comment-input">
            <textarea
              name="comment-input"
              id="comment-input"
              placeholder="인터넷은 우리가 함께 만들어가는 소중한 공간입니다."
            ></textarea>
          </div>
          <div className="comment-submit">
            <form action="">
              <button type="submit">
                <p>댓글쓰기</p>
              </button>
            </form>
          </div>
        </section>
        <section className="comment-list">
          <div className="comment-item">
            <p className="comment">정말요 너무 콧바람 쐬고 싶어요~~~~</p>
            <div className="comment-info">
              <span>신몬익화</span> <span>ㅣ</span> <span>2021-11-12</span>
            </div>
          </div>
        </section>
        <div className="button-group">
          <Link to="notice" className="list-btn">
            <button>목록</button>
          </Link>
          <div className="update-delete-btn">
            <Link to="update" className="update-btn">
              <button>수정</button>
            </Link>
            <Link to="write" className="write-btn">
              <button>글쓰기</button>
            </Link>
          </div>
        </div>
      </Container>
    </div>
  )
}

export default ReviewRead
