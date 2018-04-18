import java.util.ArrayList;
public class Calculator{
    private static ArrayList<String> stack = new ArrayList<>();
    public static double eval(String s){
	String[] array = s.split(" ", -1);
        for(int i=0;i<array.length;i++){
	    stack.add(array[i]);
	}
	System.out.println(stack);
	return 0;
    }
    public void push(String s){
    }
    public double pop(String s){
    }
    public static void main(String[] args){
	eval("8 2 + 99 9 - * 2 + 9 -");
    }
}
