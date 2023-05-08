'''
2.1: Write a Python program does all the following steps. Make sure you label all your print output to explain what you are printing. This is required for all problems in this course.
a. Prompts the user to enter a whole number from 1 to 7.
No validation required for this problem.
b. In one line of code/calculation, performs the following operations on the user supplied number in this exact order:
o Multiply by 2
o Add10
o Divide by 2
o Subtract the user supplied number
c. Print the output of this calculation in part ‘b’ as an integer (no decimal places).
d. Now take the same user supplied number from part ‘a’ and convert it to a three‐digit
number with incrementing digits. Assign this number to a variable as an integer. o For example, if the user entered '3', the three‐digit version is 345.
e. Add the three digits together and print the results.
o For example, if the user entered 3, you would calculate 3+4+5 = 12.
f. Divide the three‐digit version by the resulting sum of its digits and print the results as a float. o For example, if the user entered 3, you would calculate 345 / 12.
g. Reprint the output of part ‘f’ as a truncated integer (no decimal places).
'''

# a.
input_str = input('Please enter a whole number from 1 to 7: ')
input_int = int(input_str)
'''Get user input in string format and then convert it to integer format'''


# b.
res_b = (input_int * 2 + 10) / 2 - input_int
'''Then perform the required operations on the integer input. '''

# c. 
print(int(res_b)) 
'''print the result from b in integer format. '''


# d. 
new_var = input_int * 100 + (input_int + 1) * 10 + input_int + 2
'''input_int * 100 puts the input_int to the first (hundred) digit; 
(input_int + 1) * 10 puts (input_int + 1) to the second (ten) digit;
input_int + 2 refers to the third digit. 
Add them up to get the three-digit integer, and assign it to a new variable.'''

# e.
res_e = new_var // 100 + new_var % 100 // 10 + new_var % 10
print(res_e)
'''print the result from e: 
use new_var // 100 to get the first digit;
new_var % 100 // 10 to get the second digit;
new_var % 10 to get the third digit. Then sum those up.'''


# f.
print(float(new_var / res_e))
'''Perform division and convert it to float and then print.'''

# g.
print(int(new_var / res_e))
'''Perform division and convert it to int to get rid of decimal places
and then print.'''