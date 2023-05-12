import './App.css';
import {BrowserRouter as Router, Routes, Route, Link } from "react-router-dom" 
import Topics from "./pages/Topics"
import CreatePost from "./pages/CreatePost"
import LogIn from "./pages/LogIn"
import TopicMessages from "./pages/TopicMessages"
import UserProfile from "./pages/UserProfile"
import Register from "./pages/Register"
import AllUsers from "./pages/AllUsers"
import NotifyUsers from "./pages/NotifyUsers"
import React, { useState, useEffect  } from 'react'
import axios from 'axios';


function App() {
  const [isAuth, setIsAuth] = useState(false);
  const [isAdmin, setIsAdmin] = useState(false);
  const [userId, setUserId] = useState("");

  useEffect(() => {
    const storedIsAuth = localStorage.getItem('isAuth');
    if (storedIsAuth) {
      setIsAuth(storedIsAuth);
    }

    const storedIsAdmin = localStorage.getItem('isAdmin');
    if (storedIsAdmin) {
      setIsAdmin(storedIsAdmin);
    }

    const storedUserId = localStorage.getItem('userId');
    if (storedUserId) {
      setUserId(storedUserId);
    }
  }, []);

  const signOutUser = () => {
    console.log(userId)
    localStorage.clear();
    axios
    .put(`http://localhost:8080/api/v1/auth/logout`, {id : userId})
    .then((response) => {
        console.log(userId);
        setIsAuth(false);
        setIsAdmin(false);
        setUserId("")
        window.location.replace('http://localhost:3000');
        
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
        {isAuth && <Link to="/userprofile"> User Profile </Link>}
        {isAuth && isAdmin && <Link to="/allusers"> All Users </Link>}
        {isAuth && isAdmin && <Link to="/notifyusers"> Notify </Link>}
        {!isAuth ? <Link to="/login"> LogIn </Link> : <button onClick={signOutUser} className='fancybtn'> Log Out</button>}
        {!isAuth && <Link to="/register"> Register </Link> }
      </nav>
      <Routes>
        <Route path="/" element={<Topics />}/>
        <Route path="/createpost" element={<CreatePost userId={userId}/>}/>
        <Route path="/userprofile"  element={<UserProfile userId={userId}/>}/>
        <Route path="/allusers"  element={<AllUsers userId={userId}/>}/>
        <Route path="/notifyusers"  element={<NotifyUsers/>}/>
        <Route path="/login" element={<LogIn setIsAuth={setIsAuth} setUserId={setUserId} setIsAdmin={setIsAdmin}/>}/>
        <Route path="/topic_messages" element={<TopicMessages isAuth={isAuth} userId={userId}/>}/>
        <Route path="/register" element={<Register />}/>
      </Routes>
    </Router>
  );
}

export default App;
