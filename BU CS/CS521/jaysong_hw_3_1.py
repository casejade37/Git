'''
Homework assignment: 3.1
'''
# a. loops through the integers 2 - 130 (inclusive), and create necessary variables/lists.
beg_value, end_value = 2, 130

count_odd, count_even, count_sq, count_cube= 0, 0, 0, 0
odd_list, even_list, sq_list, cube_list = [], [], [], []

for i in range(beg_value, end_value + 1):

# b. count
# odd numbers
    if i % 2 != 0:
        count_odd += 1
        odd_list.append(i)
        
# even numbers

    if i % 2 == 0:
        count_even += 1
        even_list.append(i)
# squares of integers

    if i**2 <= end_value:
        count_sq += 1
        sq_list.append(i**2)
# cubes of integers

    if i**3 <= end_value:
        count_cube += 1 
        cube_list.append(i**3)         

# c. print outputs
print('Checking numbers from {} to {}'.format(beg_value, end_value))
print('Odd ({}): {}...{}'.format(count_odd, odd_list[0], odd_list[-1]))
print('Odd ({}): {}...{}'.format(count_even, even_list[0], even_list[-1]))
print('Square ({}): {}'.format(count_sq, sq_list))
print('Cube ({}): {}'.format(count_cube, cube_list))

