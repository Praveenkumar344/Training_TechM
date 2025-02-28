
// 2. Pass a parameter, and display the factors of that 
// parameter in the function
function factors( n){
    for(let i=1;i<=n;i++){
        if(n%i ==0){
            console.log(i);
        }
    }
}
factors(24);