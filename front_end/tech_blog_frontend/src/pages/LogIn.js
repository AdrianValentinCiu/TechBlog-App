import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';


function LogIn() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userData, setUserData] = useState("");

  let navigate = useNavigate();

  const logInUser = () => {
    //console.log(email);
    //console.log(password);
    axios
        .put(`http://localhost:8080/api/v1/auth/login`, { email, password })
        .then((response) => {
            setUserData(response.data);
            console.log(response.data.idUser);
            navigate("/");
        })
        .catch((err) => {
            console.log(err);
        });
};

  return (
    <div className="loginPage">
      <div className="dataContainer">
        <h1>Sign in with your account</h1>
        <div className="dataInput">
          <label> Email:</label>
          <input placeholder="email" onChange={(event) => {setEmail(event.target.value)}}/>
        </div>
        <div className="dataInput">
          <label> Password:</label>
          <input placeholder="Password" type="password" onChange={(event) => {setPassword(event.target.value)}} />
        </div>
        <button onClick={logInUser} className='fancybtn' >
          Sing in
        </button>
    </div>
    </div>
    
  )
}

export default LogIn