'''
Homework assignment: 4.3
'''
import sys
# a. create two constant lists
FIRST_NAME = ['Jane', 'John']
LAST_NAME = ['Doe', 'Deer', 'Black']

# b. validate
if len(FIRST_NAME) > len(LAST_NAME): 
    sys.exit("Error: first name list is larger than last name list")

# c. create dict
# create a new variable to append None.
first_name_output = FIRST_NAME.copy()
while len(first_name_output) < len(LAST_NAME):
    first_name_output.append(None)
name_dict = dict(zip(LAST_NAME, first_name_output))


# d. Print output
print('First Names: ', FIRST_NAME)
print('Last Names: ', LAST_NAME)
print('Name Dictionary: ', name_dict)