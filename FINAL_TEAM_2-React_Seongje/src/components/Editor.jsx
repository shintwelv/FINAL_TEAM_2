import React from 'react'
import ReactQuill from 'react-quill'
import EditorToolbar, { modules, formats } from './EditorToolbar'
import 'react-quill/dist/quill.snow.css'

export const Editor = () => {
  const [state, setState] = React.useState({ value: null })
  const handleChange = (value) => {
    setState({ value })
  }
  return (
    <div className="text-editor">
      <EditorToolbar />
      <ReactQuill
        theme="snow"
        value={state.value}
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
