import React, { useEffect, useState } from 'react'
import { Col, Container, Image, Row, Button } from 'react-bootstrap'
import RequestPay from '../components/RequestPay'
import KakaoMap from '../components/KakaoMap'
import './css/festival_detail.css'
import { useParams } from 'react-router'
import axios from 'axios'
import { Link } from 'react-router-dom'

function FestivalDetail() {
  const { articleNo } = useParams()
  const article_no = articleNo

  const lngLatList = [
    { lng: 33.39416752289471, lat: 126.2384834247646 },
    { lng: 33.389345311752514, lat: 126.23455027818953 },
    { lng: 33.23199056856631, lat: 126.31468391338403 },
    { lng: 33.542659658817506, lat: 126.66593433249494 },
    { lng: 33.49777735533278, lat: 126.45315016972924 },
  ]

  const [lng, setLng] = useState(lngLatList[article_no % 5].lng)
  const [lat, setLat] = useState(lngLatList[article_no % 5].lat)

  const [festival, setFestival] = useState({
    articleCode: '',
    articleContent: '',
    articleImage: '',
    articleLike: 0,
    articleNo: 0,
    articleStar: 0,
    articleTitle: '',
    festivalDuration: '',
    festivalFee: 0,
    festivalLocation: '',
    festivalName: '',
    festivalOwner: '',
    userId: '',
    viewCount: 0,
    writeDate: 0,
  })

  useEffect(() => {
    axios
      .get(`http://localhost:9000/article/view.do?articleNo=${article_no}`)
      .then((res) => setFestival(res.data))
      .catch((error) => console.log(error))
  }, [])

  return (
    <>
      <Container className="detail-festival-container">
        <Row>
          <Col className="detail-festival-title" xs={12}>
            {festival.festivalName}
          </Col>
        </Row>
        <Row>
          <Col className="detail-festival-subtitle" xs={12}>
            {festival.festivalLocation}
          </Col>
        </Row>
        <Row>
          <Col xs={12} className="d-flex justify-content-center">
            <Image
              src={`../img/${festival.articleImage}`}
              alt="축제사진"
              className="detail-festival-image"
            ></Image>
          </Col>
        </Row>
        <Row>
          <Col xs={12} className="d-flex justify-content-center">
            <table className="detail-festival-info-list">
              <tbody>
                <tr>
                  <td>&#183; 시작일</td>
                  <td>
                    {festival.festivalDuration.substring(
                      0,
                      festival.festivalDuration.indexOf('~') - 1
                    )}
                  </td>
                </tr>
                <tr>
                  <td>&#183; 종료일</td>
                  <td>
                    {festival.festivalDuration.substring(
                      festival.festivalDuration.indexOf('~') + 2
                    )}
                  </td>
                </tr>
                <tr>
                  <td>&#183; 장소</td>
                  <td>{festival.festivalLocation}</td>
                </tr>
                <tr>
                  <td>&#183; 주최</td>
                  <td>{festival.festivalOwner}</td>
                </tr>
                <tr>
                  <td>&#183; 요금</td>
                  <td>{festival.festivalFee}원</td>
                </tr>
              </tbody>
            </table>
          </Col>
        </Row>
        <Row>
          <Col xs={12} className="d-flex justify-content-center">
            <table className="detail-festival-info">
              <tbody>
                <tr>
                  <td className="detail-festival-description-title">
                    축제 소개
                  </td>
                </tr>
                <tr>
                  <td className="detail-festival-description">
                    {festival.articleContent}
                  </td>
                </tr>
                <tr>
                  <td className="map-graphic">
                    <KakaoMap lng={lng} lat={lat} />
                  </td>
                </tr>
              </tbody>
            </table>
          </Col>
        </Row>
        <Row>
          <Col xs={12} className="detail-festival-button">
            <RequestPay />
          </Col>
        </Row>
      </Container>
      <Container className="detail-festival-reply-container">
        {/* <Row>
          <Col className="aReply" xs={12}>
            <table>
              <tbody>
                <tr>
                  <td className="reply-content">진짜 너무 이뻐요~~</td>
                  <td rowSpan="2" className="reply-btn">
                    수정
                  </td>
                  <td rowSpan="2" className="reply-btn">
                    삭제
                  </td>
                </tr>
                <tr className="reply-writer-date">
                  <td>
                    <table>
                      <tbody>
                        <tr>
                          <td>신몬익화</td>
                          <td>2011-11-12</td>
                        </tr>
                      </tbody>
                    </table>
                  </td>
                </tr>
              </tbody>
            </table>
          </Col>
        </Row>
        <Row>
          <Col className="aReply" xs={12}>
            <table>
              <tbody>
                <tr>
                  <td className="reply-content">진짜 너무 이뻐요~~</td>
                  <td rowSpan="2" className="reply-btn">
                    수정
                  </td>
                  <td rowSpan="2" className="reply-btn">
                    삭제
                  </td>
                </tr>
                <tr className="reply-writer-date">
                  <td>
                    <table>
                      <tbody>
                        <tr>
                          <td>신몬익화</td>
                          <td>2011-11-12</td>
                        </tr>
                      </tbody>
                    </table>
                  </td>
                </tr>
              </tbody>
            </table>
          </Col>
        </Row>
        <Row>
          <Col className="aReply" xs={12}>
            <table>
              <tbody>
                <tr>
                  <td className="reply-content">진짜 너무 이뻐요~~</td>
                  <td rowSpan="2" className="reply-btn">
                    수정
                  </td>
                  <td rowSpan="2" className="reply-btn">
                    삭제
                  </td>
                </tr>
                <tr className="reply-writer-date">
                  <td>
                    <table>
                      <tbody>
                        <tr>
                          <td>신몬익화</td>
                          <td>2011-11-12</td>
                        </tr>
                      </tbody>
                    </table>
                  </td>
                </tr>
              </tbody>
            </table>
          </Col>
        </Row>
        <Row>
          <Col className="aReply" xs={12}>
            <table>
              <tbody>
                <tr>
                  <td className="reply-content">진짜 너무 이뻐요~~</td>
                  <td rowSpan="2" className="reply-btn">
                    수정
                  </td>
                  <td rowSpan="2" className="reply-btn">
                    삭제
                  </td>
                </tr>
                <tr className="reply-writer-date">
                  <td>
                    <table>
                      <tbody>
                        <tr>
                          <td>신몬익화</td>
                          <td>2011-11-12</td>
                        </tr>
                      </tbody>
                    </table>
                  </td>
                </tr>
              </tbody>
            </table>
          </Col>
        </Row> */}
        <Row>
          <Col
            xs={12}
            className="detail-festival-listBtn detail-festival-button"
          >
            <Link to="../festival">
              <Button>목록</Button>
            </Link>
          </Col>
        </Row>
      </Container>
    </>
  )
}

export default FestivalDetail
