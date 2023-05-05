import { useState, useEffect } from 'react';
import axios from 'axios';
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom" 
import TopicMessages from "./TopicMessages"

function Home() {
  const [topics, setTopics] = useState([]);
  const [topicMessages, setTopicMessages] = useState([]);

  function getTopicMessages(event, topicId){
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
   <div>
      <ul>
        {topics.map(topic => (
          <li key={topic.idTopic}>
            <a href = {`http://localhost:3000/`} onClick={(event) => getTopicMessages(event, topic.idTopic)} > 
            {topic.topicTitle}
            </a>
            {'@'} {topic.fullName}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default Home