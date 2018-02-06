public class Recursion{
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n==1){
	    return 1;
	}
	return n * fact(n-1);
    }

    public int fib (int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n < 2){
	    return n;
	}
	return fibHelp(1,n, 0,1);
    }

    public int fibHelp(int counter,int n,int previous,int current){
	if (counter==n){
	    return current;
	}
	return fibHelp(counter+1,n,current,previous+current);
    }
     public double sqrt(double n){
	return sqrtHelp(n, n/2);
    }
    public double sqrtHelp(double n, double guess){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n < 2){
	    return n;
	}
	double boundary = n * 0.000001;
	if (((guess * guess) < (n + boundary)) && ((guess * guess) > (n - boundary))){
	    return guess;
	}
	return sqrtHelp(n,( n / guess + guess) / 2);
	
    }
	
    
    /* public static void main(String[] args){
	Recursion test = new Recursion();
	System.out.println(test.sqrt(-1));
	//System.out.println(100*0.0000001);
	}*/
}

