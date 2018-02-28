import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

    public char[][] puzzle;
    private int cols;

    public Maze(String filename){
	

	try{
	    int rows=0;
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    String first=in.nextLine();
	    int cols=first.length();
	    while(in.hasNextLine()){
		 String line = in.nextLine();
		 rows++;
		}
	     in.close();
	     puzzle = new char[rows][cols];

	}
	catch(FileNotFoundException e){
	}
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
	Maze test= new Maze("data1.dat");
	System.out.println(test);
    }
	
}
