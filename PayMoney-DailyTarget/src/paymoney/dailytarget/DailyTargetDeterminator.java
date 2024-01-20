package paymoney.dailytarget;

import java.util.Arrays;
import java.util.Scanner;

public class DailyTargetDeterminator {

    Integer[] transactionsList;
    Integer[] dailyTargets;

    Scanner input;

    public DailyTargetDeterminator() {
        input = new Scanner(System.in);
    }

    void collectTransactionValues () {

        System.out.println("Transaction List: ");
        System.out.println("enter the Transaction List Size");

        Integer transactionListSize = input.nextInt();
        transactionsList = new Integer[transactionListSize];

        for (int index = 0; index < transactionListSize; index ++) {

            System.out.printf("Transaction value : %d / %d", (index +1),
                    transactionListSize);
            System.out.println();
            transactionsList[index] = input.nextInt();
        }

    }

    void collectDailyTargets() {
        
        System.out.println("Daily Targets");

        System.out.println("Enter the Total No Of Daily Targets that need to be verified");
        Integer totalNoOfDailyTargets = input.nextInt();

        this.dailyTargets = new Integer[totalNoOfDailyTargets];

        for (int index = 0; index < totalNoOfDailyTargets; index ++) {

            System.out.printf("Daily Target : %d / %d", (index + 1),
                    totalNoOfDailyTargets);
            System.out.println();

            this.dailyTargets[index] = input.nextInt();
        }
    }


    void determine() {

        for (int index = 0; index < dailyTargets.length; index ++) {

            System.out.println("----------------------------------------");

            Integer dailyTarget = dailyTargets[index];

            System.out.printf("Performing Check for the TransactionsList %s and for the Daily Target %d",
                    Arrays.toString(transactionsList), dailyTarget);
            System.out.println();

            determine(dailyTarget);
        }
    }
    void determine(Integer dailyTarget) {
        int overallTransactionSum = 0;
        int counter = 0;
        boolean dailyTargetAchieved = false;

        for (int index = 0; index < transactionsList.length; index++) {

            counter++;
            Integer transactionValue = transactionsList[index];

            overallTransactionSum += transactionValue;

            if (overallTransactionSum >= dailyTarget) {
                dailyTargetAchieved = true;
                break;
            }
        }
            if(dailyTargetAchieved) {
                System.out.println("Daily Target is achieved");
                System.out.printf("Achieved after %d instances", counter);
                System.out.println();
            } else {
                System.out.println("Daily target is not achieved");
            }
    }
}
