'''
2.4
Write a three‐line program (3 commands) that will
a. prompt for a number
b. convert the input to an integer
c. print the number 0 if the user input is even and the number 1 if the user input is odd
 Hint: One way to determine whether an integer is even or odd is to divide the number by two and check the remainder.
'''

# a.
input_str = input('Please enter a number: ')
'''Get user input in string format '''

# b.
input_int = int(input_str)
'''Convert the input to an integer'''

# c.
print(input_int % 2)
'''For even number, input_int % 2 will be 0;
for odd number, input_int % 2 will be 1.'''