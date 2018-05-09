import java.util.*;
import java.io.*;

public class Sorts{
    public static void heapSort(Integer[] data){
	MyHeap<Integer> heap = new MyHeap<Integer>();
	heap.heapify(data);
	for(int i=data.length-1;i>=0;i--){
	    data[i]=heap.remove();
	}
    }
}
