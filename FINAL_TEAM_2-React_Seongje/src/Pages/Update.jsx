import React from 'react'
import { Container } from 'react-bootstrap'
import 'react-quill/dist/quill.snow.css'
import { Link } from 'react-router-dom'
import Editor from '../components/Editor'

const Update = () => {
  return (
    <div>
      <Container>
        <section className="input-wrapper">
          <div className="input-group">
            <label htmlFor="">
              제목
              <br />
              <input type="text" />
            </label>
            <label htmlFor="">
              작성자
              <br />
              <input type="text" />
            </label>
          </div>
        </section>
        <section className="text-editor">
          <Editor />
        </section>
        <div className="button-group">
          <div className="update-delete-btn">
            <Link to="Update" className="update-btn">
              <button type="submit">수정</button>
            </Link>
            <Link to="Free" className="cancel-btn">
              <button>취소</button>
            </Link>
          </div>
        </div>
      </Container>
    </div>
  )
}

export default Update
