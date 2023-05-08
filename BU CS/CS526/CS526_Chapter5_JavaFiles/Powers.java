package recursion;
//Example to explore timing functions in Java and to explore the speedup when using the more efficient
//version of the power function (Chapter 5)
public class Powers {

    public static void main(String [] args)
    {
        long start = System.nanoTime();
        double res1 = powerSlow(3,21);
        long out = System.nanoTime()-start;


        start = System.nanoTime();
        double res2 = powerFast(3,21);
        long out2 = System.nanoTime()-start;

        System.out.println("Result Slow: " + res1 + ", Result Fast: " + res2);

        System.out.println("Slow: " + out + ", Fast: " + out2);

    }

    public static double powerSlow(int x, int n)
    {
        if(n==0)
        {
            return 1;
        }else
        {
            return x*powerSlow(x,n-1);
        }

    }

    public static double powerFast(int x,int n)
    {
        if(n==0)
            return 1;
        else
        {
            double result = powerFast(x,n/2);
            double temp = result*result;
            if(n%2==1)
            {
                return x*temp;
            }else
            {
                return temp;
            }
        }

    }
}
