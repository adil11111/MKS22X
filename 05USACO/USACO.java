import java.io.*;
import java.util.*;

public class USACO{
    public  int[] instructions;
    public  int[][] map;
    public  int[][] commands;

    public USACO(String filename){
	instructions = new int[4];
	try{
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    while (in.hasNextInt()){
	        System.out.println("num");
		for(int i=0;i<4;i++){
		    instructions[i]=in.nextInt();
		}
		for (int r=0;r<instructions[0];r++){
		    for (int c=0;c<instructions[1];c++){
			map[r][c]=in.nextInt();
		    }
		}
	    }
	}
	catch(FileNotFoundException e){
	}
    }

    public static void main(String[] args){
	USACO test=new USACO("makelake.in");
        for(int i=0;i<4;i++){
	    System.out.println(test.instructions[i]);
	}
	for (int r=0;r<test.instructions[0];r++){
	    for (int c=0;c<test.instructions[1];c++){
		System.out.println(test.map[r][c]);
	    }
	    System.out.println("\n");
	}
    }
	
}
