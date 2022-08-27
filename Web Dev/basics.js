// let, const 

// arrow
const myfunc = (name) => {
    console.log(name);
}

// exports

const person = {
    name: 'Jay';
}
export default person;

export const clean = () => {...};
export const baseData = 10;

// other file imports
import person from './basics.js'
import {baseData} from './basics.js'
import {clean} from './basics.js'

// class 
class Person {
    name='Jay';
    call = () => {...};
}

// usage
const myPerson = new Person();
myPerson.call();
console.log(myPerson.name)

// inheritance
class Person extends Master {}

// e.g.
class Human {
    constructor() {
        this.gender = 'male';
    }

    printGender() {
        console.log(this.gender);
    }
}

class Person extends Human {
    constructor() {
        super();
        this.name = 'Jay';
        this.gender = 'MALE';
    }

    printMyName() {
        console.log(this.name);
    }
}

const persons = new Person();
person.printMyName();
person.printGender();

// ES7 e.g.
class Human {
    gender = 'male';

    printGender = () => {
        console.log(this.gender);
    }
}

class Person extends Human {

        name = 'Jay';
        gender = 'MALE';
    

    printMyName = () => {
        console.log(this.name);
    }
}

const personses = new Person();
person.printMyName();
person.printGender();

// Spread & Rest Operators
// ...
// Spread
const newArray = [...oldArray, 1, 2];
const newObject = {...oldObject, newProp:5};
// Rest
function sortArgs(...args) {
    return args.sort();
}

// e.g.
const numbers = [1, 2, 3];
const newNumbers = [...numbers, 4]; // [1, 2, 3, 4]

const person = {
    name: 'Jay'
};

const newPerson = {
    ...person,
    age: 31
}

const filter = (...args) => {
    return args.filter(el => el === 1);
}

// Destructuring
const num = [1, 2, 3];
[num1, ,num3] = num; // 1  3

// reference type (object) will copy pointers instead of object itself.
const first = {
    name: 'Jay'
};

const second = first;
// solution: create a real copy
'''const second = {
    ...first;
}'''

first.name = 'Manu'; 
console.log(second); // name: 'Manu'

// array functions
const nums = [1, 2, 3]
const doubleNumArray = nums.map((num) => {
    return num * 2;
});