public class Merge{
    /* public static void merge(int[] array, int [] data,int[]merged){
	int first=0;
	int second=0;
	for(int i=0;i<(array.length+data.length)-2;i++){
	    if (array[first]<data[second]){
		merged[i]=array[first];
		first++;
	    }
	    else{
		merged[i]=data[second];
		second++;
	    }
	}
	}*/
    public static mergesort(int[] data){
	int temp=new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    private static void msort(int[]data, int[]temp, int lo, int hi){
	if (lo>=hi){
	    return;
	}
	for(int i=lo;i<hi;i++){
	    temp[i]=data[i];
	}
	int mid=(lo+hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,ho);
    }

    public static void main(String[]args){
	}	    
}
