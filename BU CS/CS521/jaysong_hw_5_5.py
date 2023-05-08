'''
Homework assignment: 5.5
Create a function to calculate factorial using recursion.
'''
input_str = input('Please enter a positive integer: ')
while True:
    try:
        input_int = int(input_str)
        if input_int < 0:
            print('Please enter a valid input.')
            input_str = input('Please enter a positive integer: ')
            continue
        break
    except:
        print('Please enter a valid input.')
        input_str = input('Please enter a positive integer: ')    

        
def factorial(input_int):
    '''calculate factorial with recursion'''
    if input_int == 0 or input_int == 1:
        return 1
    return input_int * factorial(input_int - 1)

def factorial2(input_int):
    '''calculate the factorial without recursion'''
    res = 1
    for i in range(1, input_int + 1):
        res *= i
    return res

print(f'Calculate the factorial with recursion: {factorial(input_int):,}')
print(f'Calculate the factorial without recursion: {factorial2(input_int):,}')