import React from 'react'
import { Link } from 'react-router-dom'
import { slide as Menu } from 'react-burger-menu'
import { Justify } from 'react-bootstrap-icons'
import './SideBar.scss'

export const SideBar = () => {
  return (
    <Menu customBurgerIcon={<Justify />}>
      <Link to="/notice" className="menu-item">
        <h4>공지사항</h4>
      </Link>
      <Link to="/festival" className="menu-item">
        <h4>지역축제</h4>
      </Link>
      <Link to="review" className="menu-item">
        <h4>축제후기</h4>
      </Link>
      <Link to="/Free" className="menu-item">
        <h4>자유게시판</h4>
      </Link>
    </Menu>
  )
}

export default SideBar
