package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board{
	
	private char[][] gameBoard;
	
	//----Constructors----//
	
	//Initializes the board to an empty board
	Board()
	{
		gameBoard = new char[][]{
			{' ','|','A','|','B','|','C'},
			{'-','+','-','+','-','+','-'},
			{'1','|',' ','|',' ','|',' '},
            {'-','+','-','+','-','+','-'},
            {'2','|',' ','|',' ','|',' '},
            {'-','+','-','+','-','+','-'},
            {'3','|',' ','|',' ','|',' '}};
	}
	
	//Initializes the board to inBoard
	Board(char[][] inBoard){
		gameBoard = inBoard;
	}
	
	//----Access----//
	
	//Returns the game board
	public char[][] getGameBoard() {
		return gameBoard;
	}
	
	//prints the board to the screen
	public void printBoard() {
        for(char[] row: gameBoard)
        {
            for(char column : row)
            {
                System.out.print(column);
            }
            System.out.println();
        }
	}
	
	//Adds move to the board, and returns true if the space specified in the move is not taken.
	//If the space is taken, do not add the move and return false.
	public boolean submitMove(String move, char player) {
		//Convert string move to char array
		char[] moveChar = move.toCharArray();
		//Determine the location of the move (row and column)
		int row = 0;
		int column = 0;
		if(moveChar[0] == 'A') {
			column = 2; 
		}
		else if(moveChar[0] == 'B') {
			column = 4;
		}
		else if(moveChar[0] == 'C') {
			column = 6;
		}
		
		if(moveChar[1] == '1') {
			row = 2; 
		}
		else if(moveChar[1] == '2') {
			row = 4;
		}
		else if(moveChar[1] == '3') {
			row = 6;
		}
		boolean isTaken = false;
		//if the move is taken, update the board
		if(gameBoard[row][column] == ' ') {
			gameBoard[row][column] = player;
			isTaken = true;
		}
		
		return isTaken;
	}
	
	//Returns true if the player whose marker is passed as a parameter has won the game, false otherwise
	public boolean isWinner(char player) {
		boolean isWinner = false;
		//get all the moves of the player on the board and store in an list.
		List<Integer> playerMoves = new ArrayList<>();
		int counter = 0; 
		for(int x = 2; x <= 6; x+=2) {
			for(int y = 2; y <= 6; y+=2) {
				counter++;
				if(gameBoard[x][y] == player) {
					playerMoves.add(counter);
				}
			}
		}
		//create a list for all the possible winning moves
		List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);
        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> rightCol = Arrays.asList(3,6,9);
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(3,5,7);
        
        List<List<Integer>> winning = new ArrayList<List<Integer>>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
		//check if player's list of moves contains one of the possible winning moves list.
        for(List<Integer> l : winning){
            if(playerMoves.containsAll(l)){
                isWinner = true;
            }
        }
		return isWinner;
	}
	
	//Returns true if there is a tie, false otherwise
	public boolean isCat() {
		boolean isCat = true;
		//if there is no empty slots in the board, there is a tie.
		for(int x = 2; x <= 6; x+=2) {
			for(int y = 2; y <= 6; y+=2) {
				if(gameBoard[x][y] == ' ') {
					isCat = false;
				}
			}
		}
		return isCat;
	}
	
	//Returns true if the parameter is a move on the board, otherwise it returns false.
	public boolean isMoveValid(String move) {
		boolean isMoveValid = false;
		//convert the string into an array
		char[] moveChar = move.toCharArray();
		//check if the first character is A, B, or C
		//check if the second character is 1, 2, or 3
		//if 2 conditions are met, return true
		if(moveChar[0] == 'A' | moveChar[0] == 'B' | moveChar[0] == 'C') {
			if(moveChar[1] == '1' | moveChar[1] == '2' | moveChar[1] == '3') {
				isMoveValid = true;
			}
		}
		return isMoveValid;
	}	

}
