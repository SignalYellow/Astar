package Astar;

import java.util.Comparator;

public class MyComparator implements Comparator<Board>{

	@Override
	public int compare(Board o1, Board o2) {
		// TODO Auto-generated method stub
		
		int s1 = o1.calculateScore();
		int s2 = o2.calculateScore();
		
		if(s1 > s2){
			return 1;
		}else if(s1 < s2){
			return -1;
		}
		
		return 0;
	}

}
