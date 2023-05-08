import { useState, useEffect } from 'react';
import axios from 'axios';
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom" 
import TopicMessages from "./TopicMessages"

function Home() {
  const [topics, setTopics] = useState([]);

  const getTopics = () => {
    axios
    .get("http://localhost:8080/api/v1/topic/topics")
    .then((response) => {
      setTopics(response.data);
      console.log(response.data);
    })
    .catch((err) => {
        console.log(err);
    });
  }

  useEffect(() => {
    getTopics() 
  }, [])
//<a href = {`http://localhost:3000/`} onClick={(event) => getTopicMessages(event, topic.idTopic)} > 
//<Link to={`/topic_messages/${topic.idTopic}`} state={{ topic: topic }}> {topic.topicTitle} </Link>
  return (
   <div className="topic-messages-container">
      <ul>
        {topics.map(topic => (
          <li key={topic.idTopic}>
            <div className="post">
                  <div className="postHeader">
                      <Link to="/topic_messages" state={topic}
                         style={{
                          color: 'black',
                          '@media (prefers-color-scheme: dark)': {
                            color: 'white',
                          },
                        }}>
                        {topic.topicTitle}
                      </Link>
                  </div>
                  <div className='postTextContainer'>
                  @{topic.fullName}
                  </div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  )
}

export default Home