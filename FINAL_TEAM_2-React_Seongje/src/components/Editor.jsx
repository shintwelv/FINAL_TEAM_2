import React, { useState } from 'react'
import ReactQuill from 'react-quill'
import EditorToolbar, { modules, formats } from './EditorToolbar'
import 'react-quill/dist/quill.snow.css'

export const Editor = () => {
  const [content, setContent] = useState({ value: null })
  const handleChange = (value) => {
    setContent({ value })
    console.log(content)
  }
  return (
    <div className="text-editor">
      <EditorToolbar />
      <ReactQuill
        theme="snow"
        value={content.value}
        onChange={handleChange}
        placeholder={''}
        modules={modules}
        formats={formats}
        style={{ height: 375 }}
      />
    </div>
  )
}

export default Editor
