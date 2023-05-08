'''
Homework assignment: 4.2
'''
import string
# a. assign a sentence of at least 15 characters
MY_STR = 'Will Celtics win a championship this year?'

# b. analysis
count_dict = {}
MY_STR = MY_STR.strip()
for char in MY_STR.strip(string.punctuation).upper():
    if char != ' ': 
        count_dict[char] = count_dict.get(char, 0) + 1

# c. output prints

# include " " for the string for output purposes
output_str = '"' + MY_STR + '"'
# create a sorted dict for output purposes
output_dict = dict(sorted(count_dict.items()))
# get necessary outputs for second print
max_value = max(count_dict.values())
output_list = []
for k, v in count_dict.items():
    if v == max_value:
        output_list.append(k)

print('The string being analyzed is: ', output_str)
print('1. Dictionary of letter counts: ', output_dict)
# handle the cases of one most frequent letter vs. multiple letters.
if len(output_list) == 1:
    print('2. Most frequent letter "{}" appears {} times.'.format(output_list[0], max_value))
else:
    print('2. Most frequent letters {} appear {} times.'.format(output_list, max_value))

