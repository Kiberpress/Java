import java.util.LinkedList;
import java.util.List;

public class MergeSortedLinkedLists {
  public LinkedList<Integer> merge(List<LinkedList<Integer>> sortedLinkedLists){
    LinkedList<Integer> result = new LinkedList<>();
    if (sortedLinkedLists == null || sortedLinkedLists.size() == 0){
      return result;
    }

    MinBinaryHeap minHeap = new MinBinaryHeap(sortedLinkedLists.size());
    int totalNumber = 0;
    for (int i = 0; i < sortedLinkedLists.size(); i++) {
      for (int j = 0; j < sortedLinkedLists.get(i).size(); j++) {
        minHeap.add(sortedLinkedLists.get(i).get(j));
      }
      totalNumber += sortedLinkedLists.get(i).size();
    }

    for (int i = 0; i < totalNumber; i++) {
      result.add(minHeap.extractMin());
    }

    return result;
  }

  public Node merge(Node[] a, int N){
    MinBinaryHeap minHeap = new MinBinaryHeap(N);
    for (int i = 0; i < N; i++) {
      Node node = a[i];
      while (node != null){
        minHeap.add(node.data);
        node = node.next;
      }
    }
    Node root = new Node(-1);
    Node node = root;
    while (minHeap.getArrayCnt() > 0){
        Node newNode = new Node(minHeap.extractMin());
        node.next = newNode;
        node = node.next;
    }
    return root.next;
  }
}
