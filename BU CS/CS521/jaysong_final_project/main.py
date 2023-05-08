'''
Final Project: Buy versus Rent

This is the main program to do unit tests. 
All user defined functions and class are in BuyVsRent module and will be imported here.
'''
from BuyVsRent import BuyVsRent

if __name__ == '__main__':
    '''
    Available parameters for buying: {'Mortgage', 'Tax', 'HOA', 'Fee'}.
    Available parameters for renting: {'Rent'}.
    '''

    '''Unit test 1: default case'''
    home_1 = BuyVsRent() 
    # evaluating results
    assert isinstance(home_1.buying(), dict) and isinstance(home_1.renting(), dict)
    # default things to consider
    print(home_1.buying())
    print(home_1.renting())
    print(repr(home_1))
    print(home_1)

    '''Unit test 2: customized case'''
    home_2 = BuyVsRent(1200000, 120000, 4, 500, 0.5, 7000) 
    # evaluating results
    assert isinstance(home_2.buying(), dict) and isinstance(home_2.renting(), dict)
    # customized things to consider
    print(home_2.buying({'Tax', 'HOA'}))
    print(home_2.renting({}))
    print(repr(home_2))
    print(home_2)
    
    # test the magic class method
    print('Magic class method: ', home_1 > home_2)
