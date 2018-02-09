public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board= new int[size][size];
	for(int r=0;r<size;r++){
	    for(int c=0;c<size;c++){
		board[r][c]=0;
	    }
	}
    }
    
    
    //private boolean addQueen(int r, int c){}
    //private boolean removeQueen(int r, int c){}

    public String toString(){
	String gatherer="";
	for(int r=0;r<board.length;r++){
	    for(int c=0;c<board.length;c++){
	        gatherer= gatherer +board[r][c] + " ";
	    }
	    gatherer = gatherer + "\n";
	}
	return gatherer;
    }
    //public boolean solve(){}
    //public int countSolution(){}

    public static void main(String[] args){
        QueenBoard test = new QueenBoard(5);
	System.out.println(test);
    }
}
