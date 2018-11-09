package  com.thizzle.server.ai.algorithms;

import org.springframework.stereotype.Service;

import com.thizzle.server.ai.games.GameBoard;

@Service
public class AlphaBetaPruning {



	@SuppressWarnings("static-access")
	public int alphaBetaPruning(GameBoard board, int turn) {

		if(board.isGameOver(turn) == true) {
			return getScore(board, turn);
		}

		if(turn == board.PLAYER) {
			return maxValue(board, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, board.PLAYER);
		}else {
			return minValue(board, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, board.COMPUTER);
		}
	}

	@SuppressWarnings("static-access")
	public int maxValue(GameBoard board, double alpha, double beta, int turn) {
		int indexOfBestMove = -1;

		for(int availableMove: board.getAvailableMoves()){

			GameBoard tempBoard = board.copyBoard(board);
			tempBoard.setBoardTile(availableMove, board.PLAYER);
			int score = alphaBetaPruning(tempBoard, board.COMPUTER);

			if (score > alpha) {
				alpha = score;
				indexOfBestMove = availableMove;
			}

			if (alpha >= beta) {
				break;
			}

		}

		if (indexOfBestMove != -1) {
			board.setBoardTile(indexOfBestMove, board.PLAYER);
		}
		return (int)alpha;
	}


	@SuppressWarnings("static-access")
	public int minValue(GameBoard board, double alpha, double beta, int turn) {
		int indexOfBestMove = -1;

		for(int availableMove: board.getAvailableMoves()){

			GameBoard tempBoard = board.copyBoard(board);
			tempBoard.setBoardTile(availableMove, board.COMPUTER);
			int score = alphaBetaPruning(tempBoard, board.PLAYER);

			if (score < beta) {
				beta = score;
				indexOfBestMove = availableMove;
			}

			if (alpha >= beta) {
				break;
			}

		}

		if (indexOfBestMove != -1) {
			board.setBoardTile(indexOfBestMove, board.COMPUTER);
		}
		return (int)beta;
	}

	@SuppressWarnings("static-access")
	public int getScore(GameBoard board, int turn) {
		if(board.isGameOver(turn) && board.getWinner() == board.COMPUTER) {
			return 10;
		}else if(board.isGameOver(turn) && board.getWinner() == board.PLAYER) {
			return -10;
		}else {
			return 0;
		}
	}

	
}


