from Sentence import Sentence
s = Sentence('Celtics will win')
print(s.get_all_words())
print(s.get_word(1))
s.set_word(1, 'willnot')
print(s.scramble())
print(s.__repr__())