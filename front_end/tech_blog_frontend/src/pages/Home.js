import { useState, useEffect } from 'react';
import axios from 'axios';
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom" 
import TopicMessages from "./TopicMessages"

function Home() {
  const [topics, setTopics] = useState([]);
  const [user, setUser] = useState([]);


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

  function getUser(event, userId){
    axios
    .get(`http://localhost:8080/api/v1/user/user_data/${userId}`)
    .then((response) => {
      setUser(response.data);
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
  return (
   <div>
      <ul>
        {topics.map(topic => (
          <li key={topic.idTopic}>
            <Link to={`/topic_messages/${topic.idTopic}`} state={{ topic: topic }}> {topic.topicTitle} </Link>
            {'@'} {topic.idTopic}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default Home