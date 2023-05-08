'''
2.5: One of the most common beginning programming problems is the fizz‐buzz challenge. Write a Python program as follows:
a. After the program docstring, declare a constant variable named MAXVAL with a value of 30,
b. Create a for loop that will loop through all values from 1 to 30, using MAXVAL to help define
the end value of the for loop.
c. For each number in the loop:
 If the number is divisible by 2, print the word foo
 If the number is divisible by 3, print the word bar
 If the number is divisible by 5, print the word baz
 If the number is divisible by more than one of these, print the combination on the
same line.
 If the number is not divisible by 2,3 or 5, do not print a string
 Print the output of each number in the loop on a single line asn: <string>
For example:
 15 (3 & 5) would print15: barbaz
 6 (2 & 3) would print6: foobar
 30 (2 & 3 & 5) would print30: foobarbaz  7 would print7:
d. After part ‘c’ is completed, print a separator line.
e. Repeat step ‘c’ using a while loop from 1 to 30 (using the same MAXVAL constant to define
the end of the range).
'''

# a.
MAXVAL = 30
'''Declare a constant variable and assign a value.'''

# b. & c.
for i in range(1, MAXVAL + 1):
    if i % 2 == 0 and i % 3 != 0 and i % 5 != 0: 
        print(str(i) + ': ' + 'foo')
    elif i % 2 != 0 and i % 3 == 0 and i % 5 != 0:
        print(str(i) + ': ' + 'bar')
    elif i % 2 != 0 and i % 3 != 0 and i % 5 == 0:
        print(str(i) + ': ' + 'baz')
    elif i % 2 == 0 and i % 3 == 0 and i % 5 != 0:
        print(str(i) + ': ' + 'foobar')
    elif i % 2 == 0 and i % 3 != 0 and i % 5 == 0:
        print(str(i) + ': ' + 'foobaz')
    elif i % 2 != 0 and i % 3 == 0 and i % 5 == 0:
        print(str(i) + ': ' + 'barbaz')
    elif i % 2 == 0 and i % 3 == 0 and i % 5 == 0:
        print(str(i) + ': ' + 'foobarbaz')
    else:
        print(str(i) + ': ')
'''Use for loop to loop through 1 to 30.'''
    

# d.
print()
'''Print a separator line. Can use print() as its default function is 
to print a separator line.'''

# e.
i = 0
while i < MAXVAL:
    i += 1
    if i % 2 == 0 and i % 3 != 0 and i % 5 != 0: 
        print(str(i) + ': ' + 'foo')
    elif i % 2 != 0 and i % 3 == 0 and i % 5 != 0:
        print(str(i) + ': ' + 'bar')
    elif i % 2 != 0 and i % 3 != 0 and i % 5 == 0:
        print(str(i) + ': ' + 'baz')
    elif i % 2 == 0 and i % 3 == 0 and i % 5 != 0:
        print(str(i) + ': ' + 'foobar')
    elif i % 2 == 0 and i % 3 != 0 and i % 5 == 0:
        print(str(i) + ': ' + 'foobaz')
    elif i % 2 != 0 and i % 3 == 0 and i % 5 == 0:
        print(str(i) + ': ' + 'barbaz')
    elif i % 2 == 0 and i % 3 == 0 and i % 5 == 0:
        print(str(i) + ': ' + 'foobarbaz')
    else:
        print(str(i) + ': ')
'''Use while loop to loop through 1 to 30.'''