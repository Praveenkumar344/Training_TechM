function runIt(){var choice;
var n;
console.log("1.cube \n2.positive or negative \n3.prime or not\n4.alert - address\n5.confirmatoin box - film\n6.prompt box - age\n7.divisible by 12 or not\n8.tomato's profit checker\n9.leapyear or not \n10.student Advice\n11.Days Of The Week");
choice = parseInt(prompt("select your choice "));
switch(choice){
    case 1:
        n=parseInt(prompt("Enter the number to find its cube"));
        console.log(n*n*n);
        break;
    case 2:
         n=parseInt(prompt("Enter the number to find it is positive or negative"));
        console.log(n>=0?"POSITIVE":"NEGATIVE");
        break;
    case 3:
         const a =parseInt(prompt("Enter the number to find it is prime or not"));
        if(isprime(a)){
            console.log("given number is prime");
        }else{
            console.log("given number is nor prime");
        }
        break;
    case 4:
        let address=prompt("Enter your address : ")
        alert("Your address is : "+ address)
        break;
    case 5:
        let b=true;
        let c= confirm("are u going to film today")
        alert ("you are "+(c?"":"not ")+"going to film")
        break;
    case 6:
        n= prompt("Enter the age ");
        console.log(n);
        break;
    case 7:
        n=prompt("Enter the number")
        if(n%12 ==0 ){
            console.log("the given number is divsible by 12")
        }
        else console.log("the given number is not divsible by 12")
        break;
    case 8:
        let sum=0;
        for(let i=0;i<7;i++){
            sum+=prompt("Enter the "+(i+1)+"th day price");
        }
        if((sum/7)>50 ){
            console.log("tomato has given good profit.");
        }
        else{
            console.log("No profit from tomato");
        }break;
    case 9:
        leapyear();
        break;
    case 10:
        studentAdvice();
        break;
    case 11:
        daysOfWeek();
    case 12:
        mulTables();
    case 13:
        mulTableFrom2ndNumto40thNum();
    case 14:
        interval30();
    default :
        console.log("incorrect selection")

}}
function studentAdvice(){
    let mark = parseInt(prompt("Enter the mark : "))
    if(mark == 100){
        console.log("Phenomenal!")
    }else if(mark>85){
        console.log("Excellent!")
    }else if(mark>71){
        console.log("Good work!")
    }else if(mark>51){
        console.log("Practice well!")
    }else {
        console.log( "Hard work is needed")
    }
}
function leapyear(){
    let year=parseInt(prompt("Enter the year"));
    let month=parseInt(prompt("Enter the month"));
    if((year %100 != 0 && (year%4 )== 0) || (year % 100 == 0 && year%400 == 0) ){
        if(month == 2){
            alert( "The year is leap year and the month is February with 29 days.");
        }else{
            alert("The year is leap year and the month is not February ");
        }
    }else{
        alert("The given year is not a leap year")
    }
}
function isprime(a){
    for(let i=2;i<a;i++){
        if(a%2 == 0 )
            return false;
    }
    return true;
}
function daysOfWeek(){
    var day = prompt("Enter the day : ");
    var str;
    switch(day){
        case "Monday":
            str="Start of the week!";break;
        case "Tuesday":
        case "Wednesday":
        case "Thursday":
            str ="Mid of the week!";
            break;
        case "Friday":
            str = "Last working day of the week!";
            break;
        case "Saturday":
            str="Weekend - Saturday";
            break;
        case "Sunday":
            str="Weekend - Sunday";
            break;
        default:
            str="enter valid day";
    }
    console.log(str);
}
function mulTables(){
    let i=prompt("entet the table number")
    let j=prompt("entet the table last number")

    for(let i=0;i<=j;i++){
        console.log(i+" * "+j+" = "+(i*j));
    }
}
function mulTableFrom2ndNumto40thNum(){
    
    let i=prompt("entet the table number")
    let j=prompt("entet the table last number")
    
    for(let j;j<=j+20;j++){
        console.log(i+" * "+j+" = "+(i*j));
    }
}
function interval30(){

    let i=prompt("entet the first number")
    let j=prompt("entet the second number with 30 interval")
    if((j-i)!=30){
        alert("enter valid number");
    }else{
        for(;i<=j;i++){
            if(i%7 == 0)
                return;
            console.log(i +" ")
        }
    }

}
