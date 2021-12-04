import React, { useEffect, useState } from 'react'
import DaumPostcode from 'react-daum-postcode'

const PopupPostCode = ({ setAddress, handleClose }) => {
  const onCompletePost = (data) => {
    setAddress(data.address)
    handleClose()
  }

  const postCodeStyle = {
    display: 'block',
  }

  return (
    <DaumPostcode
      style={postCodeStyle}
      autoClose
      onComplete={onCompletePost}
      height={700}
    />
  )
}

export default PopupPostCode
