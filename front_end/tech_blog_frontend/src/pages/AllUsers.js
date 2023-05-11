import { useNavigate } from 'react-router-dom'
import axios from 'axios';
import { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';

function AllUsers(props) {
  console.log(props.userId);
  function getAllUsers(){
    axios
    .get("http://localhost:8080/api/v1/user/users")
    .then((response) => {
      
    })
    .catch((err) => {
       console.log(err);
    });
  }

useEffect(() => {
    getAllUsers();
  //console.log(topicMessages)
}, [])
  return (
    <div>{props.userId}</div>
    
  )
}

export default AllUsers