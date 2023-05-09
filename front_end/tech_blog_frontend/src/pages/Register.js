import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';


function Register() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [checkPassword, setCheckPassword] = useState("");
  const [userData, setUserData] = useState("");
  const [showError, setShowError] = useState(false);
  const [showPasswordError, setShowpasswordError] = useState(false);

  let navigate = useNavigate();

  const logInUser = () => {
    //console.log(email);
    //console.log(password);
    if (!email || !password || !checkPassword) {
      setShowError(true);
      return;
    }

    if (!email || !password || !checkPassword || password !== checkPassword) {
      setShowpasswordError(true);
      return;
    }

    axios
        .post(`http://localhost:8080/api/v1/auth/register`, { email, password })
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
        <h1>Register with a new account</h1>
        <div className="dataInput">
          <label> Email:</label>
          <input placeholder="email" onChange={(event) => {setEmail(event.target.value)}}/>
        </div>
        <div className="dataInput">
          <label> Password:</label>
          <input placeholder="Password" type="password" onChange={(event) => {setPassword(event.target.value)}} />
        </div>
        <div className="dataInput">
          <label> Password:</label>
          <input placeholder="Password" type="password" onChange={(event) => {setCheckPassword(event.target.value)}} />
        </div>
        <button onClick={logInUser} className='fancybtn' >
          Register
        </button>
        {showPasswordError && (
          <div className="errorPopupLeft">
            Passwords do not match. Please try again.
            <button onClick={() => setShowpasswordError(false)}>X</button>
          </div>
        )}
        {showError && (
          <div className="errorPopupRight">
            Please fill all input fields.
            <button onClick={() => setShowError(false)}>X</button>
          </div>
        )}
    </div>
    </div>
    
  )
}

export default Register