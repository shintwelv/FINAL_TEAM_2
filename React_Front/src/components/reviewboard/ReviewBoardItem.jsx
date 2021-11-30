import React from 'react'
import styled from 'styled-components'

const BoardItemWrapper = styled.div`
  display: flex;
  align-items: center;
  height: 120px;
  border-bottom: 2px solid $border-form;
  background-color: white;
  border-bottom: 2px solid #e0e2e7;
  &:hover {
    background-color: #e0e2e7;
  }
  &:first-child {
    border-top: 2px solid #191a20;
  }
  &:last-child {
    border-bottom: none;
  }
  .label {
    padding: 0 8px;
    margin-left: 8px;
    font-size: 12px;
    color: white;
    background-color: #0593f0;
  }
  .article-title {
    padding: 8px 8px 0px;
  }
  .article-info {
    padding: 8px 8px 0px;
    display: flex;
    justify-content: flex-start;
    text-align: center;
  }
`

export const BoardItem = ({ data }) => {
  return (
    <BoardItemWrapper>
      <ul>
        <li>
          <span className="label">{data.label}</span>
          <div className="article-title">
            <span>{data.title}</span>
          </div>
          <div className="article-info">
            <span>{data.userid}</span> <span>ㅣ</span>
            <span>조회수 : {data.view}</span>
            <span>ㅣ</span> <span>{data.date}</span>
          </div>
        </li>
      </ul>
    </BoardItemWrapper>
  )
}

export default BoardItem
