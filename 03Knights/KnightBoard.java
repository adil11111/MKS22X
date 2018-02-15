public class KnightBoard{
    private int[][] board;
    private int rows;
    private int cols;
    private int[][] moves= {;
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows <=0 || startingCols <=0){
	    throw new IllegalArgumentException();
	}	    
	board= new int[startingRows][startingCols];
	rows=startingRows;
	cols=startingCols;
	for (int r=0;r<startingRows;r++){
	    for (int c=0;c<startingCols;c++){
		board[r][c]=0;
	    }
	}
    }
    public String toString(){
	String gatherer="";
	for (int r=0;r<rows;r++){
	    for (int c=0;c<cols;c++){
		gatherer+= " " + board[r][c];
	    }
	    gatherer+= "\n";
	}
	return gatherer;
    }
    public static void main(String[]args){
	KnightBoard test = new KnightBoard(3,3);
	System.out.println(test);
    }
    public boolean solve(int startingRow, int startingCol){
	for (int r=0;r<rows;r++){
	    for (int c=0;c<cols;c++){
	        if (board[r][c] != 0){
		    throw new IllegalArgumentException();
		}
	    }
	}
	if (startingRow <= 0 || startingCol <= 0){
	    throw new IllegalArgumentException();
	}
	return true;
    }
    
}
