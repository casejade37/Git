package lectures;

public class practiceFinal {
    /*
    1.
    What is the running time of addEvenDigits in big-Oh notation,
    Assume that initial call is made with addEvenDigits(a, a.length), where a is an array of integers.
    What is printed out for addEvenDigits([1,2,3,4], 4)
     */
    public static void addEvenDigits(int[ ] p, int n) {
        if (n == 0)
            return;
        int x = 0;
        for (int i=0; i < n; i+=2) {
            x = x + p[i];
        }
        System.out.println(x);
        addEvenDigits(p, n - 1);
    }



    /*
    2.
    What is the running time of the following method using big-Oh notation,
    What would be the output of foo(3)?

    int foo(int n)
        sum = 1;
        i = n;
        repeatedly execute the following loop block while i > 0
              int j = 0;
              repeatedly execute the following loop block while j <= i
                    sum += i * i;
                    j++;
              end of inner loop block
              i--;
        end of outer loop block
        return sum;
     */

    /*
    3.
    If you invoke the above method with foo(a, a.length-1, 0),
    what value is at a[6]?
    the initial content of the array a is: {10, 12, 5, 8, 55, 4, 31, 12, 34, 1}.
    foo(int[ ] a, int x, int y) { // a is an array of integers
        if (x > y) {
            if (a[x] is even) {
                swap a[x] and a[y]
                foo(a, x-1, y);
            }
            else {
                foo(a, x, y+1);
            }
        }
    }
     */

    /*
    4.
    Suppose that the following sequence of operations are performed on a
    queue implemented with a fixed-length array of length 6,

    enqueue(3);
    enqueue(7);
    enqueue(1);
    enqueue(2);
    dequeue();
    dequeue();
    enqueue(4);
    enqueue(5);
    dequeue( );
    enqueue(0);
    enqueue(8);
    dequeue( );
    enqueue(3);
    enqueue(7);
    Which of the following is at location data[3] after executing the above sequence of operations.
     */

    /*
    5.
    T/F

     > P is a subset of NP.
     > P is a subset of NP-Hard
     > The traveling salesman problem is an NP-hard problem.
     > The traveling salesman problem is an NP-complete problem.
     > The Hamilton Cycle problem  is an NP-hard problem.
     > The Hamilton Cycle problem has a known polynomial time solution
     > The set of decision problems solvable in polynomial time is denoted NP.
     > A problem is in NP-Hard if it is verifiable in polynomial time.
     */


    /*
    6.
    Consider insert into a DLL:
    READ THESE QUESTIONS CAREFULLY
    EX: Header <-> A <-> B <-> C <-> Trailer
    Assume you want to insert a node at the start of the list.
    Your solution must work regardless of the order of nodes
    Build the function using the correct lines of code?

    newNode = new Node(X, null, null);
    newNode.setNext(h)
    newNode.setNext(A) (This is immediately wrong)
    newNode.setPrev(header)

    size++; // increment number of elements in the list

    h = header.getNext();
    h.setNext(newNode)
    h.setPrev(newNode)

    header.setNext(newNode)


     */

    /*
    7.
    Consider the following heap using an array .
    The array is dynamic, the capacity of which can dynamically change.
     [10, 15, 20, 21, 22, 30, 50, 41, 60, 58, 70]

     What does the array look like after remove_min()

     Afterwards, what does the array look like after add 28?
     */

    public static void main(String[] args) {
        addEvenDigits(new int[]{1,2,3,4}, 4);
    }


}
