import java.util.Arrays;

public abstract class Dog {

    abstract void method3();

}


 class BottomClass extends Dog{

    void method3() {

        System.out.println("method3 in Bottom Class");

    }






    public static void main(String [] args)

    {

        String[] sa = {"data", "structures", "and", "algorithms"};
        String[] sb = sa;
        Arrays.sort(sb);
        System.out.println(sa);
        String[] sc = {"data", "structures", "and", "algorithms"};
        String[] sd = sc.clone();
        Arrays.sort(sd); //sort strings in the array in alphabetical order
        System.out.println(sc);

    }

}