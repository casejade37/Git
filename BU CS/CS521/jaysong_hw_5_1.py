'''
Homework assignment: 5.1
Create a function to count the number of vowels and consonants in a text file.
'''
input_str = input('Enter a text file: ')
while True:
    try:
        f = open(input_str, 'r')
        break
    except FileNotFoundError:
        print('Please provide a valid file')
        input_str = input('Enter a text file: ')
        

def vc_counter(file):
    '''count vowels and consonants.'''
    output_dict = {'vowels': 0, 'consonants': 0}
    # initiate two constant lists containing relevant elements
    VOWELS = ['A', 'E', 'I', 'O', 'U']
    CONSONANTS = ['B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
                    'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W',
                    'X', 'Y', 'Z']
    for char in file.read().upper():
        if char in VOWELS:
            output_dict['vowels'] += 1
        if char in CONSONANTS:
            output_dict['consonants'] += 1
    print('Total # of vowels in text file: ', output_dict['vowels'])
    print('Total # of consonants in text file: ', output_dict['consonants'])

vc_counter(f)
f.close()