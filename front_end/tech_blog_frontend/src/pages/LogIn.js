import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios';
import properties from '../properties.json';

function LogIn({setIsAuth, setUserId, setIsAdmin}) {
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
        .put(properties.base_URL + `/auth/login`, { email, password })
        .then((response) => {
            setUserData(response.data);
            console.log(response.data.idUser);
            localStorage.setItem("isAuth", true);
            setIsAuth(true);
            setUserId(response.data.idUser);
            console.log(response.data.role)
            if(response.data.role === 'ADMIN'){
              setIsAdmin(true);
              localStorage.setItem("isAdmin", true);
            }
            else{
              setIsAdmin(false);
              localStorage.setItem("isAdmin", false);
            }
            
            localStorage.setItem("userId", response.data.idUser);
            navigate("/");
        })
        .catch((err) => {
            console.log(err);
            setUserNotFoundError(true);
        });
  };

  return (
    <div className="formPage">
      <div className="dataContainer" style={{
                  color: 'black',
                  '@media (prefersColorScheme: dark)': {
                    color: 'white',
                  },
                }}>
        <h1>Sign in with your account</h1>
        <div className="dataInput">
          <label > Email:</label>
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