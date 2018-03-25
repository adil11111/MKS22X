public class Merge{
     public static void merge(int[] data,int temp[],int lo,int mid,int hi){
	int first=lo;
	int second=mid+1;
	for(int i=lo;i<=hi;i++){
	    if(first<=mid && second<= hi && temp[first]<=temp[second]){
		data[i]=temp[first];
		first++;
	    }
	    else if(first<=mid && second<= hi && temp[second]<=temp[first]){
		data[i]=temp[second];
		second++;
	    }
	    else if(first>mid){
		data[i]=temp[second];
		second++;
	    }
	    else if(second>hi){
		data[i]=temp[first];
		first++;
	    }
	}
     }
	/*
        public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int medic = mid+1;
	int count = lo;
	

	while(lo <= mid && medic <= hi){

	    if (temp[lo] <= temp[medic]){
		data[count] = temp[lo];
		lo++;
	    }
	    else{
		data[count] = temp[medic];
		medic++;
	    }
	    count++;
	    //toString(temp);
	}

	while (lo <= mid){
	    data[count] = temp[lo];
	    lo++;
	    count++;
	}

	while (medic <= hi){
	    //System.out.println(count);
	    data[count] = temp[medic];
	    medic++;
	    count++;
	}	

	}*/
    
    public static void mergesort(int[] data){
	int[] temp=new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    
    private static void msort(int[]data, int[]temp, int lo, int hi){
	if (lo>=hi){
	    return;
	}
	for(int i=lo;i<hi+1;i++){
	    temp[i]=data[i];
	}
	int mid=(lo+hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,hi);
    }

    public static void main(String[]args){
	int[] data = {7,0,5,3,8,2,4,11};
	mergesort(data);
	for (int i=0;i<data.length;i++){
	    System.out.println(data[i]);
	}
    }	    
}
