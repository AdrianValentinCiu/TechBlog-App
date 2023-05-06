import { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom'

function TopicMessages() {
    const [topicMessages, setTopicMessages] = useState([]);
    const location = useLocation();
    const [postText, setPostText] = useState("")

    const topic = location.state;
    console.log(topic);

    let navigate = useNavigate()

    const createPost = () => {
      console.log(postText)
      navigate("/")
    }

    function getTopicMessages(topicId){
        axios
        .get(`http://localhost:8080/api/v1/topic/topic-messages/${topicId}`)
        .then((response) => {
          setTopicMessages(response.data);
          //console.log(response.data);
        })
        .catch((err) => {
           console.log(err);
        });
      }

    useEffect(() => {
      getTopicMessages(topic.idTopic) 
      //console.log(topicMessages)
    }, [])

    return (
      <div className='createPostPage'>
        <div className="topic-messages-container">
          <ul>
            {topicMessages.map((msg) => (
              <li key={msg.idMessage}>
                  <div className="post">
                    <div className="postTextContainer">
                      {msg.msgText}
                      {'  @'}
                      {msg.fullName}
                    </div>
                </div>
              </li>
            ))}
          </ul>
        </div>
          <div className="dataContainer">
            <h1>Add a coment</h1>
            <div className="dataInput">
              <label> Post:</label>
              <textarea placeholder="Text..." onChange={(event) => {setPostText(event.target.value)}} />
            </div>
            <button onClick={createPost} className='fancybtn' >
              Submit post
            </button>
          </div>
      </div>
    );
  }

export default TopicMessages