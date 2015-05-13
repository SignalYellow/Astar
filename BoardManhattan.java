package Astar;

import java.util.List;

public class BoardManhattan extends Board{
	
	
	
	public BoardManhattan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardManhattan(int[][] board, int count, List<Integer> path) {
		super(board, count, path);
		// TODO Auto-generated constructor stub
	}

	public BoardManhattan(int[][] board, int count) {
		super(board, count);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateScore(){
		int score = 0;
		int length = board.length;
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				int temp = board[i][j];
				
				if(temp == 0) continue;
				
				int x = temp%3;
				int y = temp/3;
				
				score += Math.abs(j-x) + Math.abs(i-y);
			}
		}
		return 0;
	}

}
