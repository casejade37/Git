package lectures;

import java.util.Arrays;

public class lesson12 {
    public static void main(String[] args) {
        int[] lst = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(lst);
        System.out.println(Arrays.toString(lst));

    }
    public static void mergeSort(int[] list) {
        int n = list.length;
        if (n < 2) {
            return;
        }
        int mid = n/2;
        // Notice that this is *not* an in place sort implementation
        int[] firstHalf = Arrays.copyOfRange(list, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(list, mid, n);
        mergeSort(firstHalf);
        mergeSort(secondHalf);
        merge(firstHalf, secondHalf, list); // merge sorted halves back into original
    }

    public static void merge(int[] firstHalf, int[] secondHalf, int[] list) {
        int i = 0, j = 0;
        // While we haven't merged the entire list
        while (i + j < list.length) {
            // Either we finished the secondHalf
            if (j == secondHalf.length) {
                list[i + j] = firstHalf[i];
                i++;
                // Or we finished the first half
            } else if (i == firstHalf.length) {
                list[i + j] = secondHalf[j];
                j++;
            // Or first half's element is smaller
            } else if (firstHalf[i] < secondHalf[j]) {
                list[i + j] = firstHalf[i];
                i++;
            // Or second half's element is smaller
            } else {
                list[i + j] = secondHalf[j];
                j++;
            }
        }
    }
}
