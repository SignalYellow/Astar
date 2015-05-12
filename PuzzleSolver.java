package Astar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PuzzleSolver {
	
	public static PriorityQueue<Board> pQueue;
	
	public static void main(String[] args) throws Exception {
		pQueue = new PriorityQueue(1,new MyComparator());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		
		int[][] board = new int[l][l];
		
		for (int i = 0; i < l; i++) {

			String line = br.readLine();
			String[] temp = line.split(" ");
			for (int j = 0; j < l; j++) {
				try{
				board[i][j] = Integer.parseInt(temp[j]);
				}catch(Exception e){
					board[i][j] = 0;
				}
			}
		}
		
		int id = 0;
		
		Board fBoard = new Board(board,0);
		pQueue.add(fBoard);
		while(true){
			
			Board b = pQueue.poll();
			System.out.println("---------------ID:" + ++id);
			b.printBoard();
			if(b.calculateScore() == -1){
				break;
			}
			
			for(int i=1;i<5;i++){
				
				Board t = b.createNextBoard(i);
				if(t != null){
					pQueue.add(t);
				}
			}
		}
	}
}
	


/*
 * 162
 * 453
 * 780
 */
