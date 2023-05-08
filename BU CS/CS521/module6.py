'''
An object is an instance of a class.
Class: Blueprint/plan/template
'''

# Dice class: 
# Operation -> Roll to change state
from random import randrange
class Dice:
    # constructor (called by intepreter to instantiate the first object): __new__ (rarely used)
    # or strictly speaking, initializer (after object has been instantiated): __init__ 
    def __init__(self, sides = 6):
        # 'self' refers to the object, similar to 'this', except 'self' is not keyword ('this' is a keyword)
        self.sides = sides
        # left side: instance attributes. right side: parameter of function
        self.value = 1

    def roll(self) -> None:
        self.value = randrange(1, self.sides + 1)

    def getValue(self):
        return self.value

    def setValue(self, newValue):
        self.value = newValue

# method: bound to an object
d1.setValue
# <bound method Dice.roll of <__main__.Dice object at 0x107dbc580>>
d1.setValue(5) # 1 argument

# function: need to specify an object
Dice.setValue
# <function __main__.Dice.setValue(self, newValue)>
Dice.setValue(d1, 5) # 2 arguments

# Everything in Python is public
# if want to define private: add __ up front

class Dice:
    def __init__(self, sides = 6):
        self.__sides = sides
        self.__value = 1    
# Name mangling: changed object name to _Dice__value

# class is an object in Python, whereas it is not in other compiling languages.
class Dice:

    material = 'plastic'

    def __init__(self, sides = 6):
        self.__sides = sides
        self.__value = 1

    def roll(self) -> None:
        self.setValue(randrange(1, self.__sides + 1))

    def getValue(self):
        return self.__value

    def setValue(self, newValue):
        self.__value = newValue

# Decorater: bound method to the class instead of the object
# shared by all objects in the class: change one, another is changed as well.
    @classmethod
    def convert(cls, newMaterial):
        cls.material = newMaterial

# Inheritance
class Dice:

    def __init__(self, sides = 6):
        self.sides = sides
        self.value = 1

    def roll(self) -> None:
        self.setValue(randrange(1, self.sides + 1))

    def getValue(self):
        return self.value


# polymorphism: a built-in feature of Python

# These method overloading don't exist in Python:
# int add(int a, int b)
# float add(float a, float b)
# Decimal add(Decimal a, Decimal b)

# Python has a strong and dynamic type system

a = 7
len(a)
# error
# int does not have __len__ 

raise NotImplementedError
# Python doesn't have abstract class like Java, but this is a way to act like abstract class

# self represents the object: whenever calling method, start with class object instantiated from
class Student: 
    def __str__(self):
        return "Student"

    def printStudent(self):
        print(self.__str__())

class GraduateStudent(Student):
    def __str__(self):
        return "Graduate Student"

a = Student()
b = GraduateStudent()
a.printStudent()
b.printStudent()
# Student
# Graduate Student

