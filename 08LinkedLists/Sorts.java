import java.util.*;
public class Sorts{
    public static void radixsortPos(MyLinkedListImproved<Integer> data){
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
		    newNum=Math.abs(num/((int)Math.pow(10,index)));
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
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer> nums = new MyLinkedListImproved();
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer> negativeNums = new MyLinkedListImproved();
	if (data.size()<=1){
	    return;
	}
	for(int i=0;i<data.size();i++){
	    Integer x = data.get(i);
	    if(x>=0){
		nums.add(x);
	    }
	    else{
		negativeNums.add(x);
	    }
	}
	if(negativeNums.size()==0){
	    radixsortPos(data);
	    return;
	}
	if(nums.size()==0){
	    radixsortNeg(data);
	    return;
	}
	radixsortPos(nums);
	radixsortNeg(negativeNums);
	negativeNums.extend(nums);
	data.clear();
	data.extend(negativeNums);
    }
    public static void radixsortNeg(MyLinkedListImproved<Integer> data){
	int  minIndex=data.min();
	int minNum=data.get(minIndex);
	String minString= "" + minNum;
	int minLength = minString.length();
	int index=0;
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[]  bucket = new MyLinkedListImproved[10];
	for(int i = 0; i < 10; i++){
            bucket[i] = new MyLinkedListImproved<>();
        }
	//System.out.println(minLength-1);
	while(index < minLength){
	    for(int i=0;i<data.size();i++){
		int num = data.get(i);
		//System.out.println(num);
		int newNum = Math.abs(num);
		//System.out.println(newNum);
		if(index!=0){
		    newNum=num/((int)Math.pow(10,index));
		}
		int digit = Math.abs(newNum % 10);
		//System.out.println(digit);
		bucket[digit].add(num);
		//System.out.println(data);
	    }
	    data.clear();
	    int negI=bucket.length-1;
	    while(negI>=0){
		data.extend(bucket[negI]);
		negI--;
	    }
	    index++;
	}
    }
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
	radixsort(data);
    }
    public static void main(String[] args){
    }
}
