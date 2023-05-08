'''
Homework assignment: 3.2
'''
import string
# a. create a docstring constant.
my_str = ''' Don't grumble. Always look on the bright side of life. Always look on the light side of life.'''

# b. convert it to a list.
my_list = my_str.split('.')

# c. loop operations.
count_upper_1, count_lower_1, count_digit_1, count_punc_1 = 0, 0, 0, 0
for char in my_list[0]:
    if char in string.ascii_uppercase:
        count_upper_1 += 1
    if char in string.ascii_lowercase:
        count_lower_1 += 1
    if char in string.digits:
        count_digit_1 += 1
    if char in string.punctuation:
        count_punc_1 += 1

count_upper_2, count_lower_2, count_digit_2, count_punc_2 = 0, 0, 0, 0
for char in my_list[1]:
    if char in string.ascii_uppercase:
        count_upper_2 += 1
    if char in string.ascii_lowercase:
        count_lower_2 += 1
    if char in string.digits:
        count_digit_2 += 1
    if char in string.punctuation:
        count_punc_2 += 1

count_upper_3, count_lower_3, count_digit_3, count_punc_3 = 0, 0, 0, 0
for char in my_list[2]:
    if char in string.ascii_uppercase:
        count_upper_3 += 1
    if char in string.ascii_lowercase:
        count_lower_3 += 1
    if char in string.digits:
        count_digit_3 += 1
    if char in string.punctuation:
        count_punc_3 += 1

# d. Output the results
print('# # Upper # Lower # Digits # Punct.')
print('- ------- -------- -------- --------')
print('1 {:^9d} {:^7d} {:^6d} {:^9d}'.format(count_upper_1, count_lower_1, count_digit_1, count_punc_1))
print('2 {:^9d} {:^7d} {:^6d} {:^9d}'.format(count_upper_2, count_lower_2, count_digit_2, count_punc_2))
print('3 {:^9d} {:^7d} {:^6d} {:^9d}'.format(count_upper_3, count_lower_3, count_digit_3, count_punc_3))