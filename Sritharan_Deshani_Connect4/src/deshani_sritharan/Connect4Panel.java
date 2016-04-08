package deshani_sritharan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

import javax.swing.*;

import java.util.ArrayList;

/**
 * Panel that runs the connect four game.
 * @author Sujanuha Yogeswaran
 *
 */
public class Connect4Panel extends JPanel {
	
	final int ROWS = 7;
	final int COLS = 7;

	JButton[] buttons = new JButton[COLS];
	JLabel[][] labels = new JLabel[ROWS][COLS];
	final int FONT_SIZE = 26;
	CellState currentPlayer = CellState.PLAYER1;
	Board board;
	boolean ai;

	public Connect4Panel(boolean ai) {
		/**
		 * Basic setting
		 */
		super();
		setBackground(Color.cyan);
		setLayout(new GridLayout(ROWS + 1, COLS, 10, 10));

		setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
		board = new Board(ROWS, COLS);
        
		/**
		 * ai is true if user chooses one player mode
		 */
		this.ai = ai;
		
		/**
		 * initializes all buttons
		 */
		for (int j = 0; j < COLS; j++) {

			buttons[j] = new JButton("Col'm" + (j + 1));
			buttons[j].addActionListener(new ButtonListener());

		}

		/**
		 * initializes all labels
		 */
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				labels[i][j] = new JLabel("     ____");
			}
		}

		/**
		 * Add the components to the panel
		 */
		for (JButton button : buttons) {
			add(button);
		}

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				add(labels[i][j]);
			}
		}

	}

	/**
	 * changes GUI buttons as the player drops a piece down a certain column
	 * updates the panel background and foreground for each players piece
	 * @param currentPlayer
	 * @param i
	 * @param j
	 */
	public void updateLabel(CellState currentPlayer, int i, int j) {
		if (currentPlayer == CellState.PLAYER1) {
			labels[i][j].setText("          X");
			labels[i][j].setOpaque(true);
			labels[i][j].setBackground(Color.black);
			labels[i][j].setForeground(Color.white);
		} else {
			labels[i][j].setText("          O");
			labels[i][j].setOpaque(true);
			labels[i][j].setBackground(Color.white);
			labels[i][j].setForeground(Color.black);
		}
	}

	/**
	 * changes player back and forth, 
	 * between player 1 and player 2(which may be the computer in one player mode)
	 */
	public void changePlayer() {
		if (currentPlayer == CellState.PLAYER1) {
			currentPlayer = CellState.PLAYER2;
		} else {
			currentPlayer = CellState.PLAYER1;
		}
	}

	/**
	 * ButtonListener class the implements ActionListener class to perform each button's function
	 *A button allocated to each column
	 *when clicked, places pieces on the lowest possible empty position in the column
	 *each button updates board and label, checks for winner and for tie, changes player
	 *if one player mode, uses AI method to make Player2's move
	 *displays updated board
	 * @author Deshani Sritharan
	 *
	 */
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == buttons[0]) {
				if (!board.isColumnFull(0)) {
					int currentRow = board.getRowLocation(0);
					board.update(currentPlayer, currentRow, 0);
					updateLabel(currentPlayer, currentRow, 0);
					if (board.checkWinner(currentPlayer, currentRow, 0)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					if (board.draw()) {
						JOptionPane
								.showMessageDialog(null, "It is a tie!!! :)");
					}
					changePlayer();
					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();
					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}
			} else if (event.getSource() == buttons[1]) {
				if (!board.isColumnFull(1)) {
					int currentRow = board.getRowLocation(1);
					board.update(currentPlayer, currentRow, 1);
					updateLabel(currentPlayer, currentRow, 1);
					if (board.checkWinner(currentPlayer, currentRow, 1)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					changePlayer();
					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();
					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}
			} else if (event.getSource() == buttons[2]) {
				if (!board.isColumnFull(2)) {
					int currentRow = board.getRowLocation(2);
					board.update(currentPlayer, currentRow, 2);
					updateLabel(currentPlayer, currentRow, 2);
					if (board.checkWinner(currentPlayer, currentRow, 2)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					changePlayer();
					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();
					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}
			} else if (event.getSource() == buttons[3]) {
				if (!board.isColumnFull(3)) {
					int currentRow = board.getRowLocation(3);
					board.update(currentPlayer, currentRow, 3);
					updateLabel(currentPlayer, currentRow, 3);
					if (board.checkWinner(currentPlayer, currentRow, 3)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					changePlayer();

					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();
					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}
			} else if (event.getSource() == buttons[4]) {
				if (!board.isColumnFull(4)) {
					int currentRow = board.getRowLocation(4);
					board.update(currentPlayer, currentRow, 4);
					updateLabel(currentPlayer, currentRow, 4);
					if (board.checkWinner(currentPlayer, currentRow, 4)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					changePlayer();

					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();
					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}
			} else if (event.getSource() == buttons[5]) {
				if (!board.isColumnFull(5)) {
					int currentRow = board.getRowLocation(5);
					board.update(currentPlayer, currentRow, 5);
					updateLabel(currentPlayer, currentRow, 5);
					if (board.checkWinner(currentPlayer, currentRow, 5)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					changePlayer();
					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();
					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}
			} else if (event.getSource() == buttons[6]) {
				if (!board.isColumnFull(6)) {
					int currentRow = board.getRowLocation(6);
					board.update(currentPlayer, currentRow, 6);
					updateLabel(currentPlayer, currentRow, 6);
					if (board.checkWinner(currentPlayer, currentRow, 6)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					changePlayer();
					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();

					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}
			} else if (event.getSource() == buttons[7]) {
				if (!board.isColumnFull(7)) {
					int currentRow = board.getRowLocation(7);
					board.update(currentPlayer, currentRow, 7);
					updateLabel(currentPlayer, currentRow, 7);
					if (board.checkWinner(currentPlayer, currentRow, 7)) {
						JOptionPane.showMessageDialog(null, currentPlayer
								+ " is the winner!!! :)");
					}
					changePlayer();
					if (ai) {
						int col = board.ai();
						currentRow = board.getRowLocation(col);
						board.update(currentPlayer, currentRow, col);
						updateLabel(currentPlayer, currentRow, col);
						if (board.checkWinner(currentPlayer, currentRow, col)) {
							JOptionPane.showMessageDialog(null,
									"Computer is the winner!!! :)");
						}
						if (board.draw()) {
							JOptionPane.showMessageDialog(null,
									"It is a tie!!! :)");
						}
						changePlayer();

					}
				}
				board.display();
				if (board.draw()) {
					JOptionPane.showMessageDialog(null,
							"It is a tie!!! :)");
				}

			}
		}
	}
}
