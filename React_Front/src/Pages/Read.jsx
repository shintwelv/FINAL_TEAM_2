import React, { useState } from 'react'
import { useHistory, Link } from 'react-router-dom'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { Container, Image } from 'react-bootstrap'
import { HandThumbsUp } from 'react-bootstrap-icons'
import StarRating from '../components/StarRating'

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

const Read = ({ board }) => {
  const history = useHistory()

  const [number, setNumber] = useState(0)
  const increaseLike = () => {
    setNumber(number + 1)
  }

  return (
    <div className="article-read">
      <Container>
        <section className="board-title-wrapper">
          <div className="board-title">
            <h4>{determineBoardTitle(board)}</h4>
          </div>
        </section>
        <ButtonGroupWrapper>
          <Button onClick={history.goBack}>목록</Button>
          <div>
            <Button type="button">
              <Link to="update">수정</Link>
            </Button>
            <Button topye="submit">삭제</Button>
          </div>
        </ButtonGroupWrapper>
        <section className="view-wrapper">
          <div className="view-head">
            <span className="label">{determineBoardTitle(board)}</span>
            <p className="view-title">
              2021 집콕! 어린이 소리축제 체험키트 사전 신처어 안내 [신청마감]
            </p>
            <div className="view-head-info">
              <span className="writer">관리자</span> <span>ㅣ</span>
              <span className="article-date">2021-11-12</span>
              <span>ㅣ</span> <span className="view-count">12</span>
            </div>
            <hr />
          </div>
          <div className="rating">
            <h4>평점</h4>
            <StarRating />
          </div>
          <div className="view-body">
            <div className="view-contents">
              <p>
                집콕 ! 어린이 소리 축제 체험키트는 어린이 소리 축제를 각
                가정에서 즐길 수 있게 구성한 프로그램으로 어린이들이 부모님과
                함께 집에서 직접 악기를 만들고 즐길 수 있는 체험 키트 입니다.
                그동안 장구, 북 가야금 등 전통악기로 느겼던 우리 소리를
                서양악기인 ‘칼림바’를 만들고 연주하여 재미와 감동을 느껴보세요
              </p>
              <br />
              <p>■신청기간 : 2021.11.10 (수) ~ 2021.12.08(수) </p>
              <p>■신청수량 : 200개 사전예약 한정 (1인당 1개) </p>
              <br />
              <Image
                src={require('../img/집콕어린이소리축제.jpeg').default}
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
        <section className="comment-wrapper">
          <div className="comment-input">
            <textarea
              name="comment-input"
              id="comment-input"
              placeholder="인터넷은 우리가 함께 만들어가는 소중한 공간입니다."
              className=""
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
            <div className="comment">정말요 너무 콧바람 쐬고 싶어요~~~~</div>
            <div className="comment-info">
              <span>신몬익화</span> <span>ㅣ</span> <span>2021-11-12</span>
            </div>
          </div>
          <div className="comment-item">
            <div className="comment">정말요 너무 콧바람 쐬고 싶어요~~~~</div>
            <div className="comment-info">
              <span>신몬익화</span> <span>ㅣ</span> <span>2021-11-12</span>
            </div>
          </div>
          <div className="comment-item">
            <div className="comment">정말요 너무 콧바람 쐬고 싶어요~~~~</div>
            <div className="comment-info">
              <span>신몬익화</span> <span>ㅣ</span> <span>2021-11-12</span>
            </div>
          </div>
          <div className="comment-item">
            <div className="comment">정말요 너무 콧바람 쐬고 싶어요~~~~</div>
            <div className="comment-info">
              <span>신몬익화</span> <span>ㅣ</span> <span>2021-11-12</span>
            </div>
          </div>
          <div className="comment-item">
            <div className="comment">정말요 너무 콧바람 쐬고 싶어요~~~~</div>
            <div className="comment-info">
              <span>신몬익화</span> <span>ㅣ</span> <span>2021-11-12</span>
            </div>
          </div>
        </section>
        <ButtonGroupWrapper>
          <Button onClick={history.goBack}>목록</Button>
          <div>
            <Button type="button">
              <Link to="update">수정</Link>
            </Button>
            <Button topye="submit">삭제</Button>
          </div>
        </ButtonGroupWrapper>
      </Container>
    </div>
  )
}

export default Read
