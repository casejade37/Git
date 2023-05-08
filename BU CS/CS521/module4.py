# sorted return a list (create a new list)
# sort return a None

# list comprehension 
square = [x ** 2 for x in range(4)]

# tuple 
s = ('Boston', )
s = tuple(('Boston',))
# can't use tuple('Boston'), will expand the str
# ('B', 'o', 's', 't', 'o', 'n')
# pack: recognize comma separated as tuple
course = 'MET', 'CS', 521
# unpack: recognize contents inside tuple
brand = ('Boston', 'Red Sox')
city, team = brand

# dictionary
# when iterate thru only the dict, return keys
# one way to get value:
pb = {'Charlie': 2901, 'Dave': 1380, 'Ellen': 3567}
for p in pb: 
    print(pb[p])

from collections import deque

# csv 
import csv
m_list = []
with open('movie.csv') as m_file:

    m_reader = csv.reader(m_file)
    next(m_reader)

    for row in m_reader:
        m_list.append(row)

d_list = [ (m[3], m[0]) for m in m_list if m[1] == 'Drama' ]
d_list.sort()

with open('drama.csv', 'w', newline='') as d_file:
    m_writer = csv.writer(d_file, delimiter='\t')
    
    for d in d_list:
        m_writer.writerow(d)

    # without csv module
#     for line in m_file:
#         row = line.split(',')
#         print(row)

#         if row[1] == 'Drama':
#             m_list.append((row[3], row[0]))

# for m in m_list:
#     print(m[0], m[1])

with open('movie.csv') as m_file:

    m_reader = csv.DictReader(m_file)

    for row in m_reader:
        m_list.append((row['Release'], row['Title']))

for m in m_list: 
    print(m)