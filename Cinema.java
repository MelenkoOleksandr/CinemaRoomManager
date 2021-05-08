package cinema;
import java.util.*;
public class Cinema {

    public static void menu(int rows, int seats, char[][] cinema) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        System.out.println();
        int bought = 0;
        int currentIncome = 0;
        while (true) {
            switch (action) {
                case 1:
                    ShowTheSeats(rows, seats, cinema);
                    System.out.println();
                    printMenu();
                    break;
                case 2:
                    currentIncome += BuyTicket(rows, seats, cinema);
                    bought++;
                    System.out.println();
                    printMenu();
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + bought);
                    double res = (double) bought * 100 / (double) (rows * seats);
                    System.out.printf("Percentage: %.2f%% %n", res);
                    System.out.println("Current income: $" + currentIncome);
                    int total = seats * rows <= 60 ? seats * rows * 10 : (rows / 2) * seats * 10 + (rows - rows / 2) * seats * 8;
                    System.out.println("Total income: $" + total);
                    System.out.println();
                    printMenu();
                    break;
                case 0:
                    return;
            }
            action = scanner.nextInt();
        }
    }

    public static void printMenu(){
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }


    public static void ShowTheSeats(int rows, int seats, char[][] cinema) {
        System.out.println("Cinema: ");
        for(int i = 0; i <= seats; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else{
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (j==0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(cinema[i-1][j-1] + " ");
                }
            }
            System.out.println();
        }

    }

    public static int BuyTicket(int rows, int seats, char[][] cinema) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        System.out.println();

        while (row > rows || seat > seats || cinema[row - 1][seat - 1] == 'B') {
            if (row > rows || seat > seats ) {
                System.out.println("Wrong input!");
                System.out.println();
            } else {
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            }
            System.out.println("Enter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();
            System.out.println();
        }
        cinema[row - 1][seat - 1] = 'B';
        if (seats * rows <= 60) {
            System.out.println("Ticket price: $10");
            return 10;
        } else {
            if (row <= rows / 2) {
                System.out.println("Ticket price: $10");
                return 10;
            } else {
                System.out.println("Ticket price: $8");
                return 8;
            }
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println();

        char[][] cinema = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = 'S';
            }
        }
        menu(rows, seats, cinema);
    }
}