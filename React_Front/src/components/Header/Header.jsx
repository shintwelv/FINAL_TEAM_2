import React from 'react'
import HeaderTop from './HeaderTop'
import HeaderMid from './HeaderMid'
import MobileHeader from './MobileHeader'

const Header = ({
  login,
  setLogin,
  setUserState,
  setBoard,
  userInfo,
  setUserInfo,
}) => {
  return (
    <>
      <HeaderTop
        login={login}
        setLogin={setLogin}
        setUserState={setUserState}
        userInfo={userInfo}
        setUserInfo={setUserInfo}
      />
      <HeaderMid setBoard={setBoard} />
      <MobileHeader />
    </>
  )
}
export default Header
