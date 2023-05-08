'''
Final Project: Buy versus Rent

This will compare buy and rent a home for the perspective of investment, by comparing profit/loss after 30 years.

Sunk costs for home include property tax, loan interest, HOA fees (for condo), average maintenance 
costs (for house), fees related to selling home such as lawyer, agent commissions, and fees related
to buying home such as filing, title paperwork). These costs will be used to be compared with rent.

Down payment will be assumed to be initial capital: 
will be invested in S&P 500 in renting situation, as an opportunitiy cost for buying a home;
will be used as down payment in buying situation.

This program will ignore same costs between buy and rent, such as home owner insurance, utility, etc.
'''

def home_growth_rate(file):
    '''Calculate 30-year average growth rate for homes in Massachusetts. Data from FRED: https://fred.stlouisfed.org/series/MASTHPI'''
    try:
        f = open(file, 'r')
    except:
        print('Please enter the correct file name')
    else:
        reader = f.read().split('\n')
        index = [reader[i].split(',') for i in range(len(reader))]
        return pow(float(index[-2][1]) / float(index[1][1]), 1/30)

def stock_growth_rate(file):
    '''Calculate 30-year average growth rate for S&P500. Data from: https://www.slickcharts.com/sp500/returns'''
    try:
        f = open(file, 'r')
    except:
        print('Please enter the correct file name')
    else:
        reader = f.read().split('\n')
        annual_return = [reader[i].split(',')[1] for i in range(len(reader))]
        res = 1
        for i in range(29, -1, -1):
            res *= (1 + float(annual_return[i]) / 100) 
        return pow(res, 1/30)


class BuyVsRent:
    '''The class with methods to calculate investment comparisons of buy vs rent'''  
    def __init__(self, home_price=1000000, down_payment=200000, interest_rate=5, hoa_maintenance=800, tax_rate=1, rent=5000):
        ''' 
        Enter the listed price ($), down payment ($), 30-year loan interest rate (%), monthly HOA or Maintenance costs ($), annual property tax rate of the county (%), monthly rent ($).
        Default values are provided to show an example.
        '''
        self.home_price = home_price
        self.down_payment = down_payment
        self.interest_rate = interest_rate
        self.hoa_maintenance = hoa_maintenance
        self.tax_rate = tax_rate
        self.rent = rent

    def __constant(self, SELLING_FEES=0.06, BUYING_FEES=0.01, INFLATION=0.02):
        '''Assumptions as private class attributes in a private class method to prevent from changing by users.'''
        self.__SELLING_FEES = SELLING_FEES # estimated at 6% on average for fees associated with selling a home
        self.__BUYING_FEES = BUYING_FEES # estimated at 1% on average for fees associated with buying a home
        self.__INFLATION = INFLATION # use average inflation rate for growth rate of HOA, property tax, and rent
        return {'SELLING_FEES': self.__SELLING_FEES, 'BUYING_FEES': self.__BUYING_FEES, 'INFLATION': self.__INFLATION}

    def buying(self, buy_to_consider={'Mortgage', 'HOA', 'Tax', 'Fee'}):
        '''
        Calculate sunk costs and final profits in buy situation, returns a dict.
        Default a set to check things to consider when buying a home.
        The user can choose to keep the default set, or manually remove some elements in the set to ignore certain factors when buying a home.
        '''
        self.buy_to_consider = buy_to_consider
        if 'Mortgage' in self.buy_to_consider:
            self.payment_30y = (self.home_price - self.down_payment) * ((self.interest_rate / 100 / 12) * pow(1 + (self.interest_rate / 100 / 12), 360) / (pow(1 + (self.interest_rate / 100 / 12), 360) - 1)) * 360
        else: 
            self.payment_30y = 0
        if 'HOA' in self.buy_to_consider:
            self.hoa_30y = sum([self.hoa_maintenance * pow((1 + self.__constant()['INFLATION'] / 12), i) for i in range(360)])
        else:
            self.hoa_30y = 0
        if 'Tax' in self.buy_to_consider:
            self.tax_30y = sum([self.home_price * (self.tax_rate / 100) * pow((1+ self.__constant()['INFLATION'] ), i) for i in range(30)])
        else:
            self.tax_30y = 0
        if 'Fee' in self.buy_to_consider:
            self.fee_30y = self.__constant()['BUYING_FEES'] * self.home_price + self.__constant()['SELLING_FEES'] * self.home_price * pow(home_growth_rate('MASTHPI.csv'), 30)
        else:
            self.fee_30y = 0
        self.gain_buy = self.home_price * pow(home_growth_rate('MASTHPI.csv'), 30) 
        self.sunk_buy = int(self.payment_30y - (self.home_price - self.down_payment) + self.hoa_30y + self.tax_30y + self.fee_30y)
        self.profit_buy = int(self.gain_buy) - self.sunk_buy
        output_str_tuple = ('Profits of buying', 'Sunk costs of buying')
        output_number_tuple = (self.profit_buy, self.sunk_buy)
        output_dict = dict(zip(output_str_tuple, output_number_tuple))
        return output_dict

    def renting(self, rent_to_consider={'Rent'}):
        '''
        Calculate sunk costs and final profits in buy situation, returns a dict.
        Default a set to check things to consider when renting a home.
        The user can choose to keep the default set, or manually remove some elements in the set to ignore certain factors when renting a home.
        '''
        self.rent_to_consider = rent_to_consider
        if 'Rent' in self.rent_to_consider:
            self.rent_30y = sum([self.rent * pow((1 + self.__constant()['INFLATION'] / 12), i) for i in range(360)])
        else:
            self.rent_30y = 0
        self.gain_rent = self.down_payment * pow(stock_growth_rate('S&P500.txt'), 30)
        self.sunk_rent = int(self.rent_30y)
        self.profit_rent = int(self.gain_rent) - self.sunk_rent
        output_str_tuple  = ('Profits of renting', 'Sunk costs of renting')
        output_number_tuple = (self.profit_rent, self.sunk_rent)
        output_dict = dict(zip(output_str_tuple, output_number_tuple))
        return output_dict

    def __gt__(self, other):
        '''
        Magic class method to comparing Profits of buying between two different homes.
        This happens when the user is determined to buy: have two homes on the list to buy but don't know which one to buy.
        '''
        if self.profit_buy > other.profit_buy:
            return True
        elif self.profit_buy < other.profit_buy:
            return False
        else:
            return "Can't compare this two homes, need to consider other factors."

    def __str__(self):
        '''Output readable recommendations.'''
        if self.buying(self.buy_to_consider)['Profits of buying'] > self.renting(self.rent_to_consider)['Profits of renting']:
            return 'Buying makes more sense financially.'
        elif self.renting(self.rent_to_consider)['Profits of renting'] > self.buying(self.buy_to_consider)['Profits of buying']:
            return 'Renting makes more sense financially.'
        else:
            return 'No difference between buying and renting.'

    def __repr__(self): 
        '''Output results.'''
        return f"Profits for buying a home: {self.buying(self.buy_to_consider)['Profits of buying']:,}; Sunk costs for buying a home: {self.buying(self.buy_to_consider)['Sunk costs of buying']:,};\n\
Profits for renting a home: {self.renting(self.rent_to_consider)['Profits of renting']:,}; Sunk costs for renting a home: {self.renting(self.rent_to_consider)['Sunk costs of renting']:,}."


