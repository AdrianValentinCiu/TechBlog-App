import './App.css';
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom" 
import Topics from "./pages/Topics"
import CreatePost from "./pages/CreatePost"
import LogIn from "./pages/LogIn"
import TopicMessages from "./pages/TopicMessages"
import Register from "./pages/Register"
import React, { useState } from 'react'
import axios from 'axios';


function App() {
  const [isAuth, setIsAuth] = useState(false);
  const [userId, setUserId] = useState("");
  const signOutUser = () => {
    console.log(userId)
    axios
    .put(`http://localhost:8080/api/v1/auth/logout`, {id : userId})
    .then((response) => {
        setIsAuth(false);
        console.log(response.data.idUser);
        localStorage.clear();
    })
    .catch((err) => {
        console.log(err);
    });

  }
  return (
    <Router>
      <nav>
        <Link to="/"> Topics </Link>
        <Link to="/createpost"> Create Post </Link>
        {!isAuth ? <Link to="/login"> LogIn </Link> : <button onClick={signOutUser} className='fancybtn'> Log Out</button>}
        {!isAuth && <Link to="/register"> Register </Link> }
      </nav>
      <Routes>
        <Route path="/" element={<Topics />}/>
        <Route path="/createpost" element={<CreatePost />}/>
        <Route path="/login" element={<LogIn setIsAuth={setIsAuth} setUserId={setUserId}/>}/>
        <Route path="/topic_messages" element={<TopicMessages isAuth={isAuth}/>}/>
        <Route path="/register" element={<Register />}/>
      </Routes>
    </Router>
  );
}

export default App;
