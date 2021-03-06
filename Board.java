package Astar;

import java.util.ArrayList;
import java.util.List;


public class Board implements ScoreCalculatable{
	int[][] board;
	int count;
	List<Integer> path;
	
	

	public Board() {
		// TODO Auto-generated constructor stub
	}

	

	public Board(int[][] board, int count) {
		this.board = board;
		this.count = count;
		this.path = new ArrayList<Integer>(); 
	}
	
	public Board(int[][] board, int count, List<Integer> path) {
		this.board = board;
		this.count = count;
		this.path = path;
	}

	
	
	

	/**
	 * �]���֐�:�ʒu���������Ȃ��^�C���̐�
	 * 
	 * @return �]���l -1 �̂Ƃ����� ���̑��͐[��+�]���l
	 */
	public int calculateScore() {
		int score = 0;
		int l = board.length;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (board[i][j] == (i * l + j + 1)) {// i*3+j+1�͂����ɖ{������ׂ���
					continue;
				}
				
				if(board[i][j] == 0 ){
					continue;
				}

				score++;
			}
		}
		if(score == 0){
			return -1;
		}
		
		return score + count;
		

	}

	/**
	 * board�̓��e��W���o�͂ɕ\��
	 */
	public void printBoard() {
		int l = board.length;

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();

		}

		System.out.print("score:" + this.calculateScore() + " count:" + this.count + " ");
		for (Integer i : path) {
			System.out.print(i + " ");
		}
		System.out.println("--------------\n");
	}
	
	public void printPath(){
		for(Integer i:this.path){
			System.out.println(i);
		}
	}
	
	
	
	
	public Board createNextBoard(int num){
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
		
		return new Board(nBoard,this.count+1,list);
			
	}



	public int[][] getBoard() {
		return board;
	}



	public void setBoard(int[][] board) {
		this.board = board;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public List<Integer> getPath() {
		return path;
	}



	public void setPath(List<Integer> path) {
		this.path = path;
	}

	
	
}
