package com.kpushpad.problems.backtraking;



import com.kpushpad.problems.backtraking.NQueen;

public class NQueenTest {
     public static void main(String []args) {
    	 
    	   int dim = 4;
		
//    	     NQueen queen = new NQueen(4);
//    	     Boolean result = queen.placeAllQueens();
//    	     if (result == false) {
//    	    	    System.out.println("There no soulution");
//    	     }
//    	     
//    	     NQueen queen1 = new NQueen(2);
//    	     Boolean result1 = queen1.placeAllQueens();
//    	     if (result1 == false) {
//    	    	    System.out.println("There no soulution");
//    	     }
//    	     
    	     
    	     NQueen queen3 = new NQueen(8);
    	     Boolean result3 = queen3.placeAllQueens();
    	     if (result3 == false) {
    	    	    System.out.println("There no soulution");
    	     }
     }
}
