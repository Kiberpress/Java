import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinBinaryHeap {
  private int[] array;

  public int getArrayCnt() {

    return arrayCnt;
  }

  private int arrayCnt;

  public MinBinaryHeap(int size) {
    array = new int[size];
    arrayCnt = 0;
  }

  public void add(int value){
    checkAndExtendArray();
    array[arrayCnt] = value;
    ++arrayCnt;
    heapifyUp();
  }

  public int extractMin(){
    if (arrayCnt == 0){
      throw new NoSuchElementException();
    }
    int min = array[0];
    array[0] = array[arrayCnt-1];
    --arrayCnt;
    HeapifyDown();
    return min;
  }

  private void checkAndExtendArray() {
    if (arrayCnt == array.length-1){
      int[] newArray = Arrays.copyOf(array, array.length*2);
      array = newArray;
    }
  }

  private void heapifyUp() {
    int curIdx = arrayCnt - 1;
    while (curIdx > 0){
      int parentIdx = curIdx / 2;
      swap(curIdx, parentIdx);
      curIdx = parentIdx;
    }
  }

  private void swap(final int curIdx, final int parentIdx) {
    if (array[curIdx] < array[parentIdx]) {
      int swap = array[curIdx];
      array[curIdx] = array[parentIdx];
      array[parentIdx] = swap;
    }
  }

  private void HeapifyDown() {
    int parentIdx = 0;
    while(parentIdx < arrayCnt){
      int leftIdx = parentIdx*2+1;
      if (leftIdx < arrayCnt){
        int rightIdx = parentIdx*2+2;
        if (rightIdx < arrayCnt){
          leftIdx = array[leftIdx] < array[rightIdx] ? leftIdx : rightIdx;
        }
        swap(leftIdx, parentIdx);
      }
      parentIdx = leftIdx;
    }
  }
}
