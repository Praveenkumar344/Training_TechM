import React from "react";
import { useNavigate } from "react-router-dom"; 
import "./ChildComponent.css";
import axios from "axios";

const ChildComponent = ({ items }) => {
    const navigate = useNavigate(); 

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:4500/movies/${String(id)}`);
            window.location.reload();
        } catch (error) {
            console.error('Error deleting item:', error);
        }
    };

    const handleRating = (id) => {
        navigate(`/rating/${id}`); 
    };

    return (
        <div>
            <h4>Available Movie Details:</h4>
            <ul className="list-group">
                {items.map((item) => (
                    <div className="details_delete" key={item.id}>
                        <li className="list-group-item">
                            <p><strong>Title:</strong> {item.title}</p>
                            <p><strong>Director:</strong> {item.director}</p>
                            <p><strong>Release Year:</strong> {item.release_year}</p>
                            <p><strong>Genre:</strong> {item.genre}</p>
                        </li>
                        <div style={{margin:"5px"}}>
                        <button  style={{margin:"5px"}}className="rating btn btn-success" onClick={() => handleRating(item.id)}>Rate</button>
                        <button className="delete btn btn-danger" onClick={() => handleDelete(item.id)}>Delete</button>
                    </div></div>
                ))}
            </ul>
        </div>
    );
};

export default ChildComponent;
