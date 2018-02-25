public class KnightBoard{
    private int[][] board;
    private int rows;
    private int cols;
    private int[][] moves= {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
			    
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
		if(board[r][c]==0){
		    gatherer+= "_ ";
		}
		else if(board[r][c]<10){
		    gatherer+=" "+  board[r][c] + " ";
		}
		else{
		    gatherer+= board[r][c] + " ";
		}
	    }
	    gatherer+= "\n";
	}
	return gatherer;
    }
    
    public void exceptionChecker(int row, int col){
	for (int r=0;r<rows;r++){
	    for (int c=0;c<cols;c++){
	        if (board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if (row < 0 || col < 0){
	    throw new IllegalArgumentException();
	}
    }
       
    public boolean solve(int startingRow, int startingCol){
	exceptionChecker(startingRow,startingCol);
	return solveH(startingRow,startingCol,1);
    }
    
    public boolean solveH(int row, int col, int level){
	if(level >= rows*cols){
	    board[row][col]=level;
	    return true;
	}  
	for(int i=0;i<moves.length;i++){
	    int rowCheck = row + moves[i][0];
	    int colCheck = col + moves[i][1];
	    if (checker(rowCheck,colCheck) && board[rowCheck][colCheck]==0 ){
		board[row][col]=level;
		if(solveH(rowCheck,colCheck,level+1)){
		    return true;
		}
		board[row][col]=0;  
	    }
	}
	return false;
    }
    
    public boolean checker(int rowCheck, int colCheck){
	return (rowCheck < board.length && rowCheck >= 0 && colCheck < board[0].length && colCheck >= 0);
    }

    public int countSolutions(int row,int col){
	exceptionChecker(row,col);
	return countSolutionsH(row,col,1);
    }
    
    public int countSolutionsH(int row,int col, int level){
	int total=0;
	if(level >= rows*cols){
	    return 1;
	}  
	for(int i=0;i<moves.length;i++){
	    int rowCheck = row + moves[i][0];
	    int colCheck = col + moves[i][1];
	    if (checker(rowCheck,colCheck) && board[rowCheck][colCheck]==0 ){
		board[row][col]=level;
		total+=countSolutionsH(rowCheck,colCheck,level+1);
		board[row][col]=0;  
	    }
	}
	return total;
    }   
}
