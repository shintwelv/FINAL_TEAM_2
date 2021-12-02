import React from 'react'
import HeaderTop from './HeaderTop'
import HeaderMid from './HeaderMid'
import MobileHeader from './MobileHeader'

const Header = ({ login, setLogin, nickName, setUserState, setBoard }) => {
  return (
    <>
      <HeaderTop
        login={login}
        setLogin={setLogin}
        nickName={nickName}
        setUserState={setUserState}
      />
      <HeaderMid setBoard={setBoard} />
      <MobileHeader />
    </>
  )
}
export default Header
