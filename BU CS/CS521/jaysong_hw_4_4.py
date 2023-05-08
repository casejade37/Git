'''
Homework assignment: 4.4
'''
MY_DICT = {'a': 15, 'c': 18, 'b': 20}

# a. print keys as a list
output_list = [] 
for i in MY_DICT:
    output_list.append(i)
print('Keys: ', output_list)

# b. print values, not as a list
print('Values: ', end='')
str_b = str()
for i in MY_DICT:
    str_b = str_b + str(MY_DICT[i]) + ', '
print(str_b.rstrip(', '))

# c. print key-value pairs, not as a dictionary
print('Key value pairs: ', end='')
str_c = str()
for key, val in MY_DICT.items():
    str_c = str_c + str(key) + ': ' + str(val) + ', '
print(str_c.rstrip(', '))

# d. sort by key and print a list of tuples
print('Key value pairs ordered by key: ', sorted(MY_DICT.items()))

# e. sort by value and print formatted pairs
print('Key value pairs ordered by value: ', end='')
value_key_list = []
for key, val in MY_DICT.items():
    value_key_list.append((val, key))
value_key_list.sort()
str_e = str()
for i in range(len(value_key_list)):
    str_e = str_e + str(value_key_list[i][1]) + ': ' + str(value_key_list[i][0]) + ', '
print(str_e.rstrip(', '))