package Input;

public class MovementOptions {
	
	private Player player;
	private java.util.Scanner scanner;
	private BoardGenerator bgen;
	
	public MovementOptions(Player p, java.util.Scanner in){
		this.player = p;
		this.scanner = in;
	}
	
	
	
	public int askForPlayerOption() {
	  boolean exit = false;
	  boolean valid = true;
	  int col;
	  int row;
	  String option;
	  System.out.println("Welcome to Battleship");
	  System.out.println("Let's start the game!");
		
		while (!this.bgen.isSink() && !exit){
			this.bgen.showBoard();
			
			do {
			valid = true;

			System.out.print("What do you want to do? (Introduce, Reset or Exit) ");
			option = this.scanner.nextLine();
			
				switch (option){
				case "Introduce":
				case "introduce":
					System.out.print("Put in the coordinates where you want to shoot (Row Column). ");
					col = scanner.nextInt();
					row = scanner.nextInt();
					this.player.doMovement(row, col, ¿¿IA mIA??);
					break;
		
				/*
				case "Reset":
				case "reset":
					this.game.reset();
					break;
					*/
					
				case "Exit" :
				case "exit" :
					exit = true;
					break;
					
				default:
					valid = false;
				}
			
			
			} while (valid == false);
		}
		
		if (exit)
			System.out.println("You've chosen the exit option, see you!");
		
		else if (this.bgen.isSink()){
			this.bgen.showBoard();
			
			switch(this.game.getWinner()){
				case player:
					System.out.println("YOU WIN!");
					System.out.println("Congratulations!");
					break;
					
				case computer:
					System.out.println("COMPUTER WINS!");
					System.out.println("Better luck next time!");
					break;
						
				default: System.out.println("");
			}
		
		}	
	  
	return 0;  
  }
}
