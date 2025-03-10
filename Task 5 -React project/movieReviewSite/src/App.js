import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import ChildComponent from "./ChildComponent";
import RatingPage from "./RatingPage"; 
import "./App.css"
const App = () => {
  const [data, setData] = useState([]);
  const [inputValue, setInputValue] = useState({ title: "", director: "", release_year: "", genre: "" });

  useEffect(() => {
    axios.get("http://localhost:4500/movies")
      .then((response) => setData(response.data))
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("http://localhost:4500/movies", inputValue)
      .then((response) => {
        setData([...data, response.data]);
        setInputValue({ title: "", director: "", release_year: "", genre: "" });
      })
      .catch((error) => console.error("Error posting data:", error));
  };

  return (
    <Router>
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={
            <>
              <h2>Enter Movie Details</h2>
              <form onSubmit={handleSubmit} className="form">
                <div class="inputs">
                  <div class="input">
                    <span> <p>Title:</p></span>
                    <input
                      type="text"
                      className="form-control mb-2"
                      placeholder="Title"
                      value={inputValue.title}
                      onChange={(e) => setInputValue({ ...inputValue, title: e.target.value })}
                    />
                  </div>
                  <div class="input">
                    <span> <p>Director:</p></span>
                    <input
                      type="text"
                      className="form-control mb-2"
                      placeholder="Director"
                      value={inputValue.director}
                      onChange={(e) => setInputValue({ ...inputValue, director: e.target.value })}
                    />
                  </div>
                  <div class="input">
                    <span> Release <p>Year:</p></span>
                    <input
                      type="number"
                      className="form-control mb-2"
                      placeholder="Release Year"
                      value={inputValue.release_year}
                      onChange={(e) => setInputValue({ ...inputValue, release_year: e.target.value })}
                    />
                  </div>
                  <div class="input">
                    <span> <p>Genre:</p></span>
                    <input
                      type="text"
                      className="form-control mb-2"
                      placeholder="Genre"
                      value={inputValue.genre}
                      onChange={(e) => setInputValue({ ...inputValue, genre: e.target.value })}
                    />
                  </div>
                </div>
                <button type="submit" className="btn btn-primary"  style={{ width: '25%' }}>Submit</button>
              </form>
              <ChildComponent items={data} />
            </>
          } />
          <Route path="/rating/:id" element={<RatingPage />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
