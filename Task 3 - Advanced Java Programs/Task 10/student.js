//Creating the student object with properties and  method
let student = {
    name: "John Doe",
    age: 21,
    grade: "A",
    displayInfo: function() {
        console.log(`Name: ${this.name}, Age: ${this.age}, Grade: ${this.grade}`);
    }
};

student.displayInfo();

//Adding nested object , two more functions
student.address = {
    city: "Chennai",
    country: "India"
};

student.updateGrade = function(newGrade) {
    this.grade = newGrade;
    console.log(`Updated Grade: ${this.grade}`);
};

student.getLocation = function() {
    console.log(`City: ${this.address.city}, Country: ${this.address.country}`);
};

//Accessing all properties and functions
student.displayInfo();
student.getLocation();
student.updateGrade("A+");

//Removing a normal property and  function
delete student.age;
delete student.updateGrade;

//Displaying the modified object details
console.log(student);
