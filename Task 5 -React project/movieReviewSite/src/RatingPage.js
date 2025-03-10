import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom"; 
import axios from "axios";

const RatingPage = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [movie, setMovie] = useState(null);
    const [rating, setRating] = useState("");

    useEffect(() => {
        fetchMovie();
    }, []);

    const fetchMovie = async () => {
        try {
            const response = await axios.get(`http://localhost:4500/movies/${id}`);
            setMovie(response.data);
        } catch (error) {
            console.error("Error fetching movie:", error);
        }
    };

    const handleRatingSubmit = async () => {
        if (!rating) return;

        const newRating = (movie.rating * movie.rating_count + parseFloat(rating)) / (movie.rating_count + 1);

        try {
            await axios.patch(`http://localhost:4500/movies/${id}`, {
                rating: newRating.toFixed(1),
                rating_count: movie.rating_count + 1
            });
            navigate("/"); 
        } catch (error) {
            console.error("Error updating rating:", error);
        }
    };

    if (!movie) return <p>Loading...</p>;

    return (
        <div className="container mt-4">
            <h2>Rate Movie</h2>
            <p><strong>Title:</strong> {movie.title}</p>
            <p><strong>Director:</strong> {movie.director}</p>
            <p><strong>Release Year:</strong> {movie.release_year}</p>
            <p><strong>Genre:</strong> {movie.genre}</p>
            <p><strong>Current Rating:</strong> {movie.rating} (Rated by {movie.rating_count} users)</p>

            <input
                type="number"
                min="0"
                max="10"
                step="0.1"
                className="form-control mb-2"
                value={rating}
                onChange={(e) => setRating(e.target.value)}
                placeholder="Enter your rating (0-10)"
            />
            <button className="btn btn-primary" onClick={handleRatingSubmit}>Submit Rating</button>
        </div>
    );
};

export default RatingPage;
