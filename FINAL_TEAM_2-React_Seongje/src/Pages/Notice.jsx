import React from 'react'
import { Link } from 'react-router-dom'
import { Container } from 'react-bootstrap'
import { ChevronLeft, ChevronRight } from 'react-bootstrap-icons'
import EllipsisText from 'react-ellipsis-text'
import PageController from '../components/PageController'
import BoardTitle from '../components/board/BoardTitle'
import { ButtonGroupWrapper, Button } from '../components/ButtonGroup'

const Notice = () => {
  return (
    <div>
      <div className="board">
        <Container>
          <BoardTitle />
          <ButtonGroupWrapper>
            <Button type="button">글쓰기</Button>
          </ButtonGroupWrapper>
          <section className="article-list-wrapper">
            <ul>
              <Link to="/noticeread">
                <li className="article-list">
                  <span className="label">공지사항</span>
                  <div className="article-group">
                    <div className="article-title">
                      <span>
                        <EllipsisText
                          text={
                            '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                          }
                          length={23}
                        />
                      </span>
                    </div>
                    <div className="article-date">2021-11-15</div>
                  </div>
                  <div className="article-info">
                    <div className="writer">관리자</div>
                    <div>ㅣ</div>
                    <div className="view-count">조회수: 32</div>
                  </div>
                </li>
              </Link>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
              <li className="article-list">
                <span className="label">공지사항</span>
                <div className="article-group">
                  <div className="article-title">
                    <span>
                      <EllipsisText
                        text={
                          '2021 집콕! 어린이 소리축제 체험키트 사전 신청 안내 [신청마감]'
                        }
                        length={23}
                      />
                    </span>
                  </div>
                  <div className="article-date">2021-11-15</div>
                </div>
                <div className="article-info">
                  <div className="writer">관리자</div>
                  <div>ㅣ</div>
                  <div className="view-count">조회수: 32</div>
                </div>
              </li>
            </ul>
          </section>
          <ButtonGroupWrapper>
            <Button type="button">글쓰기</Button>
          </ButtonGroupWrapper>
          <PageController />
          <div className="paigination-wrapper">
            <ul className="paigination">
              <li>
                <a href="http://www.naver.com">
                  <ChevronLeft />
                  이전
                </a>
              </li>
              <li>
                <a href="http://www.naver.com">
                  <span id="page-number">1</span>
                </a>
              </li>
              <li>
                <a href="http://www.naver.com">
                  <span id="page-number">2</span>
                </a>
              </li>
              <li>
                <a href="http://www.naver.com">
                  <span id="page-number">3</span>
                </a>
              </li>
              <li>
                <a href="http://www.naver.com">
                  <span id="page-number">4</span>
                </a>
              </li>
              <li>
                <a href="http://www.naver.com">
                  <span id="page-number">5</span>
                </a>
              </li>
              <li>
                <a href="http://www.naver.com">
                  다음
                  <ChevronRight />
                </a>
              </li>
            </ul>
          </div>
        </Container>
      </div>
    </div>
  )
}

export default Notice
