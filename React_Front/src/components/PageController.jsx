import React, { useState } from 'react'
import Pagination from 'react-js-pagination'
import './PageController.scss'

export const PageController = ({
  page,
  setPage,
  totalPage,
  size,
  articleNum,
}) => {
  const handlePageChange = (page) => {
    console.log(page)
    setPage(page - 1)
  }

  console.log('totalPage: ' + totalPage)
  return (
    <Pagination
      activePage={page}
      itemsCountPerPage={size}
      totalItemsCount={articleNum}
      pageRangeDisplayed={5}
      prevPageText={'‹'}
      nextPageText={'›'}
      onChange={handlePageChange}
    />
  )
}

export default PageController
