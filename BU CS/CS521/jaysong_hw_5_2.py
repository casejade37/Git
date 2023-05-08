'''
Homework assignment: 5.2
Create 3 functions with docstring:
1. lettter_counts()
2. most_common_letter()
3. string_count_histogram()
and then print out the outputs.
'''
import string
def letter_counts(str):
    '''take a string as argument and return a dictionary of letters as keys and frequency counts as values.'''
    count_dict = {}
    str = str.strip()
    for char in str.strip(string.punctuation).upper():
        if char != ' ': 
            count_dict[char] = count_dict.get(char, 0) + 1
    return count_dict

def most_common_letter(str):
    '''take a string as argument and return a list of the most common letters.
    Will call letter_counts() in this function.'''
    count_dict = letter_counts(str)
    max_value = max(count_dict.values())
    output_list = []
    for k, v in count_dict.items():
        if v == max_value:
            output_list.append(k)
    return output_list

def string_count_histogram(str):
    '''take a string as argument and return a list of the unique letters,
    with each letter being the repeated number of times it appears in the string.
    print one element per line.'''
    count_dict = letter_counts(str)
    output_dict = dict(sorted(count_dict.items()))
    for k, v in output_dict.items():
        print(k*v)

if __name__ == '__main__':
    MY_STR = 'WWWAS IIIT A RAT I SAW'
    print('The string being analyzed is: ', MY_STR)
    # print 1.
    my_dict = dict(sorted(letter_counts(MY_STR).items()))
    print('1. Letter counts: ', end='')
    print_str = ''
    for k, v in my_dict.items():
        print_str = print_str + "'" + k + "'" + ': ' + str(v) + ', '
    print(print_str.rstrip(', '))
    # print 2.
    output_list = most_common_letter(MY_STR)
    output_list.sort()
    if len(output_list) == 1:
        print("2. Most frequent letter '{}' appears {} times.".format(output_list[0], max(my_dict.values())))
    else:
        print("2. Most frequent letters: {} each appear {} times.".format(str(output_list)[1:-1], max(my_dict.values())))
    # print 3.
    print('3. Histogram:')
    string_count_histogram(MY_STR)