import React from 'react'
import './css/festival.css'
import { Col, Container, Image, Row } from 'react-bootstrap'
import { Link } from 'react-router-dom'

function Festival(props) {
  return (
    <>
      <Container>
        <Row>
          <Col sm={12} lg={12} className="festival-title">
            <span>지역축제</span>
          </Col>
        </Row>
        <Row className="festival-content-list">
          <Col
            xs={12}
            xl={4}
            className="festival-content mt-1 mb-2 d-flex justify-content-center"
          >
            <div>
              <Link to="/festivaldetail">
                <div className="festival-content-picture">
                  <Image
                    src={require('../img/festival1.jpg').default}
                    alt="축제사진"
                    fluid
                  />
                </div>
              </Link>
              <div className="festival-content-text">
                <span>2021 토마토축제</span>
              </div>
            </div>
          </Col>
          <Col
            xs={12}
            xl={4}
            className="festival-content mt-1 mb-2 d-flex justify-content-center"
          >
            <div>
              <div className="festival-content-picture">
                <Image
                  src={require('../img/festival2.jpg').default}
                  alt="축제사진"
                />
              </div>
              <div className="festival-content-text">
                <span>2021 바나나 축제</span>
              </div>
            </div>
          </Col>
          <Col
            xs={12}
            xl={4}
            className="festival-content mt-1 mb-2 d-flex justify-content-center"
          >
            <div>
              <div className="festival-content-picture">
                <Image
                  src={require('../img/festival3.jpg').default}
                  alt="축제사진"
                />
              </div>
              <div className="festival-content-text">
                <span>2021 바나나 축제</span>
              </div>
            </div>
          </Col>
          <Col
            xs={12}
            xl={4}
            className="festival-content mt-1 mb-2 d-flex justify-content-center"
          >
            <div>
              <div className="festival-content-picture">
                <Image
                  src={require('../img/festival5.jpg').default}
                  alt="축제사진"
                />
              </div>
              <div className="festival-content-text">
                <span>2021 바나나 축제</span>
              </div>
            </div>
          </Col>
        </Row>
      </Container>
    </>
  )
}

export default Festival
