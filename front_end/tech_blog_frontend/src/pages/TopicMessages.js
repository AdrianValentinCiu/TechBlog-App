import { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom'

function TopicMessages(props) {
    const [topicMessages, setTopicMessages] = useState([]);
    const location = useLocation();
    const [postText, setPostText] = useState("")
    const isAuth = props.isAuth;
    const userId = props.userId;
    const topic = location.state;

    let navigate = useNavigate()

    const createPost = () => {
      console.log(postText)
      console.log(topic.idTopic);
      console.log(userId);
      axios
        .post(`http://localhost:8080/api/v1/topic/post-message-topic`, {msgText : postText, idTopic : topic.idTopic, idUser : userId})
        .then( () => {
          getTopicMessages(topic.idTopic) 
          document.querySelector('textarea').value = '';

        })
        .catch((err) => {
           console.log(err);
        });
    }

    function getTopicMessages(topicId){
        console.log(topicId);
        axios
        .get(`http://localhost:8080/api/v1/topic/topic-messages/${topicId}`)
        .then((response) => {
          setTopicMessages(response.data);
          console.log(response.data);
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
                    <div className='deletePost'>
                      <button> &#128465; </button>
                    </div>
                </div>
              </li>
            ))}
          </ul>
          </div>
        {isAuth &&
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
        }
      </div>
    );
  }

export default TopicMessages