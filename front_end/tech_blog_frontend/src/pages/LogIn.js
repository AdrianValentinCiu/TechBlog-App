import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';


function LogIn({setIsAuth, setUserId}) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userData, setUserData] = useState("");
  const [showError, setShowError] = useState(false);
  const [showUserNotFoundError, setUserNotFoundError] = useState(false);
  let navigate = useNavigate();

  const logInUser = () => {
    if (!email || !password) {
      setShowError(true);
      return;
    }
    axios
        .put(`http://localhost:8080/api/v1/auth/login`, { email, password })
        .then((response) => {
            setUserData(response.data);
            console.log(response.data.idUser);
            localStorage.setItem("isAuth", true);
            setIsAuth(true);
            localStorage.setItem("isAuth", true);
            setUserId(response.data.idUser);
            localStorage.setItem("idUser", response.data.idUser);
            navigate("/");
        })
        .catch((err) => {
            console.log(err);
            setUserNotFoundError(true);
        });
};

  return (
    <div className="formPage">
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
        {showError && (
          <div className="errorPopupRight">
            Please fill all input fields.
            <button onClick={() => setShowError(false)}>X</button>
          </div>
        )}
        {showUserNotFoundError && (
          <div className="errorPopupLeft">
            User not found
            <button onClick={() => setUserNotFoundError(false)}>X</button>
          </div>
        )}
    </div>
    </div>
    
  )
}

export default LogIn