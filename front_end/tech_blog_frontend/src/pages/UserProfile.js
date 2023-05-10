import { useState, useEffect } from 'react';
import axios from 'axios';



function UserProfile(props) {
    const [userData, setUserData] = useState("");
    const [info, setInfo] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [showError, setShowError] = useState(false);
    const getUserProfile = (userId) => {
        console.log(userId);
        axios
        .get(`http://localhost:8080/api/v1/user/${userId}`)
        .then((response) => {
            setUserData(response.data);
        })
        .catch((err) => {
            console.log(err);
        });
    }  
    
    const updateUserData = () => {
        axios
        .put(`http://localhost:8080/api/v1/user/user_data`, {
                userId : props.userId,
                firstName : firstName,
                lastName : lastName,
                info : info
            })
        .then((response) => {
            setUserData(response.data);
            document.querySelectorAll('input').forEach(input => {
              input.value = '';
            });
            getUserProfile(props.userId) 
        })
        .catch((err) => {
            console.log(err);
        });
    }

    useEffect(() => {
        getUserProfile(props.userId) 
    }, [])  

  return (
    <div className="formPage">
      <div className="dataContainer">
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