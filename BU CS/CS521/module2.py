# no need to worry about type, just use int, there is no limit
# just depend the memory you have
# 3.3000000000000003 use double in the backend although float
# in Python
# 100000.00000133288 is not 10000000
# round to even: 
# 0 0
# 1 2
# 2 2
# 3 4
# 4 4
# 5 6
# 6 6
# 7 8
# 8 8
# 9 10
# 10 10
# 11 12
# 12 12
# 13 14
# 14 14
# 15 16
# 16 16
# 17 18
# 18 18
# 19 20
# Decimal can guarantee the precision
# (2+1j) instead of i to represent complex number in Python
# pseudo random number in Python
import random

random.seed(7)

for i in range(10):
    print(random.randint(1, 100))

# None type: single value None, represents the absence of a value
# like Null in other languages
# can use it to test whether a name is associated with a value
# unlike 'not defined'
# good practice: testval is None

# in Python only str, unlike other languages that have character 
# and str

# simultaneous assignment: x, y = y, x
# similar to tmp = y, y = x, x = tmp in other languages

# no x++ in Python


# Python: strong type language
# mutable: value of the object can be changed, id remains same

# greet += ' World', create a new str object as str is immutable

# mutable: list, set, dict
# immutable: str, tuple, int, float

# set: collection object -> mutable, element within -> immutable
# e.g. can't have a set of list

# dict: colletion object -> mutable, element within -> key : immutable

# hashing
hash()
# input: value, output: number

# hash collision: compare object value (low probability)
# hash(0) same as hash('')

# immutable objects are hashable
# hash value will never change for same input value

# purpose of hashing: use number to quickly compare to find the object

# identity (is) v.s. equality (==)

# Boundary for number changes with time, Python provides an optimization

# shallow copy: affect when going beyond the top level objects.
_0 = x.copy()
_1 = list(x)
_2 = [i for i in x]
_3 = x[:]
_4 = [] + x

# shallow copy is efficient for immutable object

# deep copy: copy every level of elements; won't affect whatsoever

# range: Python 3 return a range object