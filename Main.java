import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");

        //CheckMinBinaryHeap();
        CheckMergeSortedLinkedLists();

        int wait = System.in.read();
    }

    private static void CheckMinBinaryHeap() {

        MinBinaryHeap minHeap = new MinBinaryHeap(5);
        minHeap.add(3);
        minHeap.add(7);
        minHeap.add(2);
        minHeap.add(-4);
        minHeap.add(8);
        minHeap.add(34);
        minHeap.add(74);
        minHeap.add(0);
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
    }


    private static void CheckMergeSortedLinkedLists() {

        List<LinkedList<Integer>> input = new ArrayList<>();
        input.add(new LinkedList<>(Arrays.asList(1, 3, 5, 7)));
        input.add(new LinkedList<>(Arrays.asList(2, 4, 6, 8)));
        input.add(new LinkedList<>(Arrays.asList(0, 9, 10, 11)));
        MergeSortedLinkedLists mergeLists = new MergeSortedLinkedLists();
        LinkedList<Integer> result = mergeLists.merge(input);
        System.out.println(result);
    }
}
