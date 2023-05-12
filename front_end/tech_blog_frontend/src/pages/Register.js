import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';
import properties from '../properties.json';

function Register() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [checkPassword, setCheckPassword] = useState("");
  const [userData, setUserData] = useState("");
  const [showError, setShowError] = useState(false);
  const [showPasswordError, setShowpasswordError] = useState(false);

  let navigate = useNavigate();

  const logInUser = () => {
    if (!email || !password || !checkPassword) {
      setShowError(true);
      return;
    }

    if (!email || !password || !checkPassword || password !== checkPassword) {
      setShowpasswordError(true);
      return;
    }

    axios
        .post(properties.base_URL + `/auth/register`, { email, password })
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
    <div className="formPage" >
      <div className="dataContainer" style={{
                  color: 'black',
                  '@media (prefersColorScheme: dark)': {
                    color: 'white',
                  },
                }}>
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