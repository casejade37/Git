'''
Homework assignment: 4.1
'''

# a. create a constant list from 55 to 5 including 5.
const_list = [i for i in range(55, 0, -10)]

# b. create a result list to append desired results.
res_list = []
for i in range(len(const_list)):
    if i == 0: 
        res_list.append(const_list[i] + const_list[i+1])
    elif i == len(const_list) - 1:
        res_list.append(const_list[i] + const_list[i-1])
    else:
        res_list.append(const_list[i-1] + const_list[i] + const_list[i+1])

# c. print outputs.
print('Input List: ', const_list)
print('Result List: ', res_list)