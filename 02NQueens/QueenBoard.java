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
    
    
    private boolean addQueen(int r, int c){
	int row=r;
	int col=c;
	if (board[r][c]==0){
	    board[r][c]=-1;
	    for (;row<board.length-1;row++){
		board[row+1][col+1]+=1;
	    }
	    row=r;
	    col=c+1;
	    for (;col<board[0].length;col++){
		board[r][col]+=1;
	    }
	    row=r;
	    col=c;
	    for (;row>=0 && col>=0;row--){
		board[row-1][col-1]+=1;
		col--;
	    }
	return true;
	}
	return false;
    }
    private boolean removeQueen(int r, int c){
	if (board[r][c]==-1){
	    board[r][c]=0;
	    for (int row= r;row<board.length-1;row++){
		board[row+1][row+1]-=1;
	    }
	    for (int col=c+1;col<board[0].length;col++){
		board[r][col]-=1;
	    }
	    for (int row=r;row>0;row--){
		board[row-1][row-1]-=1;
	    }
	return true;
	}
	return false;
    }

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
    public boolean solve(int col){
	if (col>=board[0].length){
	    return true;
	}
	for (int r=0;r<board.length;r++){
	    if(addQueen(r,col)){
		if (solve(col+1)){
		    return true;
		}
		removeQueen(r,col);
	    }
	}
	return false;
    }
    //public int countSolution(){}

    public static void main(String[] args){
        QueenBoard test = new QueenBoard(5);
	//test.addQueen(0,0);
	//System.out.println(test);
	test.addQueen(4,0);
	System.out.println(test);
    }
}
