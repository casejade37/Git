'''
Homework assignment: 5.3
Write a program without a function to catch all granular errors and return the calculated results.
'''
while True:
    print('Please enter four numbers, separated by commas: ', end='')
    try:
        x = input().split(',')
        res = (float(x[0]) * float(x[1]) + float(x[2])) / float(x[3])
        print('(a * b + c) / d = ', res)
        break
    except ValueError:
        print('Value error, please make sure to enter numbers only')
        continue
    except ZeroDivisionError:
        print('Divide by 0 error, please do not enter 0 for the last number')
        continue
    except IndexError:
        print('Index error, please make sure to enter four numbers exactly.')
        continue
