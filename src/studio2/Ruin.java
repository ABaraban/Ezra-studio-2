package studio2;

import support.cse131.ArgsProcessor;

import javax.swing.*;

public class Ruin {
    public static void main(String[] args) {
        ArgsProcessor ap = new ArgsProcessor(args);
        double startAmount = ap.nextDouble("How much money do you start with?");
        double initialStartValue = startAmount;
        double winChance = Math.random();
        double lossChance = 1-winChance;
        double winAmount = ap.nextDouble("What is your goal amount of money?");
        int totalRounds = 0;
        int totalSimulations = ap.nextInt("How many simulation would you like to run?");
        //int winCounter = 0;
        //int loseCounter = 0;
        int simulationLossCounter=0;

        for (int w = 0; w < totalSimulations; w++){
            startAmount = initialStartValue;
            totalRounds = 0;
            while (startAmount < winAmount && startAmount > 0) {
                totalRounds++;
                winChance = Math.random();
                if (winChance > 0.5) {
                    startAmount++;
                    //winCounter++;
                }
                else {
                    startAmount = startAmount - 1;
                    //loseCounter++;
                }
            }
          if(startAmount==winAmount) {
              System.out.println("WIN");
          }
          else{
              simulationLossCounter++;
              System.out.println("LOSE");
          }
        }
        System.out.println("This round required " + totalRounds + " times.");
        System.out.println("Actual Ruin Rate " + ((double)simulationLossCounter / totalSimulations));

    }
}
