import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';

function CreatePost(props) {
  const [title, setTitle] = useState("")
  const [postText, setPostText] = useState("")
  const userId = props.userId;
  let navigate = useNavigate()

  const createPost = () => {
    console.log(userId);
    axios
      .post(`http://localhost:8080/api/v1/topic/create-topic`, { topicTitle: title, idUserPostAdmin: userId })
      .then((response) => {
        axios.post(`http://localhost:8080/api/v1/topic/post-message-topic`, {
          msgText: postText,
          idTopic: response.data,
          idUser: userId,
        });
      })
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