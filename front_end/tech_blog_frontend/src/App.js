import './App.css';
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom" 
import Home from "./pages/Home"
import CreatePost from "./pages/CreatePost"
import LogIn from "./pages/LogIn"
import TopicMessages from "./pages/TopicMessages"
import Register from "./pages/Register"
import React, { useState } from 'react'
import axios from 'axios';

function App() {
  const [isAuth, setIsAuth] = useState(false);

  const signOutUser = () => {
    axios
    .put(`http://localhost:8080/api/v1/auth/logout`, {  })
    .then((response) => {
        setIsAuth(response.data);
        console.log(response.data.idUser);
    })
    .catch((err) => {
        console.log(err);
    });

  }
  return (
    <Router>
      <nav>
        <Link to="/"> Home </Link>
        <Link to="/createpost"> Create Post </Link>
        <Link to="/login"> LogIn </Link>
        <Link to="/register"> Register </Link> 
      </nav>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/createpost" element={<CreatePost />}/>
        <Route path="/login" element={<LogIn />}/>
        <Route path="/topic_messages" element={<TopicMessages />}/>
        <Route path="/register" element={<Register />}/>
      </Routes>
    </Router>
  );
}

export default App;
