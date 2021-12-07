import React, { useEffect, useState } from 'react'
import DaumPostcode from 'react-daum-postcode'

const PopupPostCode = ({ setNewUser, newUser, handleClose }) => {
  const onCompletePost = (data) => {
    setNewUser({ ...newUser, ['userBasicAddress']: data.address })
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
