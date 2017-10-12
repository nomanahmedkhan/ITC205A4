import java.util.List;
import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
	   Scanner console = new Scanner(System.in);

        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();

        Player player = new Player("Fred", 100);
        Game game = new Game(d1, d2, d3);
        List<DiceValue> cdv = game.getDiceValues();

        int totalWins = 0;
        int totalLosses = 0;
        
        int age;
        System.out.println("What is your age? You must be 18 or older to play ");
        age = console.nextInt();
        
        while(age >= 18){
        	String name;
        	System.out.println("What is your name? ");
            name = console.next();
        while (true)
        {
            int winCount = 0;
            int loseCount = 0;
        
        int balance;
        int bet;
        
        System.out.println("What is your balance?");
        balance = console.nextInt();
            for (int i = 0; i < 100; i++)
            {
            	//String name = "Fred";
            	//int balance = 100;
            	int limit = 0;
                player = new Player(name, balance);
                player.setLimit(limit);
                System.out.println("How much do you want to bet? bet 0 to end this round");
                
                bet = console.nextInt();
                if(bet == 0){
                	break;
                }

                System.out.println(String.format("Start Game %d: ", i));
                System.out.println(String.format("%s starts with balance %d, limit %d", 
                		player.getName(), player.getBalance(), player.getLimit()));

                int turn = 0;
                while (player.balanceExceedsLimitBy(bet) && player.getBalance() < 200)
                {
                    turn++;                    
                	DiceValue pick = DiceValue.getRandom();
                   
                	System.out.printf("Turn %d: %s bet %d on %s\n",
                			turn, player.getName(), bet, pick); 
                	
                	int winnings = game.playRound(player, pick, bet);
                    cdv = game.getDiceValues();
                    
                    System.out.printf("Rolled %s, %s, %s\n",
                    		cdv.get(0), cdv.get(1), cdv.get(2));
                    
                    if (winnings > 0) {
	                    System.out.printf("%s won %d, balance now %d\n\n",
	                    		player.getName(), winnings, player.getBalance());
	                	winCount++; 
                    }
                    else {
	                    System.out.printf("%s lost, balance now %d\n\n",
	                    		player.getName(), player.getBalance());
	                	loseCount++;
                    }
                    
                } //while

                System.out.print(String.format("%d turns later.\nEnd Game %d: ", turn, i));
                System.out.println(String.format("%s now has balance %d\n", player.getName(), player.getBalance()));
                
            } //for
            
            System.out.println(String.format("Win count = %d, Lose Count = %d, %.2f", winCount, loseCount, (float) winCount/(winCount+loseCount)));
            totalWins += winCount;
            totalLosses += loseCount;

            System.out.println("Do you want to play again? Type no if you dont");
            name = console.next();
            if (name.equals("no")) break;
        } //while true
        System.out.println(String.format("Overall win rate = %.1f%%", (float)(totalWins * 100) / (totalWins + totalLosses)));
        System.out.println("What is your age? You must be 18 or older to play ");
        age = console.nextInt();
        }// while age 
        
        System.out.println("You're not old enough to play");
        }
	}


