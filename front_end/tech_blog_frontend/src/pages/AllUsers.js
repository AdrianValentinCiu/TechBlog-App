import axios from 'axios';
import { useState, useEffect } from 'react';
import properties from '../properties.json';

function AllUsers(props) {
  const [adminId, setAdminId] = useState(props.userId);
  const [user, setUser] = useState([]);
  
  function getAllUsers(){
    axios
    .get(properties.base_URL + "/user/users")
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
        .delete(properties.base_URL + `/user/delete_user`, { data: { id: userId, idAdminUser: adminId } })
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