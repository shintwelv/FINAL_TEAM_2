import React, { useState } from 'react'
import { useHistory, Link } from 'react-router-dom'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'
import { Container, Image } from 'react-bootstrap'
import { HandThumbsUp } from 'react-bootstrap-icons'

const FreeRead = () => {
  const history = useHistory()

  const [number, setNumber] = useState(0)
  const increaseLike = () => {
    setNumber(number + 1)
  }
  console.log('좋아요가 1 증가합니다.')

  return (
    <div className="article-view">
      <Container>
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
            <span className="label">자유게시판</span>
            <p className="view-title">
              올 겨울에는 위드코로나 때문에 축제에 사람이 많겠지요?
            </p>
            <div className="view-head-info">
              <span className="writer">순이쵝오</span> <span>ㅣ</span>
              <span className="article-date">2021-11-12</span>
              <span>ㅣ</span> <span className="view-count">32</span>
            </div>
            <hr />
          </div>
          <div className="view-body">
            <div className="view-contents">
              사람 많아도 좋으니까 맘편히 놀러갈 수 있으면 좋겠는데.. 횐님덜..
              콧바람 쐬고 싶어요... ㅠㅠㅠ!
              <br />
              <br />
              <Image
                src={require('../img/cry.gif').default}
                alt="눈물범벅"
                fluid
              />
              <br />
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

export default FreeRead
