import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

    public char[][] puzzle;
    private int cols;

    public Maze(String filename){
	int rows=0;

	try{
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    String line=in.nextLine();
	    int cols=line.length();
	    while(in.hasNextLine()){
	     	rows++;
	    }
	     in.close();
	}
	catch(FileNotFoundException e){
	}
	puzzle = new char[15][cols];
	try{
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    for (int r=0;r<puzzle.length;r++){
		String line = in.nextLine();
		for (int c=0;c<puzzle[0].length;c++){
		    char character=line.charAt(c);
		    puzzle[r][c]=character;
		}
	    }
	}
	catch(FileNotFoundException e){
	}
    }
    public String toString(){
	String gatherer = "";
	for(int r = 0; r < puzzle.length;r++){
	    for(int c = 0;c < puzzle[0].length;c++){
		gatherer += puzzle[r][c];
	    }
	    gatherer += "\n";
	}
	return gatherer;
    }

    public static String reader(String filename){
	String gatherer="";
	try{
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    while (in.hasNextLine()){
	        gatherer+=in.nextLine() + "\n";
	    }
	}
	catch (FileNotFoundException e){
	}
	return gatherer;
    }
    
    public static void main(String[] args){
        //System.out.println(reader("data1.dat"));
	Maze test= new Maze("data2.dat");
	System.out.println(test.cols);
    }
	
}
