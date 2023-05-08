package lectures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class lesson1 {


    public static void assignmentExample() {
        double x = 3.14;
        int a = (int)x;
        double y = a;
        char z = (char) x;
        System.out.printf("%s %s %s %s", x,a,y, z);
    }

    public static int absoluteValue() {
        return absoluteValue(5);
    }

    public static int absoluteValue(int number) {
        if(number < 0) {
            return -number;
        }
        else {
            return number;
        }
    }

    public static int absoluteValue(int number, int number2) {
        return absoluteValue(number + number2);
    }

    public static int product(int[] array) {
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            result = result * array[i];
        }
        return result;
    }

    public static void switchTest(String grade) {
        switch (grade) {
            case "A":
                System.out.println("A great grade!");
                break;
            case "B":
                System.out.println("A good grade!");
                break;
            case "C":
                System.out.println("An ok grade!");
                break;
            case "D":
                System.out.println("A bad grade!");
                break;
            default:
                System.out.println("I don't know");
        }
    }

    public static void playingWithAnArray() {
        // IMPORTANT TO UNDERSTAND REFERENCE
        int[] array = new int[] {5, 3, 1};
        int[] array2 = array;
        int[] array3 = array.clone();
        array2[0] = 7;

        System.out.println(Arrays.toString(array));

        Arrays.sort(array2);

        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(array3));

        System.out.println(product(array3));
    }

    public static void playingWithIO() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        System.out.print("Enter your name: ");
//        String name = in.next();
//        System.out.print("Enter your age: ");
//        int age = in.nextInt();
//
//        System.out.println("Name: " + name);
//        System.out.println("Age: " + age);

        System.out.print("Enter a name and a double, separated by a space: ");
        String s = in.next();
        double x = in.nextDouble();
        System.out.printf("Hi %s your grade is %.1f %n", s, x);

        in.close();

        Scanner fileInput = new Scanner (new File("src/lectures/resources/test_in.txt"));

        ArrayList<String> readWords = new ArrayList<>();
        String[] words;
        while (fileInput.hasNext()){
            words = fileInput.nextLine().split("\\s+");
            readWords.addAll(List.of(words));
        }
        fileInput.close();

        System.out.println(readWords);

        File outputFile = new File("src/lectures/resources/test_out.txt");
        PrintWriter fileOutput = new PrintWriter(outputFile);
        for (String word:readWords) {
            fileOutput.println(word);
        }

        fileOutput.close();
    }
    public static void main(String[] args) throws FileNotFoundException {

//        assignmentExample();

//        System.out.println(absoluteValue(-5));
//        System.out.println(absoluteValue(5));

//        switchTest("B");

//        for (int i = 0; i < 10; i++){
//            System.out.println(i);
//        }

//        Fraction fraction = new Fraction(1, 2);
//        Fraction fraction2 = new Fraction(1, 2);
//        Fraction product = Fraction.multiply(fraction2, fraction);
//        System.out.println(product.toFloat());
//        System.out.println(fraction.toFloat());
//
//        System.out.println(fraction2.equals(fraction));

//        playingWithAnArray();

//        playingWithIO();
    }

}


