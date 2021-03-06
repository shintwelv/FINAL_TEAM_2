import React, { useEffect, useState } from 'react'
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
import axios from 'axios'

function Main({ setBoard }) {
  const [noticeList, setNoticeList] = useState([
    {
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
    },
  ])

  const [freeList, setFreeList] = useState([
    {
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
    },
  ])

  const [festivalList, setFestivalList] = useState([
    {
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
    },
  ])

  useEffect(() => {
    axios
      .get(
        'http://localhost:9000/article/page.do?articleCode=notice&page=0&size=5'
      )
      .then((res) => {
        setNoticeList(res.data)
      })
      .then(
        axios
          .get(
            'http://localhost:9000/article/page.do?articleCode=free&page=0&size=5'
          )
          .then((res) => {
            setFreeList(res.data)
          })
          .then(
            axios
              .get(
                'http://localhost:9000/article/page.do?articleCode=festival&page=0&size=10'
              )
              .then((res) => {
                setFestivalList(res.data)
              })
              .catch((error) => console.log(error))
          )
          .catch((error) => console.log(error))
      )
      .catch((error) => console.log(error))
  }, [])

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
            {/* ????????? ???????????? ?????? ????????? ??? */}
            {festivalList.map((festival) => (
              <Carousel.Item>
                <Image
                  className="d-block w-100 festival-slide-image"
                  src={'./img/' + festival.articleImage}
                  alt="????????????"
                  fluid
                />
              </Carousel.Item>
            ))}
          </Carousel>
        </Col>
      </Row>
      <Row className="mt-3">
        <Col xs={12} xl={{ span: 6, offset: 3 }}>
          <Table borderless>
            <thead className="main-board-title">
              <tr>
                <td>????????????</td>
                <td className="main-board-more">
                  <Link to={'/notice'} onClick={() => setBoard('notice')}>
                    <Plus />
                  </Link>
                </td>
              </tr>
            </thead>
            <tbody className="main-board-content">
              {noticeList.map((article) => (
                <tr>
                  <td>
                    <Link
                      to={`/Read/${article.articleNo}`}
                      onClick={() => setBoard('notice')}
                    >
                      <EllipsisText text={article.articleTitle} length={'20'} />
                    </Link>
                  </td>
                  <td>
                    {`${new Date(article.writeDate).getFullYear()}-${new Date(
                      article.writeDate
                    ).getMonth()}-${new Date(article.writeDate).getDate()}`}
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        </Col>
      </Row>
      <Row>
        <Col xs={12}>
          <span className="main-board-title">????????????</span>
        </Col>
      </Row>
      <Row className="mt-3">
        <Col xs={12} className="main-festival">
          <Table>
            <tbody className="main-festival-local-list">
              <tr>
                <td>
                  <ListGroup horizontal>
                    {festivalList.map((festival) => (
                      <Link to={`/festivalDetail/${festival.articleNo}`}>
                        <div className="main-festival-local ml-2">
                          <div className="main-festival-local-image">
                            <Image
                              src={'./img/' + festival.articleImage}
                              alt="?????? ?????????"
                              fluid
                            />
                          </div>
                          <div className="main-festival-local-title">
                            <span>{festival.festivalName}</span>
                          </div>
                        </div>
                      </Link>
                    ))}
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
                <td>???????????????</td>
                <td className="main-board-more">
                  <Link to={'/free'} onClick={() => setBoard('free')}>
                    <Plus />
                  </Link>
                </td>
              </tr>
            </thead>
            <tbody className="main-board-content">
              {freeList.map((article) => (
                <tr>
                  <td>
                    <Link
                      to={`/Read/${article.articleNo}`}
                      onClick={() => setBoard('free')}
                    >
                      <EllipsisText text={article.articleTitle} length={'20'} />
                    </Link>
                  </td>
                  <td>
                    {`${new Date(article.writeDate).getFullYear()}-${new Date(
                      article.writeDate
                    ).getMonth()}-${new Date(article.writeDate).getDate()}`}
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        </Col>
      </Row>
    </Container>
  )
}

export default Main
