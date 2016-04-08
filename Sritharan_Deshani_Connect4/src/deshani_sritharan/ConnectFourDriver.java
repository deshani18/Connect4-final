package deshani_sritharan;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Displays the basic instructions of the game 
 * User chooses between 1 player mode and two player mode
 * creates panel and passes the mode chosen
 * @author Deshani Sritharan
 *
 */
public class ConnectFourDriver {
	public static void main(String args[]){
     
		Scanner in= new Scanner(System.in);
		
		System.out.println("Welcome to Connect 4!");
		System.out.println("Player one's piece is 'X' and the colour black.");
		System.out.println("Player two's piece is 'O'and the colour white.");
		
		System.out.println("For Single Player mode, enter 1!");
		System.out.println("For Two Player mode, enter 2!");
		int playerMode=in.nextInt();
		boolean ai;
		if (playerMode==1){
			ai=true;
		}else{
			ai=false;
		}
		
		/**
		 * GUI setings 
		 */
		JFrame frame = new JFrame("Connect 4");
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Connect4Panel(ai));

		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
 }
}
