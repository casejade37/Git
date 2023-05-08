'''
2.2: Write a program that does the following:
a. Prompt the user to enter a string or a number.
b. Print that input 3 times, as (1) a string, (2) an integer, and (3) a floating‐point value.
o Based on the user input, this program will crash sometimes!
c. What data types can be input that will print without generating any errors?
o Answer this question at the end of your code by using a docscring (triple quote) comment and explain why for your answer makes sense for all three data types listed in part b.
'''
# a.
user_input = input('Please enter your input here: ')
'''Get user's input'''

# b.
print(user_input)
print(int(float(user_input)))
print(float(user_input))
'''Print the input:
print directly for a string by default;
convert user_input from string to float first and then int to avoid 
errors to print an integer;
convert user_input from string to float to print a floating number.'''

# c. 
'''Only int and float data types can be input without generating errors.
If entering a string: errors will be generated when trying to convert the
string input to int or float input.
If entering an int: no errors will be generated as int can be printed as str,
int, or float.
If entering a float: no errors will be generated after my accommodation above, 
on the second line, as if we convert the input string to int directly, floating number 
string will crash the program. But if we convert the input string to float first and then to
int, this program will run fine. For example: input string '3.3' can't be converted 
to an integer, but can be converted to a float. '''