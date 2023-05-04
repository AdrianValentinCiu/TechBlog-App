import { useState, useEffect } from 'react';
import axios from 'axios';

function Home() {
  const [topics, setTopics] = useState([]);
  const [topicMessages, setTopicMessages] = useState([]);

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

  function getTopicMessages(event, TopicId){
    axios
    .get(`http://localhost:8080/api/v1/topic/topic-messages/${TopicId}`)
    .then((response) => {
      setTopicMessages(response.data);
      console.log(response.data);
    })
    .catch((err) => {
       console.log(err);
    });
  }

  useEffect(() => {
    getTopics()
  }, [])

  return (
   <div>
      <ul>
        {topics.map(topic => (
          <li key={topic.idTopic}><a href = {`http://localhost:3000/date/${topic.topicTitle}`} onClick={(event) => getTopicMessages(event, topic.idTopic)}> {topic.topicTitle} </a> {'@'} {topic.idUserPostAdmin}</li>
        ))}
      </ul>
    </div>
  )
}

export default Home