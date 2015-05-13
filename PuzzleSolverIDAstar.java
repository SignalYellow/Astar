package Astar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PuzzleSolverIDAstar {
	
	public static Stack<ScoreCalculatable> stack = new Stack<ScoreCalculatable>();
	
	public static void main(String[] args) throws Exception {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int l = Integer.parseInt(br.readLine());

		int[][] board = new int[l][l];

		for (int i = 0; i < l; i++) {

			String line = br.readLine();
			String[] temp = line.split(" ");
			for (int j = 0; j < l; j++) {
				try {
					board[i][j] = Integer.parseInt(temp[j]);
				} catch (Exception e) {
					board[i][j] = 0;
				}
			}
		}

		
		int flag = 1;
		boolean isEnd = false;
		int cutoff = 1;
		while(!isEnd){
			
			if(flag == 1){
				Board fBoard = new Board(board, 0);
				stack.push(fBoard);
				isEnd = executeUnequal(cutoff);
			}else{
				BoardManhattan fBoard = new BoardManhattan(board, 1);
				stack.push(fBoard);
				isEnd = executeManhattan(cutoff);
			}
			
			System.out.println("-----------------cutoff:" + cutoff++);
		}
		
		
	}
	
	public static boolean executeUnequal(int cutoff){
		boolean frag = false;
		int id = 0;
		while (true) {

			if(stack.size() <= 0){
				return frag;
			}
			
			Board b =  (Board) stack.pop();
			System.out.println("---------------ID:" + ++id + " cutoff:" + cutoff);
			b.printBoard();
			if (b.calculateScore() == -1) {
				frag = true;
			}
			
			if(b.count > cutoff){
				continue;
			}

			for (int i = 1; i < 5; i++) {
				Board t = b.createNextBoard(i);
				if (t != null) {
					stack.push(t);
				}
			}
		}
	}

	public static boolean executeManhattan(int cutoff) {
		int id = 0;
		boolean frag = false;
		while (true) {
			
			if(stack.size() <= 0){
				return frag;
			}
			
			BoardManhattan b = (BoardManhattan) stack.pop();
			System.out.println("---------------ID:" + ++id + " cutoff:" + cutoff);
			b.printBoard();
			if (b.calculateScore() == -1) {
				return true;
			}
			
			if(b.count >= cutoff){
				continue;
			}

			for (int i = 1; i < 5; i++) {

				BoardManhattan t = b.createNextBoard(i);
				if (t != null) {
					stack.push(t);
				}
			}
		}
		

		
	}
}

/*
 * 162 453 780
 */
