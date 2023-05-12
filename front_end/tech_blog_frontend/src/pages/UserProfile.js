import { useState, useEffect } from 'react';
import axios from 'axios';
import properties from '../properties.json';


function UserProfile(props) {
    const [userData, setUserData] = useState("");
    const [info, setInfo] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [showError, setShowError] = useState(false);
    const [userId, setUserId] = useState(0);

    useEffect(() => {
      setUserId(props.userId);
    }, [props.userId]);
    
    useEffect(() => {
      const storedUserData = localStorage.getItem('storedUserData');
      if (storedUserData) {
        setUserData(storedUserData);
      }
      console.log(userData);
      const storedUserId = localStorage.getItem('userId');
      if (storedUserId) {
        setUserId(storedUserId);
      }
      console.log(userId);
    }, []);
    
    useEffect(() => {
      if (userId) {
        getUserProfile(userId);
      }
    }, [userId]);

    const getUserProfile = (userId) => {
        console.log(userId);
        axios
        .get(properties.base_URL + `/user/${userId}`)
        .then((response) => {
            setUserData(response.data);
            localStorage.setItem("storedUserData", response.data);
        })
        .catch((err) => {
            console.log(err);
        });
    }  
    
    const updateUserData = () => {
        axios
        .put(properties.base_URL + `/user/user_data`, {
                userId : userId,
                firstName : firstName,
                lastName : lastName,
                info : info
            })
        .then((response) => {
            setUserData(response.data);
            localStorage.setItem("storedUserData", response.data);
            document.querySelectorAll('input').forEach(input => {
              input.value = '';
            });
            getUserProfile(userId) 
        })
        .catch((err) => {
            console.log(err);
        });
    }


  return (
    <div className="formPage">
      <div className="dataContainer" style={{
                  color: 'black',
                  '@media (prefersColorScheme: dark)': {
                    color: 'white',
                  },
                }}>
        <div className="dataInput">
          <label> Email: {userData.email}</label>
          <label> Full Name: {userData.fullName}</label>
          <label> Info: {userData.info}</label>
        </div>
        <div className="dataInput">
          <label> First Name:</label>
          <input placeholder="FirstName" onChange={(event) => {setFirstName(event.target.value)}}/>
        </div>
        <div className="dataInput">
          <label> Last Name:</label>
          <input placeholder="LastName" onChange={(event) => {setLastName(event.target.value)}}/>
        </div>
        <div className="dataInput">
          <label> About You:</label>
          <input placeholder="Info" onChange={(event) => {setInfo(event.target.value)}}/>
        </div>
        <button onClick={updateUserData} className='fancybtn' >
          Update User Data
        </button>
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

export default UserProfile