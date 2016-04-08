package deshani_sritharan;

/**
 * cell class that uses CellStates to show the state of each possible placement on the board
 * @author Sujanuha Yogeswaran
 *
 */
public class Cell {
	private CellState state;

	/**
	 * creates a cell and intializes the CellState as empty
	 */
	Cell() {
		state = CellState.EMPTY;
	}
	
	/**
	 * sets the parameter as the state of a particular spot in the 2D array (row & column)
	 * sets as either Player1 or Player2
	 * @param state
	 */
	public void setState(CellState state) {
		this.state = state;
	}
	
	/**
	 * the state of a particular spot in the 2D array (row & column)
	 * either empty, Player1, or Player2
	 * @return state of cell
	 */
	public CellState getState() {
		return state;
	}

	

}
