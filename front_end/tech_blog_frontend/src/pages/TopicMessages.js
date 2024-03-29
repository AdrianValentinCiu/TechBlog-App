import { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import properties from '../properties.json';

function TopicMessages(props) {
    const [topicMessages, setTopicMessages] = useState([]);
    const location = useLocation();
    const [postText, setPostText] = useState("")
    const isAuth = props.isAuth;
    const userId = props.userId;
    const topic = location.state;

    const createPost = () => {
      console.log(postText)
      console.log(topic.idTopic);
      console.log(userId);
      axios
        .post(properties.base_URL + `/topic/post-message-topic`, {msgText : postText, idTopic : topic.idTopic, idUser : userId})
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
        .get(properties.base_URL + `/topic/topic-messages/${topicId}`)
        .then((response) => {
          setTopicMessages(response.data);
          console.log(response.data);
        })
        .catch((err) => {
           console.log(err);
        });
      }

      function getLikeMessages(idMessage){
        console.log(topic.idTopic);
        console.log(idMessage);
        console.log(userId)
        axios
        .put(properties.base_URL + `/topic/like-topic-message`, {idMessage : idMessage, idTopic : topic.idTopic, idUser : userId})
        .then((response) => {
          //console.log(response.data);
          getTopicMessages(topic.idTopic) 
        })
        .catch((err) => {
           console.log(err);
        });
      }

    useEffect(() => {
      getTopicMessages(topic.idTopic) 
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
                    <div className='likePost'>
                      <button disabled={!isAuth} onClick={() =>getLikeMessages(msg.idMessage)}>&#128077;</button>
                      {msg.likesMessage}
                    </div>
                </div>
              </li>
            ))}
          </ul>
          </div>
        {isAuth &&
          <div className="dataContainer" style={{
                color: 'black',
                '@media (prefersColorScheme: dark)': {
                  color: 'white',
                },
              }}>
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