import { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';

function TopicMessages() {
    const [topicMessages, setTopicMessages] = useState([]);

    const location = useLocation();
    const topic = location.state.topic;
    console.log(location)
    console.log(topic)
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

    return (
        <div>
            <h1>{topic.topicTitle}</h1>
                <p>{topic.topicDescription}</p>
                {/* Render the topic messages here */}
        </div>
        
    )
    }

export default TopicMessages