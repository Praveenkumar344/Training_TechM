
var choice=prompt("enter the operation 1.ADD \n2.SUBRACT\n3.MUL\n4.DIV")
let i=prompt("enter the number 1")
let j=prompt("enter the number 2")
operation =()=>{
switch(choice){
    case 1:
        console.log(()=>(i+j));
        break;
    case 1:
        console.log(()=>(i-j));
        break;
    case 2:
        console.log(()=>(i*j));
        break;
    case 3:
        if(j==0)
            console.log("num 2 can't be zero");
        else
        console.log(()=>(i/j));
        break;
        default:
            console.log("Enter the correct option");
}}
operation()