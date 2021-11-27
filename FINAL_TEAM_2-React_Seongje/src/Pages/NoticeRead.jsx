import React from 'react'
import { Container, Image } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const noticearticle = () => {
  return (
    <div className="article-read">
      <Container>
        <section className="board-title-wrapper">
          <div className="board-title">
            <h4>공지사항</h4>
          </div>
        </section>
        <div className="button-group">
          <Link to="/notice" className="list-btn">
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
            <span className="label">공지사항</span>
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
          </div>
        </section>
        <div className="button-group">
          <Link to="/notice" className="list-btn">
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

export default noticearticle
