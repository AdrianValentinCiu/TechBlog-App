import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';


function NotifyUsers() {
    const [title, setTitle] = useState("")
    const [postText, setPostText] = useState("")
    let navigate = useNavigate()

    const createPost = () => {
        axios
          .post(`http://localhost:8080/api/v1/news/new-update`, { title: title, appNews: postText })
          .then(() => {
            document.querySelector('input').value = '';
            document.querySelector('textarea').value = '';
            navigate("/");
          })
          .catch((err) => {
            console.log(err);
        });
    };

  return (
    <div className="createPostPage">
      <div className="dataContainer" style={{
                  color: 'black',
                  '@media (prefersColorScheme: dark)': {
                    color: 'white',
                  },
                }}>
        <h1>Notification Title</h1>
        <div className="dataInput">
          <label> Title:</label>
          <input placeholder="Title..." onChange={(event) => {setTitle(event.target.value)}}/>
        </div>
        <div className="dataInput">
          <label> Notification Message:</label>
          <textarea placeholder="Text..." onChange={(event) => {setPostText(event.target.value)}} />
        </div>
        <button onClick={createPost} className='fancybtn' >
          Submit post
        </button>
      </div>
    </div>
  )
}

export default NotifyUsers