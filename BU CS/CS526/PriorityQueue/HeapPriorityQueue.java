package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
//Min-heap based priority queue
public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    //Instance variable array list representation of a heap data structure
   protected ArrayList<Entry<K,V>> heap = new ArrayList<>();

   //Default constructor - uses abstractpriorityqueue constructor
   public HeapPriorityQueue(){super();}

   //User-specified comparator
   public HeapPriorityQueue(Comparator<K> comp){super(comp);}

   //Get parent index, given child index
   protected int parent(int j) {return (j-1)/2;}

   //Get left child, given parent
   protected int left(int j) {return 2*j + 1;}

   //Get right child, given parent
   protected int right(int j) {return 2*j + 2;}

   //Check whether left child of node at index j exists
   protected boolean hasLeft(int j){return left(j) < heap.size();}

   //Check whether right child of node at index j exists
   protected boolean hasRight(int j){return right(j) < heap.size();}


   //Swap nodes at indices i and j in the heap
   protected void swap(int i, int j)
   {
       Entry<K,V> temp = heap.get(i);
       heap.set(i,heap.get(j));
       heap.set(j,temp);
   }


   //Upheap bubbling of node at index j
   protected void upheap(int j)
   {
       //While node hasn't reached the root
       while(j > 0)
       {

           //Get the parent node
           int p = parent(j);

           //Check whether you are smaller than your parent
           if (compare(heap.get(j),heap.get(p)) >=0) break;

           //If you are, then swap
           swap(j,p);

           j = p;
       }
   }


   //Downheap bubbling of node at index j
   protected void downheap(int j)
   {
       //Check whether a left-child exists for node at j
       while(hasLeft(j))
       {
           //Get left child index of j
           int leftIndex = left(j);
           int smallChildIndex = leftIndex;

           //If j has a right child
           if(hasRight(j))
           {
               //Check whether the right child index is smaller than left
               int rightIndex = right(j);
               if(compare(heap.get(leftIndex),heap.get(rightIndex)) > 0)
                   //If so mark that right child is smaller
                   smallChildIndex = rightIndex;

           }
           //If smallest child is smaller than current node
           if(compare(heap.get(smallChildIndex),heap.get(j)) >=0)
               break;

           //Swap current node with smallest child
           swap(j,smallChildIndex);
           j = smallChildIndex;
       }
   }



   //Return number of entries in the priority queue
   public int size(){return heap.size();}

   //Get smallest entry in priority queue (highest priority)
   public Entry<K,V> min()
   {
       if (heap.isEmpty()) return null;
       return heap.get(0);
   }

   //Insert a new entry into the priority queue with Key "key" and Value "value"
   public Entry<K,V> insert(K key, V value) throws IllegalArgumentException
   {
       //Check whether key already exists
       checkKey(key);

       //Create PQ Entry for this pair
       Entry<K,V> newest = new PQEntry<>(key,value);

       //Add to end of heap
       heap.add(newest);

       //Perform upheap bubbling
       upheap(heap.size()-1);
       return newest;
   }

   //Remove minimum key entry from heap
   public Entry<K,V> removeMin()
   {
       //Do nothing if heap is empty
       if(heap.isEmpty()) return null;

       //Get entry to remove
       Entry<K,V> answer = heap.get(0);

       //Swap last node in the heap with the root
       swap(0,heap.size()-1);

       //Remove the old root from the heap
       heap.remove(heap.size()-1);

       //Perform downheap bubbling on the new root
       downheap(0);
       return answer;
   }

   //Use array-list toString method to print out the heap
   public String toString()
   {
       return heap.toString();
   }





}
