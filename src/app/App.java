package app;

public class App {
	
    public static void main(String[] args) throws Exception {
    	
    	Board board = new Board();
    	Player human = new Player();
    	Player computer = new Player(false);
    	
    	System.out.println("************");
    	System.out.println("Tic-Tac-Toe!");
    	System.out.println("************");
    	System.out.println("Please enter the column and then row of your move.");
    	board.printBoard();
    	
    	String move = "";
    	while(true) {
    		move = human.getPlayerMove();
    		
    		while(!board.isMoveValid(move)) {
    			System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1");
    			move = human.getPlayerMove();
    		}
    		
    		while(!board.submitMove(move, human.getMarker())) {
    			System.out.println("The space entered is already taken.");
    			move = human.getPlayerMove();
    		}
    		
    		board.printBoard();
    		if(board.isWinner(human.getMarker())) {
    			System.out.println("The human wins!");
    			break;
    		}
    		
    		if(board.isCat()) {
    			System.out.println("It is a tie");
    			break;
    		}
    		
    		//Computer's turn
    		
    		move = computer.getPlayerMove();
    		
    		while(!board.isMoveValid(move)) {
    			System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1");
    			move = computer.getPlayerMove();
    		}
    		
    		while(!board.submitMove(move, computer.getMarker())) {
    			System.out.println("The space entered is already taken.");
    			move = computer.getPlayerMove();
    		}
    		
    		board.printBoard();
    		if(board.isWinner(computer.getMarker())) {
    			System.out.println("The computer wins!");
    			break;
    		}
    		
    		if(board.isCat()) {
    			System.out.println("It is a tie");
    			break;
    		}	
    	}
    }
}
