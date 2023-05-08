'''
2.3: Write a program that does the following:
a. Prompt the user to enter a number
No validation required for this problem.
b. Take that number (n) and compute the value of n cubed, divided by n
c. Print the formula and results, replacing the ‘n’ variables with the user input.
o Limitresultto2decimalplaces
'''

# a.
new_input = input('Please enter a number: ')
'''Get user input in string format '''

# b.
n = float(new_input)
res = n ** 3 / n
'''Convert the input to float and assign it to a variable n.
Then compute the value accordingly.'''

# c.
print(new_input + '**3/' + new_input + '=' + str(round(res, 2)))
'''Print formula and results.
Need to make sure all elements inside the print function are strings to perform
concatenation. Also ensure the result is limited to 2 decimal places.
For example, for input of 12.34, result will be printed as 152.28.'''