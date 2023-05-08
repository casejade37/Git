# Syntax errors and logical errors
# runtime error: terminate abnormally 
# use try block to handle error 
# else can be paired with try as well
try:
    pass
except OSError as err:
    pass
except:
    raise
else:
    pass
finally:
    pass

# assert
def test(x):
    # assert square(x) == x ** 2
    if __debug__:
        if not expression: raise AssertionError

# function define order doesn't matter
# function call order matters 

# parameter: formal parameter
# argument: actual parameter

# keyword argument: specify which parameter to pass (keyword match)
# = makes an argument optional
# required must be before optional

# passing *args as iterable, packing/unpakcing tuple
def concat(*args, sep=','):
    return sep.join(args)

concat('North', 'East', 'South', 'West', sep='/')

# ** indicate kargs needs to be packed/unpacked into a dict 
def purchase(customer, **kargs):
    print('Thank you', customer)
    for k, v in kargs.items():
        print(k, v, sep=':')
# don't have to pass a dict into the func

# python is neither. Python is binding arg object to parameter names
def foo(param1, param2):
    # pass by value
    # function receives a copy of object
    param1 = 5.24
    # pass by reference
    # function receives object itself
    param2.append('Watertown')
    pass

num1 = 3.14
lst2 = ['Boston', 'Cambridge']
foo(num1, lst2)

# wrongly print out 1000
def addInterest(balance, rate):
    newBalance = balance * (1 + rate)
    balance = newBalance

def test():
    amount = 1000
    rate = 0.05
    addInterest(amount, rate)
    print(amount)

test()

# fix to print out 1050
def addInterest(balance, rate):
    newBalance = balance * (1 + rate)
    return newBalance

def test():
    amount = 1000
    rate = 0.05
    amount = addInterest(amount, rate)
    print(amount)

test()

# list is mutable, amounts refer to the same object, but updated
def addInterest(balances, rate):
    for i in range(len(balances)):
        balances[i] = balances[i] * (1 + rate)

def test():
    amounts = [1000, 2200, 800, 360]
    rate = 0.05
    addInterest(amounts, rate)
    print(amounts)

test()

# list comprehension creates a new object, returns wrong results
def addInterest(balances, rate):
    balances = [b * (1 + rate) for b in balances]

def test():
    amounts = [1000, 2200, 800, 360]
    rate = 0.05
    addInterest(amounts, rate)
    print(amounts)

test()


# default value starts with empty list, but updated later
def add2list(elem, lst = []):
    if elem not in lst:
        lst.append(elem)

    return lst

list1 = add2list(30, [10, 20])
print('list1: ', list1)

list2 = add2list(51)
print('list2: ', list2)

list3 = add2list(61)
print('list3: ', list3)

# function is an object, so we don't need a name for function
p = print
p(1, 2, 3)
p is print # True

# same as using lambda 
def inc(n):
    return n + 1

def make_incrementor(n):
    return inc

ret = make_incrementor(0)

# using lambda
def make_incrementor(n):
    return lambda x: x + n

ret = make_incrementor(41)

# lambda used in a function (pass function as args)
l = [('a', 8), ('x', 5), ('z', 3)]
sorted(l, key=lambda x: x[1])

# .py file is a module, in global name space
# calling stack: stacking stickers on the white board
# name space is created when the function is called, destroyed when the function is returned
# heap: all objects are in heap (part of memory)

# recursion: Tower of Hanoi
def toh(n, origin, target, interim):
    if n < 1:
        raise Exception('invalid input')

    if n == 1:
        print('Move Disc', n, 'from Pole', origin, 'to Pole', target)
        return

    toh(n-1, origin, interim, target)
    print('Move Disc', n, 'from Pole', origin, 'to Pole', target)
    toh(n-1, interim, target, origin)

    return

# interative
def isum(n): 
    result = 0
    for i in range(n+1):
        result += i
    return result

# recursive
def rsum(n):
    if n == 0:
        return 0
    return n + rsum(n-1)

# recursion increases call stack along the way
# loop keeps updating, less overhead

# start from the previou one instead of the first one
prev, curr = 0, 1
def next_fib():
    global prev, curr
    prev, curr = curr, prev + curr
    return prev

# generator: special object, an iterator.
def fib():
    prev, curr = 0, 1
    while True:
        yield curr # no return value, return a generator
        prev, curr = curr, prev + curr

f = fib()
# use next() to return value
next(f)

# no tuple comprehension, just generator 
( x ** 2 for x in range(10) )