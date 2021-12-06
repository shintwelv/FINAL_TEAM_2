import React, { useEffect, useState } from 'react'
import ReactQuill from 'react-quill'
import EditorToolbar, { modules, formats } from './EditorToolbar'
import 'react-quill/dist/quill.snow.css'

const Editor = ({ article, setArticle }) => {
  const handleChange = (value) => {
    setArticle({ ...article, ['articleContent']: value })
    console.log(article)
  }
  return (
    <div className="text-editor">
      <EditorToolbar />
      <ReactQuill
        theme="snow"
        onChange={handleChange}
        placeholder={''}
        modules={modules}
        formats={formats}
        style={{ height: 375 }}
        // value={articleContent}
      />
    </div>
  )
}

export default Editor
