from dice import Dice

class DiceLt(Dice):

    def __init__(self=6):
        super().__init__(sides)
        self.light = 'black'

    def lightOn(self, color):
        self.light = color

    def lightOff(self):
        self.light = 'black'

    def display(self):
        return self.light

    def __str__(self):
        return str(self.value)

    def __repr__(self): # will be used as backup if no __str__
        return str(self.sides)+'sides; ' + str(self.value)+' value'
        

d1 = DiceLt()

isinstance(d1, DiceLt)
# True 
isinstance(d1, Dice)
# True 

# Constructor works differently as in Java
# arguments have to match parameter lists in init methods 
d2 = Dice(d1)
d2.roll()
# error
del d2

d1.__dict__

d1.__class__

d1.__class__.__dict__

d1.newattr = 9
# introducing a new name

d1.__class__.__base__.__dict__

d1.roll()
d1.getValue()
d1.lightOn('red')
d1.display()
# on

d2 = DiceLt()
d2.roll()
d2.getValue()
d2.display()
# Error: DiceLt does not have light
# until defining its own __init__

d1.__class__.__dict__
# found then stop

# need to call init method from the base class
# use super

issubclass(DiceLt, Dice)
# True 

dir(d1)

d1.__class__.__base__
# dice.Dice

d1.__class__.__base__.__base__
# object

__call__ # get a callable ability


