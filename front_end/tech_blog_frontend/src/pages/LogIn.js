import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function LogIn() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  let navigate = useNavigate();

  const logInUser = () => {
    console.log(email)
    console.log(password)
    navigate("/")
  }

  return (
    <div className="loginPage">
      <div className="createPostPage">
      <div className="dataContainer">
        <h1>Sign in with your account</h1>
        <div className="dataInput">
          <label> Email:</label>
          <input placeholder="email" onChange={(event) => {setEmail(event.target.value)}}/>
        </div>
        <div className="dataInput">
          <label> Password:</label>
          <input placeholder="password" onChange={(event) => {setPassword(event.target.value)}}/>
        </div>
        <button onClick={logInUser} className='fancybtn' >
          Sing in
        </button>
      </div>
    </div>
    </div>
    
  )
}

export default LogIn