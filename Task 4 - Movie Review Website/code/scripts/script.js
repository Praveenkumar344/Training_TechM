var data;
var reviews;
var emojis=[128512,128513,128514,128541	,128535,128525,128521,128526,	128519,128540]
document.addEventListener('DOMContentLoaded', function() {
    fetch('./Json/movieDetails.json')
        .then(response => response.json())
        .then(d => {
            let path = window.location.pathname;
             data=d.movies;
            reviews=d.reviews;
             console.log(path);
             if(path.includes("index.html")){
                displayTopMovies();
                displayJustReviewed();
            }else if(path.includes("listMovies.html")){
                displayAllMovies();
            }else if(path.includes("search.html")){
                displaySearched();
            }else if(path.includes("movDetails.html")){
                displayMovDetails();
                displayReviews();
                addReview();
            }

        }).catch(error => console.error('Error fetching the movie details:', error)); 
        })


function displayTopMovies(){
    const topMovies=document.querySelector (".topMovies");

    for(let i=0;i<3;i++){
    let topmovie=document.createElement("div");
    topmovie.className="topmovie";

    let img=document.createElement("img");
    img.src=data[i].src;
    img.alt=data[i].title;
    topmovie.appendChild(img);

    let title=document.createElement("h2");
    title.textContent=data[i].title;
    topmovie.appendChild(title);
    topmovie.onclick=function(){
        window.location.href="movDetails.html?movName="+data[i].title;
    }
    topMovies.appendChild(topmovie);
}}

function displayJustReviewed(){
    const justReviewed=document.querySelector(".justReviewed");

    for(let i=3;i<15;i++){
    let justreviewed=document.createElement("div");
    justreviewed.className="justReviewedItems";

    let img=document.createElement("img");
    img.src=data[i].src;
    img.alt=data[i].title;
    justreviewed.appendChild(img);

    let title=document.createElement("h2");
    title.textContent=data[i].title;
    justreviewed.appendChild(title);
    justreviewed.onclick=function(){
        window.location.href="movDetails.html?movName="+data[i].title;
    }
    justReviewed.appendChild(justreviewed);}
}

function displayAllMovies(){
    const allMovies=document.querySelector(".allMovies");

    for(let i=0;i<15;i++){
        let movie=document.createElement("div");
        movie.className="allMoviesItems";

        let img=document.createElement("img");
        img.src=data[i].src;
        img.alt=data[i].title;
        movie.appendChild(img);

        let title=document.createElement("h2");
        title.textContent=data[i].title;
        movie.appendChild(title);  
        movie.onclick=function(){
            window.location.href="movDetails.html?movName="+data[i].title;
        }
        allMovies.appendChild(movie);
    }
}

function displaySearched(){
    const searchBar=document.querySelector(".searchBar input");
    const searchResults=document.querySelector(".searchResults");
    const displaySearchedMovie=document.querySelector(".allMovies");
    const resultTag=document.getElementById("resultH3");
    searchBar.onkeyup=function(){
        searchResults.innerHTML="";
        displaySearchedMovie.innerHTML="";
        if(searchBar.value===""){
            resultTag.style.display="none";
            return;
        }
        resultTag.style.display="block";
        resultMovies=data.filter(movie=>movie.title.toLowerCase().includes(searchBar.value.toLowerCase()));
        
        for(let i=0;i<resultMovies.length;i++){
            let movie=document.createElement("li");
            movie.className="searchResult";
            movie.innerHTML=resultMovies[i].title;
            
            movie.onclick=function(){
                searchBar.value=movie.innerHTML;
                searchResults.innerHTML="";
                searchBar.dispatchEvent(new Event ("keyup"));
            }
            searchResults.appendChild(movie);



                let searchResultDisplay=document.createElement("div");
                searchResultDisplay.className="allMoviesItems";
        
                let img=document.createElement("img");
                img.src=resultMovies[i].src;
                img.alt=resultMovies[i].title;
                searchResultDisplay.appendChild(img);
        
                let title=document.createElement("h2");
                title.textContent=resultMovies[i].title;
                searchResultDisplay.appendChild(title);  
                searchResultDisplay.onclick=function(){
                    window.location.href="movDetails.html?movName="+resultMovies[i].title;
                }
                displaySearchedMovie.appendChild(searchResultDisplay);
        }
    }
}
function displayMovDetails(){
    const urlParams = new URLSearchParams(window.location.search);
    const name = urlParams.get("movName");
    const mov=data.find(movie=>movie.title===name);
    const img=document.querySelector(".movDetail img");
    img.src=mov.src;
    img.alt=mov.title;
    document.querySelector("#title").innerHTML=mov.title;
    document.querySelector("#genre").innerHTML=mov.genre;
    document.querySelector("#year").innerHTML=mov.year;
    document.querySelector("#summary").innerHTML=mov.summary ;

}
function displayReviews(){
    const allReviews=document.querySelector(".allReviews");
    allReviews.innerHTML="";
    for(let i=0;i<reviews.length;i++){

        let review=document.createElement("div");
        review.className="review";
        // const randomEmoji = arr => emojis[Math.random() * arr.length | 0];
        const randomItem = (arr, randomFn = Math.random) => arr[randomFn() * arr.length | 0];
        review.innerHTML="&#"+randomItem(emojis) +" : "+reviews[i];
        allReviews.appendChild(review);

    }

}
function addReview(){
    const addReview=document.querySelector("#submit-review");
    const reviewInput=document.querySelector("#user-review");
    addReview.onclick=function(){
        if(reviewInput.value===""){
            return;
        }
        reviews.unshift(reviewInput.value);
        reviewInput.value="";
        displayReviews();
    }
}