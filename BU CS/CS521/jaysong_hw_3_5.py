'''
Homework assignment: 3.5
'''
# a. open and read the file line by line
f = open('cs521_3_5_input.txt', 'r')
reader = f.read().split('\n')

# b & c. parse the data into a tuple and store each tuple into a list
sheet_list = []
for row in reader:
    sheet_list.append(tuple(row.split(',')))

# d. print the description and the list of tuples. Then close files.
    
print('Description: Student Records are shown below, with each tuple showing Name, Student ID and GPA.')
print('Student Records: ', sheet_list)

f.close()