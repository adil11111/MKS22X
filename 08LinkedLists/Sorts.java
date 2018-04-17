import java.util.*;
public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	int  maxIndex=data.max();
	int maxNum=data.get(maxIndex);
	String maxString= "" + maxNum;
	int maxLength = maxString.length();
	int index=0;
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[]  bucket = new MyLinkedListImproved[10];
	for(int i = 0; i < 10; i++){
            bucket[i] = new MyLinkedListImproved<>();
        }
	while(index < maxLength){
	    for(int i=0;i<data.size();i++){
		int num = data.get(i);
		int newNum = num;
		if(index!=0){
		    newNum=num/((int)Math.pow(10,index));
		}
		int digit = newNum % 10;
		bucket[digit].add(num);
	    }
	    data.clear();
	    for(int i=0;i<bucket.length;i++){
		data.extend(bucket[i]);
	    }
	    index++;
	}
    }
    public static void radixsortNeg(MyLinkedListImproved<Integer> data){
	int  maxIndex=data.max();
	int maxNum=data.get(maxIndex);
	String maxString= "" + maxNum;
	int maxLength = maxString.length();
	int index=0;
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[]  bucket = new MyLinkedListImproved[10];
	for(int i = 0; i < 10; i++){
            bucket[i] = new MyLinkedListImproved<>();
        }
	while(index < maxLength){
	    for(int i=0;i<data.size();i++){
		int num = data.get(i);
		int newNum = Math.abs(num);
		if(index!=0){
		    newNum=num/((int)Math.pow(10,index));
		}
		int digit = newNum % 10;
		bucket[digit].add(num);
	    }
	    data.clear();
	    int negI=bucket.length;
	    while(negI>0){
		data.extend(bucket[negI]);
		negI--;
	    }
	    index++;
	}
    }

    public static void main(String[] args) {
    }
    
}
