import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
 
public class SlotMachine {
 
    public static void main(String[] args) throws IOException {
 
        //Declaring variables
        String userStringInput;
        double userMoney = 0;
        Random random = new Random();
        int wordIndex;
        String word = "";
        String outputString = "";
        String word1 = "";
        String word2 = "";
        String word3 = "";
        char playAgain = 'y';
        double totaluserMoney = 0;
        double totalMoneyWon = 0;
        
 
        // Opening reading and appending files
        File myFile = new File("SlotMachineMoney.txt");
        Scanner inputFile = new Scanner(myFile);
 
        while (inputFile.hasNext()) {
            String startingMoney = inputFile.nextLine();
            System.out.println(startingMoney);
            double moneyInMachine = Double.parseDouble(startingMoney);
            FileWriter fwriter = new FileWriter("myFile", true);
            PrintWriter output = new PrintWriter(fwriter);
            outputFile.println(userMoney);
            outputFile.println(totaluserMoney);
            outputFile.println(totalMoneyWon);
            outputFile.close();
 
        }
 
        //Looped conditions for the game
        while ( playAgain == 'y' ) {
            outputString = "";
            userStringInput = JOptionPane.showInputDialog("Insert Money");
            userMoney = Double.parseDouble(userStringInput);
            totalMoneyWon += userMoney;
            if (userMoney > 0 && userMoney < 100) {
                for (int wordCount = 1; wordCount <= 3; wordCount++) {
 
                    wordIndex = random.nextInt(6);
 
                    if (wordIndex == 0) {
                        word = "Cherry";
                    } else if (wordIndex == 1) {
                        word = "Apple";
                    } else if (wordIndex == 2) {
                        word = "Banana";
                    } else if (wordIndex == 3) {
                        word = "Orange";
                    } else if (wordIndex == 4) {
                        word = "Plum";
                    } else if (wordIndex == 5) {
                        word = "Grapes";
                    }
                    // Three words for the roll
                    if (wordCount == 1) {
                        word1 = word;
                    } else if (wordCount == 2) {
                        word2 = word;
                    } else if (wordCount == 3) {
                        word3 = word;
                    }
 
                }
                outputString = outputString + word1 + word2 + word3;
 
                if ((word1 != word2) && (word1 != word3) && (word2 != word3)) {
                    outputString = outputString + "\n\nYou have won $0";
                    totalMoneyWon = totalMoneyWon + 0;
                    
                } else if (((word1 == word2) && (word1 != word3)) || ((word1 == word3) && (word1 != word2)) || ((word2 == word3) && (word2 != word1))) {
                    outputString = outputString + "\n\nYou have doubled your money" + (userMoney * 2);
                    totalMoneyWon += (totaluserMoney * 2);
                } else {
               
                outputString = outputString + "\n\nYou have doubled your money" + (userMoney * 3);
                totalMoneyWon += (totaluserMoney * 3);}
 
                outputString = outputString + "\nMoney you have put in so far: " + totaluserMoney + "\nMoney won so far: " + totalMoneyWon;
                playAgain = JOptionPane.showInputDialog(outputString + "\n\n Do you want to play again?\n Enter y for yes and any key for no :").charAt(0);
totaluserMoney += userMoney;
                System.exit(0);
            } else {
                System.out.println("You can only make positive bets for up to $100");
            }
           
 
        }
    }
}