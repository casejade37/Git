// primitives: nubmer, string, boolean
// more complex types: arrays, objects
// funtion types, parameters

// primitives

let age: number = 24;

age = 12.1;

let userName : string | string[]; // lower case, upper case refers to object

userName = 'Max';

let isInstructor: boolean;

isInstructor = true;

// more complex types

let hobbies: string[]; // an array of strings

hobbies = ['Sports', 'Cooking'];

let person: {
    name: string;
    age: number;
}; // any type if not specified

person = {
    name: 'Max',
    age: 32
};

// person = {
//     isEmployee: true
// };

let people: {
    name: string;
    age: number;
}[]; // array of objects

// Type inference

// let course = 'React';

// course = 12341 // can't assign as inferred as string

let course: string | number = 'react';

course = 1234;

// type alias: pure typescript feature, not javascript
// used to save coding efforts

type Person = {
        name: string;
        age: number;
    };

// functions & types

function add(a: number, b: number) {
    return a + b; // return type inferred here
}

// function print(value: any) { // special void return type, never return a value
//     console.log(value);
// }

// Generics<>: not javascript feature -> flexibility

function insertAtBeginning<T>(array: T[], value: T) {
    const newArray = [value, ...array];
    return newArray;
}

const demoArray = [1, 2, 3];

const updatedArray = insertAtBeginning(demoArray, -1); // [-1, 1, 2, 3]
const stringArray = insertAtBeginning(['a', 'b', 'c'], 'd')

//  updatedArray[0].split('');

class Student {
    firstName: string;
    lastName: string;
    age: number;
    course: string[];

    constructor(public first: string, public last: string, public ages: number, private courses: string[]) {
        this.firstName = first;
        this.lastName = last;
        this.age = ages;
        this.course = courses;
    }

    enroll(courseName: string) {
        this.courses.push(courseName);
    }

    listCourses() {
        return this.courses.slice();
    }
}

const student = new Student('Jay', 'Song', 31, ['Angular']);
student.enroll('React');
student.listCourses();

// interface 
interface Human {
    firstName: string;
    age: number;

    greet: () => void;
}

class Instructor implements Human {
    firstName: string;
    age: number;
    greet() {
        console.log('hello!!');
    }
}