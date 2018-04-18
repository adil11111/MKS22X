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
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
   
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
		System.out.println(num);
		int newNum = Math.abs(num);
		System.out.println(newNum);
		if(index!=0){
		    newNum=num/((int)Math.pow(10,index));
		}
		int digit = Math.abs(newNum % 10);
		System.out.println(digit);
		bucket[digit].add(num);
		System.out.println(data);
	    }
	    data.clear();
	    int negI=bucket.length-1;
	    while(negI>0){
		data.extend(bucket[negI]);
		negI--;
	    }
	    index++;
	}
    }

    public static void main(String[] args) {
	MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
	data.add(-8);
	data.add(-90);
	data.add(-2);
	data.add(-6);
	//data.add(-19);
	radixsortNeg(data);
	System.out.println(data);
    }
    
}
