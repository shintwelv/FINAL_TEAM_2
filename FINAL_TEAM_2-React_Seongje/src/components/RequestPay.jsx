import React from 'react'
import { Button } from 'react-bootstrap'
import { useHistory } from 'react-router'

class RequestPay extends React.Component {
  requestPay = () => {
    const { IMP } = window
    IMP.init('imp40670158')
    IMP.request_pay(
      {
        pg: 'kakaopay',
        pay_method: 'kakaopay',
        merchant_uid: 'ORD20180131-0002322' + Date.now(),
        name: '2021 대한민국 축제 예약',
        amount: 100,
        buyer_email: 'gildong@gmail.com',
        buyer_name: '홍길동',
        buyer_tel: '010-4242-4242',
        buyer_addr: '서울특별시 강남구 신사동',
        buyer_postcode: '01181',
      },
      (rsp) => {
        // callback
        if (rsp.success) {
          // https://docs.iamport.kr/sdk/javascript-sdk 에서 rsp 필드 값 확인
          alert(rsp.paid_amount + '를 지불하셨습니다')
        } else {
          alert(rsp.error_msg)
        }
      }
    )
  }
  render() {
    return (
      <>
        <script
          type="text/javascript"
          src="https://code.jquery.com/jquery-1.12.4.min.js"
        />
        <script
          type="text/javascript"
          src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"
        />
        <Button onClick={this.requestPay}>예약</Button>
      </>
    )
  }
}

export default RequestPay
