'''
Homework assignment: 5.4
Prompt for a file, then read the file, convert the words to a list, 
and return another list containing only words that occurred twice using a function.
'''
import string

input_str = input('Enter a text file: ')
while True:
    try:
        f_file = open(input_str, 'r')
        break
    except FileNotFoundError:
        print('Please provide a valid file.')
        input_str = input('Enter a text file: ')

word_list = []
f = f_file.read()
for char in f:
    if char in string.punctuation:
        f = f.replace(char, ' ')
for word in f.lower().split():
    word_list.append(word)

def list_to_twice_words(my_list):
    '''use a dict to check if the value is 2, 
    then append all keys to a result list and return that list'''
    my_dict = dict()
    for i in range(len(my_list)):
        my_dict[my_list[i]] = my_dict.get(my_list[i], 0) + 1
    
    res = []
    for k, v in my_dict.items():
        if v == 2:
            res.append(k)
    return res

print('This result list contains only words that occurred exactly twice in the file: ', list_to_twice_words(word_list))
f_file.close()