import React, { useEffect, useState } from 'react'
import './css/festival.css'
import { Card, Col, Container, Image, Row } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import EllipsisText from 'react-ellipsis-text'
import axios from 'axios'

function Festival() {
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
        'http://localhost:9000/article/page.do?articleCode=festival&page=0&size=100'
      )
      .then((res) => {
        setFestivalList(res.data)
      })
      .catch((error) => console.log(error))
  }, [])

  return (
    <>
      <Container>
        <Row>
          <Col sm={12} lg={12} className="festival-title">
            <span>지역축제</span>
          </Col>
        </Row>
        <Row className="festival-content-list">
          {festivalList.map((festival) => (
            <Col
              xs={12}
              xl={4}
              className="festival-content mt-1 mb-2 d-flex justify-content-center"
            >
              <div>
                <Link to={`/festivalDetail/${festival.articleNo}`}>
                  <div className="festival-content-picture">
                    <Image
                      src={'./img/' + festival.articleImage}
                      alt="축제사진"
                      fluid
                    />
                  </div>
                </Link>
                <div className="festival-content-text">
                  <span>{festival.festivalName}</span>
                </div>
              </div>
            </Col>
          ))}
        </Row>
      </Container>
    </>
  )
}

export default Festival
