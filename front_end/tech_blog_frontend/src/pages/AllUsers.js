import { useNavigate } from 'react-router-dom'
import axios from 'axios';
import { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';

function AllUsers(props) {
  const [adminId, setAdminId] = useState(props.userId);
  const [user, setUser] = useState([]);
  
  function getAllUsers(){
    axios
    .get("http://localhost:8080/api/v1/user/users")
    .then((response) => {
      setUser(response.data);
    })
    .catch((err) => {
        console.log(err);
    });
  }

  function deleteUser(adminId, userId){
    console.log(adminId);
    console.log(userId);
    axios
        .delete(`http://localhost:8080/api/v1/user/delete_user`, { data: { id: userId, idAdminUser: adminId } })
        .then( () => {
          getAllUsers();

        })
        .catch((err) => {
           console.log(err);
        });
  }

  useEffect(() => {
      getAllUsers();
  }, [])
  return (
    <div className='createPostPage'>
        <div className="topic-messages-container">
          <ul>
            {user.map((usr) => (
              <li key={usr.idUser}>
                  <div className="post">
                    <div className="postTextContainer">
                      {usr.email}
                    </div>
                    <div className='deletePost' onClick={() =>deleteUser(adminId, usr.idUser)}>
                      <button>&#128465;</button>
                    </div>
                </div>
              </li>
            ))}
          </ul>
          </div>
      </div>
  )
}

export default AllUsers