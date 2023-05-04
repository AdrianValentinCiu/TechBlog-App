import { useState, useEffect } from 'react';
import axios from 'axios';

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

  return (
   <div>
      <ul>
        {topics.map(topic => (
          <li key={topic.idTopic}>{topic.topicTitle} {'@'} {topic.idUserPostAdmin}</li>
        ))}
      </ul>
    </div>
  )
}

export default Home