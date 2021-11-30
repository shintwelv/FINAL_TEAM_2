import React from 'react'
import HeaderTop from './HeaderTop'
import HeaderMid from './HeaderMid'
import MobileHeader from './MobileHeader'

const Header = ({ login, setLogin, nickName, setUserState }) => {
  return (
    <>
      <HeaderTop
        login={login}
        setLogin={setLogin}
        nickName={nickName}
        setUserState={setUserState}
      />
      <HeaderMid />
      <MobileHeader />
    </>
  )
}
export default Header
