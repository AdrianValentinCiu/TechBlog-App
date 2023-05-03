import './App.css';
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom" 
import Home from "./pages/Home"
import CreatePost from "./pages/CreatePost"
import LogIn from "./pages/LogIn"

function App() {
  return (
    <Router>
      <nav>
        <Link to="/"> Home </Link>
        <Link to="/createpost"> Create Post </Link>
        <Link to="/login"> LogIn </Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/createpost" element={<CreatePost />}/>
        <Route path="/login" element={<LogIn />}/>
      </Routes>
    </Router>
  );
}

export default App;
