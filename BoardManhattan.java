package Astar;

import java.util.ArrayList;
import java.util.List;

public class BoardManhattan extends Board implements ScoreCalculatable{
	
	
	
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
	public BoardManhattan createNextBoard(int num){
		int l = board.length;
		int[][] nBoard = new int[l][l];
		int z_x=-1;
		int z_y=-1;
		int prev = -1;
		if(this.path.size() >= 1){
			prev = this.path.get(this.path.size()-1);
		}
		
		for(int i=0;i<l;i++){
			for(int j=0;j<l;j++){
				nBoard[i][j] = 0;
				nBoard[i][j] = board[i][j];
				
				if(board[i][j] == 0){
					z_x = j;
					z_y = i;
				}
			}
		}
		
		int move = -1;
		
		if(num == 1){
			if(z_y  <=  0){
				return null;
			}
			
			
			move =nBoard[z_y-1][z_x];
			if(prev == move) return null;
			nBoard[z_y][z_x] = move;
			nBoard[z_y-1][z_x] = 0;
			
			
		}else if(num == 2){
			if(z_y  >=  l-1){
				return null;
			}
			
			move = nBoard[z_y+1][z_x];
			if(prev == move) return null;
			nBoard[z_y][z_x] = move;
			nBoard[z_y+1][z_x] = 0;
			
		}else if(num == 3){//left
			if(z_x  <=0){
				return null;
			}
			
			move = nBoard[z_y][z_x-1];
			if(prev == move) return null;
			nBoard[z_y][z_x] = move;
			nBoard[z_y][z_x-1] = 0;
			
		}else if(num == 4){
			if(z_x >= l-1){
				return null;
			}
			
			move = nBoard[z_y][z_x+1];
			if(prev == move) return null;
			nBoard[z_y][z_x] = move;
			nBoard[z_y][z_x+1] = 0;
			
		}
		
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(this.path);
		list.add(move);
		
		return new BoardManhattan(nBoard,this.count+1,list);
			
	}

	@Override
	public int calculateScore(){
		int score = 0;
		int length = board.length;
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				int temp = board[i][j]-1;
				
				if(temp == -1) continue;
				
				int x = temp%3;
				int y = temp/3;
				
				score += Math.abs(j-x) + Math.abs(i-y);
			}
		}
		if(score == 0) return -1;
		
		return score+count;
	}

}
