package deshani_sritharan;
import java.util.*;

import javax.swing.JOptionPane;

/**
 * creates board and maintains all activity related to the board 
 * @author Deshani Sritharan
 *
 */
public class Board {
	
	private Cell[][] board;
	private int maxRow;
	private int maxCol;

	/**
	 * creates a new board using parameters 
	 * and sets maxRow and maxCol
	 * @param ROWS
	 * @param COLS
	 */
	Board(int ROWS, int COLS) {
		maxRow = ROWS;
		maxCol = COLS;
		board = new Cell[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = new Cell();
			}
		}
	}

	/**
	 * displays the board (not GUI) and the pieces placed by player
	 * (player one is X and player O)
	 */
	public void display() {
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				if (board[i][j].getState() == CellState.EMPTY) {
					System.out.print(" - ");
				} else if (board[i][j].getState() == CellState.PLAYER1) {
					System.out.print(" X ");
				} else
					System.out.print(" O ");
			}
			System.out.println("");
		}
	}

	/**
	 * use to check if a particular column is full
	 * @param column
	 * @return true is column is full, otherwise returns false
	 */
	public boolean isColumnFull(int column) {
		return board[0][column].getState() != CellState.EMPTY;
	}

	/**
	 * gets the lowest possible row where a piece can be placed in a given column
	 * @param column
	 * @return lowest row a piece can be placed
	 */
	public int getRowLocation(int column) {
		boolean found = false;
		int rowPosition = maxRow - 1;

		while (!found) {
			if (board[rowPosition][column].getState() == CellState.EMPTY) {
				found = true;
			} else {
				rowPosition--;
			}
		}
		return rowPosition;

	}

	/**
	 * updates board as the player places their piece 
	 * @param currentPlayer
	 * @param row
	 * @param col
	 */
	public void update(CellState currentPlayer, int row, int col) {
		board[row][col].setState(currentPlayer);
	}
	
	/**
	 * checks for a tie, when the board is full
	 * @return true if it is a draw, otherwise returns false
	 */
	public boolean draw(){
		int empty=0;
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				if(board[i][j].getState() == CellState.EMPTY){
					empty++;
				}
			}
		}
		if (empty==0){
			return true;
		}else{
			return 	false;
		}
	}

	/**
	 * checks for winner by comparing surrounding pieces
	 * if four similar pieces in a line, then  winner is declared
	 * @param currentPlayer
	 * @param row
	 * @param col
	 * @return true if there is winner(i.e. four pieces in a line), otherwise returns false 
	 */
	public boolean checkWinner(CellState currentPlayer, int row, int col) {
		int rowPosition = row;
		int colPosition = col;
		int count = 1;
		boolean checking = true;
		
		/**
		 * checks down a column
		 */
		while (rowPosition<6 && checking) {
			if (currentPlayer == board[rowPosition + 1][col].getState()) {
				count++;
				rowPosition++;
			} else {
				checking = false;
			}
		}
		System.out.println("count is " + count);
		if (count == 4) {
			return true;
		}
		
		/**
		 * resets the variables used in the previous loop
		 */
	    count = 1;
		checking = true;
		rowPosition = row;
		colPosition = col;
		/**
		 * checks left of the piece that was last placed
		 */
		while (colPosition>0 && checking) {
			if (currentPlayer == board[rowPosition][colPosition-1]
					.getState()) {
				count++;
				colPosition--;
			} else {
				checking = false;
			}
		}
		System.out.println("count is " + count);
		if (count == 4) {
			return true;
		}
		
		/**
		 * resets the variables used in the previous loop
		 * except count(the piece placed last maybe in the middle of winning line)
		 */
		checking = true;
		colPosition = col;
		
		/**
		 * checks right of the piece that was last placed
		 */
		while (colPosition<6 && checking) {
			if (board[row][col].getState() == board[rowPosition][colPosition+1]
					.getState()) {
				count++;
				colPosition++;
			} else {
				checking = false;
			}
		}
		System.out.println("count is " + count);
		if (count >= 4) {
			return true;
		}
		
		/**
		 * resets the variables used in the previous loop
		 */
		count = 1;
		checking = true;
		rowPosition = row;
		colPosition = col;
		/**
		 * checks left and up of the piece that was last placed
		 */
		while (colPosition>0 && rowPosition>0 && checking) {
			if (board[row][col].getState() == board[rowPosition - 1][colPosition-1]
					.getState()) {
				count++;
				colPosition--;
				rowPosition--;
			} else {
				checking = false;
			}
			System.out.println("count is " + count);
		}if (count == 4) {
			return true;
		}
		/**
		 * resets the variables used in the previous loop
		 * except count(the piece placed last maybe in the middle of winning line)
		 */
		checking = true;
		rowPosition = row;
		colPosition = col;
		/**
		 * checks right and down of the piece that was last placed
		 */
		while (colPosition<6 && rowPosition<6 && checking) {
			if (board[row][col].getState() == board[rowPosition + 1][colPosition + 1]
					.getState()) {
				count++;
				colPosition++;
				rowPosition++;
			} else {
				checking = false;
			}
			System.out.println("count is " + count);
		}if (count >= 4) {
			return true;
		}
		
		/**
		 * resets the variables used in the previous loop
		 */
		count = 1;
		checking = true;
		rowPosition = row;
		colPosition = col;
		/**
		 * checks left and down of the piece that was last placed
		 */
		while (colPosition>0 && rowPosition<6 && checking) {
			if (board[row][col].getState() == board[rowPosition + 1][colPosition-1]
					.getState()) {
				count++;
				colPosition--;
				rowPosition++;
			} else {
				checking = false;
			}
			System.out.println("count is " + count);
		}if (count == 4) {
			return true;
		}
		
		/**
		 * resets the variables used in the previous loop
		 * except count(the piece placed last maybe in the middle of winning line)
		 */
		checking = true;
		rowPosition = row;
		colPosition = col;
		/**
		 * checks right and up of the piece that was last placed
		 */
		while (colPosition<6 && rowPosition>0 && checking) {
			if (board[row][col].getState() == board[rowPosition - 1][colPosition + 1]
					.getState()) {
				count++;
				colPosition++;
				rowPosition--;
			} else {
				checking = false;
			}
		}
		System.out.println("count is " + count);
		if (count >= 4) {
			return true;
		}else{
			return false;
			// test
		}

	}
	/**
	 * if one player mode, AI plays the role of player 2,
	 * and places piece is a valid column that is not full
	 * http://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
	 * @return the valid column (not filled) that a piece can be placed
	 */
	public int ai(){
		boolean isDone=false;
		int randomCol=0;
		while(!isDone){
			Random rn = new Random();
			randomCol = rn.nextInt(maxCol);
			if(!isColumnFull(randomCol)){
				isDone=true;
			}
		}
		return randomCol;
	}

}
