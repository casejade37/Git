'''
Homework assignment: 4.5
'''
# a.  create the constant dictionary
CONSTANT_DICT = {
    '1': 'One', '2': 'Two', '3': 'Three', '4': 'Four', '5': 'Five',
    '6': 'Six', '7': 'Seven', '8': 'Eight', '9': 'Nine', '0': 'Zero',
    '-': 'Negative', '.': 'Point'
}

# b. validate
while True:
    input_str = input()
    print('Enter a number: ', input_str)
    if input_str.isnumeric() or '-' in input_str or '.' in input_str:
        break
    elif ',' in input_str:
        print('Please try again without entering commas.')
    else:
        print('"{}" is not a valid number. Please try again'.format(input_str))

# c. convert
print('As Text: ', end='')
output_str = str()
for char in input_str:
    output_str = output_str + CONSTANT_DICT[char] + ' '
print(output_str.rstrip(' '))