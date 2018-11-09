package  com.thizzle.server.ai.tictactoe;

import java.util.ArrayList;
import java.util.List;

import com.thizzle.server.ai.games.GameBoard;

public class TicTacToBoard implements GameBoard{


	private Integer[] board;
	public final int BLANK = 0, X = 1, O = 2;
	public final int PLAYER = 2, COMPUTER = 1;
	boolean realBoard = false;

	private int winner = -1;

	public TicTacToBoard(Integer[] board) {
		this.board = new Integer[board.length];
		for (int i = 0; i < board.length; i++) {
			this.board[i] = board[i]; 
		}
	}


	public void setBoard(Integer[] board) {
		this.board = board;
	}

	public void setBoardTile(int place,  int value) {
		this.board[place] = value;
	}

	public Integer[] getBoard(){
		return this.board;
	}

	public boolean isGameOver(int turn) {

		if(isThereAWinner(turn) == false) {
			for(int i = 0; i < 9; i++) {
				if(this.board[i] == 0) {
					return false;
				}
			}
			return true;
		}else {
			return true;
		}
	}

	public boolean isThereAWinner(int turn) {
		if((this.board[0] == this.board[1] && this.board[0] == this.board[2] && this.board[0] != BLANK)
				|| (this.board[3] == this.board[4] && this.board[3] == this.board[5] && this.board[3] != BLANK)
				|| (this.board[6] == this.board[7] && this.board[6] == this.board[8] && this.board[6] != BLANK)

				|| (this.board[0] == this.board[3] && this.board[0] == this.board[6] && this.board[0] != BLANK)
				|| (this.board[1] == this.board[4] && this.board[1] == this.board[7] && this.board[1] != BLANK)
				|| (this.board[2] == this.board[5] && this.board[2] == this.board[8] && this.board[2] != BLANK)

				|| (this.board[0] == this.board[4] && this.board[0] == this.board[8] && this.board[0] != BLANK)
				|| (this.board[2] == this.board[4] && this.board[2] == this.board[6] && this.board[2] != BLANK)
				) {
			setWinner(turn);
			return true;
		}else {
			return false;
		}
	}

	public List<Integer> getAvailableMoves() {
		ArrayList<Integer> availableMoves = new ArrayList<>();

		for(int i = 0; i < 9; i++) {
			if(this.board[i] == BLANK) {
				availableMoves.add(i);
			}
		}
		return availableMoves;
	}

	public int getWinner() {

		return this.winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public void setRealBoard() {
		this.realBoard = true;
	}

	public GameBoard copyBoard(GameBoard board){
		GameBoard copyBoard = new TicTacToBoard(board.getBoard());
		return copyBoard;
	}


}


