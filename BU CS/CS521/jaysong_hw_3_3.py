'''
Homework assignment: 3.3
'''
# a & b. prompt users to enter the number and then loop and re-prompt
while True:
    input_str = input('Please enter a 3-digit integer: ')
    if input_str[0] == input_str[1] or input_str[1] == input_str[2] or input_str[2] == input_str[0]:
        print('Error: Your number contains duplication.')
        continue
    elif '.' in input_str:
        print('Error: This is not an integer. Please re-enter.')
        continue
    elif len(input_str) != 3:
        print('Error: You did not enter a 3-digit number.')
        continue
    elif input_str[2] < input_str[1] or input_str[1] < input_str[0]:
    # elif ''.join(sorted(int(input)) != input):
        print('Error: The digits are not in ascending order.')
        continue
# c. after checking all possible error, inform user of acceptance and exit
    else: 
        print('Number Accepted!')
        break