import React, { useState } from 'react'
import { Col, Container, Image, Row, Button } from 'react-bootstrap'
import RequestPay from '../components/RequestPay'
import KakaoMap from '../components/KakaoMap'
import './css/festival_detail.css'

function FestivalDetail(props) {
  const [lng, setLng] = useState(35.188831479630174)
  const [lat, setLat] = useState(128.07836577856978)

  return (
    <>
      <Container className="detail-festival-container">
        <Row>
          <Col className="detail-festival-title" xs={12}>
            진주 남강 유등 축제
          </Col>
        </Row>
        <Row>
          <Col className="detail-festival-subtitle" xs={12}>
            경상남도 전주시
          </Col>
        </Row>
        <Row>
          <Col xs={12} className="d-flex justify-content-center">
            <Image
              src={require('../img/festival5.jpg').default}
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
                  <td>2021.12.14 (토)</td>
                </tr>
                <tr>
                  <td>&#183; 종료일</td>
                  <td>2021.12.31. (금)</td>
                </tr>
                <tr>
                  <td>&#183; 장소</td>
                  <td>진주성 및 남강 일원</td>
                </tr>
                <tr>
                  <td>&#183; 주최</td>
                  <td>(재단법인) 진주문화예술재단</td>
                </tr>
                <tr>
                  <td>&#183; 요금</td>
                  <td>입장무료 (시설이용 유료)</td>
                </tr>
                <tr>
                  <td>&#183; 홈페이지</td>
                  <td>https://yudeung.com/home</td>
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
                    계사년(1593) 6월, 제2차 진주성전투에서는 오로지 구국(救國)의
                    일념으로 왜군과 항전한 7만명의 민∙관∙군이 순국하면서
                    진주성(晋州城)은 임진왜란 국난극복의 현장이 된다.후일,
                    진주사람들은 임진∙계사년(壬辰癸巳年) 국난극복에 몸을 바친
                    순국선열들의 넋을 위로하기 위해 남강에 유등(流燈)을 띄웠고,
                    이 전통이 면면히 이어져 대한민국 글로벌축제인
                    진주남강유등축제(晋州南江流 燈祝祭)로 자리잡았다.
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
          <Col
            xs={12}
            className="detail-festival-listBtn detail-festival-button"
          >
            <Button>목록</Button>
          </Col>
        </Row>
      </Container>
    </>
  )
}

export default FestivalDetail
