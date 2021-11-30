import React from 'react'
import './css/main.css'
import { Link } from 'react-router-dom'
import {
  Carousel,
  Col,
  Container,
  Image,
  ListGroup,
  Row,
  Table,
} from 'react-bootstrap'
import { Plus } from 'react-bootstrap-icons'
import EllipsisText from 'react-ellipsis-text'

function Main(props) {
  return (
    <Container>
      <Row className="mt-3">
        <Col xs={12}>
          <Carousel
            indicators=""
            prevIcon=""
            prevLabel=""
            nextIcon=""
            nextLabel=""
          >
            {/* 사진의 사이즈가 모두 같아야 함 */}
            <Carousel.Item>
              <Image
                className="d-block w-100 festival-slide-image"
                src={require('../img/festival7.jpeg').default}
                alt="축제사진"
                fluid
              ></Image>
            </Carousel.Item>
            <Carousel.Item>
              <Image
                className="d-block w-100 festival-slide-image"
                src={require('../img/festival3.jpg').default}
                alt="축제사진"
              ></Image>
            </Carousel.Item>
            <Carousel.Item>
              <Image
                className="d-block w-100 festival-slide-image"
                src={require('../img/festival5.jpg').default}
                alt="축제사진"
              ></Image>
            </Carousel.Item>
          </Carousel>
        </Col>
      </Row>
      <Row className="mt-3">
        <Col xs={12} xl={{ span: 6, offset: 3 }}>
          <Table borderless>
            <thead className="main-board-title">
              <tr>
                <td>공지사항</td>
                <td className="main-board-more">
                  <Plus />
                </td>
              </tr>
            </thead>
            <tbody className="main-board-content">
              <tr>
                <td>
                  <EllipsisText text={'10월의 FAQ입니다.'} length={'20'} />
                </td>
                <td>2021-11-22</td>
              </tr>
              <tr>
                <td>
                  <EllipsisText
                    text={
                      '11월을 맞이하여 전국에서 열리는 축제를 소개해드립니다'
                    }
                    length={'20'}
                  />
                </td>
                <td>2021-11-02</td>
              </tr>
              <tr>
                <td>
                  <EllipsisText
                    text={'가을 단풍이 예쁘게 물들었습니다'}
                    length={'20'}
                  />
                </td>
                <td>2021-11-02</td>
              </tr>
              <tr>
                <td>
                  <EllipsisText
                    text={'10월 이벤트 당첨자입니다'}
                    length={'20'}
                  />
                </td>
                <td>2021-11-02</td>
              </tr>
            </tbody>
          </Table>
        </Col>
      </Row>
      <Row>
        <Col xs={12}>
          <span className="main-board-title">지역축제</span>
        </Col>
      </Row>
      <Row className="mt-3">
        <Col xs={12} className="main-festival">
          <Table>
            <tbody className="main-festival-local-list">
              <tr>
                <td>
                  <ListGroup horizontal>
                    <Link to="./festival/dtail">
                      <div className="main-festival-local ml-2">
                        <div className="main-festival-local-image">
                          <Image
                            src={require('../img/festival1.jpg').default}
                            alt="축제 이미지"
                            fluid
                          />
                        </div>
                        <div className="main-festival-local-title">
                          <span>심슨 축제</span>
                        </div>
                      </div>
                    </Link>
                    <div className="main-festival-local ml-2">
                      <div className="main-festival-local-image">
                        <Image
                          src={require('../img/festival2.jpg').default}
                          alt="축제 이미지"
                        />
                      </div>
                      <div className="main-festival-local-title">
                        <span>심슨 축제</span>
                      </div>
                    </div>
                    <div className="main-festival-local ml-2">
                      <div className="main-festival-local-image">
                        <Image
                          src={require('../img/festival3.jpg').default}
                          alt="축제 이미지"
                        />
                      </div>
                      <div className="main-festival-local-title">
                        <span>심슨 축제</span>
                      </div>
                    </div>
                    <div className="main-festival-local ml-2">
                      <div className="main-festival-local-image">
                        <Image
                          src={require('../img/festival4.jpg').default}
                          alt="축제 이미지"
                        />
                      </div>
                      <div className="main-festival-local-title">
                        <span>심슨 축제</span>
                      </div>
                    </div>
                    <div className="main-festival-local ml-2">
                      <div className="main-festival-local-image">
                        <Image
                          src={require('../img/festival5.jpg').default}
                          alt="축제 이미지"
                        />
                      </div>
                      <div className="main-festival-local-title">
                        <span>심슨 축제</span>
                      </div>
                    </div>
                    <div className="main-festival-local ml-2">
                      <div className="main-festival-local-image">
                        <Image
                          src={require('../img/festival6.jpeg').default}
                          alt="축제 이미지"
                        />
                      </div>
                      <div className="main-festival-local-title">
                        <span>심슨 축제</span>
                      </div>
                    </div>
                  </ListGroup>
                </td>
              </tr>
            </tbody>
          </Table>
        </Col>
      </Row>
      <Row className="mt-3 mb-3">
        <Col xs={12} xl={{ span: 6, offset: 3 }}>
          <Table borderless>
            <thead className="main-board-title">
              <tr>
                <td>자유게시판</td>
                <td className="main-board-more">
                  <Plus />
                </td>
              </tr>
            </thead>
            <tbody className="main-board-content">
              <tr>
                <td>
                  <EllipsisText
                    text={
                      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum excepturi'
                    }
                    length={'20'}
                  />
                </td>
                <td>2021-11-22</td>
              </tr>
              <tr>
                <td>
                  <EllipsisText
                    text={
                      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum excepturi'
                    }
                    length={'20'}
                  />
                </td>
                <td>2021-11-02</td>
              </tr>
              <tr>
                <td>
                  <EllipsisText
                    text={
                      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum excepturi'
                    }
                    length={'20'}
                  />
                </td>
                <td>2021-11-02</td>
              </tr>
              <tr>
                <td>
                  <EllipsisText
                    text={
                      'Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum excepturi'
                    }
                    length={'20'}
                  />
                </td>
                <td>2021-11-02</td>
              </tr>
            </tbody>
          </Table>
        </Col>
      </Row>
    </Container>
  )
}

export default Main
