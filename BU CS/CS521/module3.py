# single quote is the same as double quote
# Unicode is the standard coding, code representing characters.
# UTF-8 varies from 1 byte to 4 bytes
# ord() <-> chr()

# Escape Sequence

# slice of string is a new string

# if starting > ending index of slicing, will get empty string

# find won't return an error, just return -1 if not found

# split, join

# format(x, '9.5f'): 9 minimum length, 5 significance, fixed decimal points.

# formatted string: s = f'Dear {name}

score = 5
# using expression after '=', entire line is a statement
grade = 'Pass' if score >= 3 else 'Fail'
grade = 'Pass' if score >= 3 else ('Barely' if score >= 2 else 'Fail')

import os
homepath = os.environ['HOME']

# os.path.join

# context manager
with open('test.txt') as f: 
    for line in f: 
        print(line[:-1])