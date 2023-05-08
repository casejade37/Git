'''
Homework assignment: 3.4
'''
import sys
# a. print error message if the file is missing, then end the program
try:
    input_file = open('cs521_3_4_input.txt', 'r')
except FileNotFoundError:
    print('This file is missing. Ending the program now.')
    sys.exit()

# b. validate 
num_allowed = 20
for word in input_file:
    if len(word.split()) != num_allowed:
        print('This file has a different number of words from 20, ending the program now.')
        sys.exit()

# c & d. break up the sentence and write the lines to the output file
num_per_line = 5
input_file = open('cs521_3_4_input.txt', 'r')
output_file = open('cs521_3_4_output.txt', 'w')
line_list = input_file.read().split()
for i in range(len(line_list)):
    output_file.write(line_list[i] + ' ')
    if (i + 1) % num_per_line == 0 and i != len(line_list) - 1:
        output_file.write('\n')

# for index, word in enumerate(lines):
#   out_file.write(word + ('\n' if index % words_per_line == words_per_line - 1 else ' '))

# e. print success message and then close files.
print('Success! Output written to: cs521_3_4_output.txt')
input_file.close()
output_file.close()
