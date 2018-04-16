public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	int  maxIndex=data.max();
	int maxNum=data.get(maxIndex);
	String maxString= "" + maxNum;
	int maxLength = maxString.length();
	int index=0;
	@SuppressWarnings("unchecked")MyLinkedListImproved<Integer>[]  bucket = new MyLinkedListImproved[10]; 
	while(index < maxLength){
	    for(int i=0;i<data.size();i++){
		int num = data.get(i);
		num=num/(index*10);
		int digit = num % 10;
		bucket[digit].add(num);
	    }
	    data.clear();
	    for(int i=0;i<bucket.length;i++){
		data.extend(bucket[i]);
	    }
	    index++;
	}
    }
}
