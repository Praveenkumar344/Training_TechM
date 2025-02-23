// Pass a number, and find if the sum of their digits
//  is an even or odd number

function sumofdigit(n){
    if(n<0){
        return 0;
    }
    return (n%10+sumofdigit(n/10));
}
var n= sumofdigit(122);
if(n%2 == 0){
    console.log("even");
}

else{
    console.log("odd");}