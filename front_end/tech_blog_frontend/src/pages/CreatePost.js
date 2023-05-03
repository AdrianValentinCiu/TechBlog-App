import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function CreatePost() {
  const [title, setTitle] = useState("")
  const [postText, setPostText] = useState("")

  let navigate = useNavigate()

  const createPost = () => {
    console.log(title)
    console.log(postText)
    navigate("/")
  }

  return (
    <div className="createPostPage">
      <div className="dataContainer">
        <h1>Create a post</h1>
        <div className="dataInput">
          <label> Title:</label>
          <input placeholder="Title..." onChange={(event) => {setTitle(event.target.value)}}/>
        </div>
        <div className="dataInput">
          <label> Post:</label>
          <textarea placeholder="Text..." onChange={(event) => {setPostText(event.target.value)}} />
        </div>
        <button onClick={createPost} className='fancybtn' >
          Submit post
        </button>
      </div>
    </div>
  )
}

export default CreatePost