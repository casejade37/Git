'''
Homework assignment: 6
Create a class called Sentence that evaluates and manipulates an English sentence.
'''
import string
import random

class Sentence:
    '''create a class Sentence to evaluate and manipulate an English sentence.'''

    def __init__(self, content=' '):
        '''constructor method, the sentence is a private attribute in the class'''
        self.__content = content
        for char in self.__content:
            if char in string.punctuation:
                self.__content = self.__content.replace(char, ' ')
        self.__list = self.__content.split(' ')

    def get_all_words(self):
        '''method to get all the words in a sentence'''
        return self.__list

    def get_word(self, index):
        '''method to get one desired word from the sentence'''
        if index in range(len(self.__list)):
            return self.__list[index]
        return ' '

    def set_word(self, index, new_word):
        '''method to change the word at a given index location in sentence to a new word'''
        self.__list[index] = new_word

    def scramble(self):
        '''method to scramble the words in a sentence'''
        res_list = self.__list.copy()
        random.shuffle(res_list)
        return res_list

    def __repr__(self): 
        '''output method'''
        return ' '.join(self.__list).rstrip(' ') + '.'

if __name__ == '__main__':
    s = Sentence(content='Will Celtics win championship this year?')
    # validate set_word() method
    index = 1
    new_word = 'Nets'
    assert isinstance(index, int) and index in range(len(s._Sentence__list))
    assert isinstance(new_word, str) 
    s.set_word(index, new_word)

    '''meesage that the sentence worked correctly'''
    print('Sentence unit test successful')
    
    '''the original version of sentence'''
    # Print (in string format) the tranformed (without punctuation)
    # initial sentence provided at the time of object initiation
    print(s._Sentence__content)
    
    '''the scrambled version of sentence'''
    # Scamble the modified list (taking set_word into account) and print ( in string format)
    print(' '.join(s.scramble()))

    '''the final version of sentence'''
    # Print the sentance/list (post Set_Word ) in string format, 
    # as scramble should not change the sentence attribute in your sentence instance
    print(s.__repr__())