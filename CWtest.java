import java.util.Scanner;

public class CWtest {
    private static final int NUM_ROWS = 4;
    private static final int SEATS_PER_ROW1 = 14;
    private static final int SEATS_PER_ROW2 = 12;
    private static int[][] seats = new int[NUM_ROWS][SEATS_PER_ROW];

    public static void main(String[] args) {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Seat Management System!");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.println("4. Show Seating Plan");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableSeats();
                    break;
                case 2:
                    bookSeat(scanner);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                case 4:
                    showSeatingPlan();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSeats() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < 1SEATS_PER_ROW; j++) {
                seats[i][j] = 0; // 0 indicates available seat
            }
        }
    }

    private static void displayAvailableSeats() {
        System.out.println("\nAvailable Seats:");
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                if (seats[i][j] == 0) {
                    System.out.printf("Row %d, Seat %d\n", i + 1, j + 1);
                }
            }
        }
    }

    private static void bookSeat(Scanner scanner) {
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter seat number: ");
        int seat = scanner.nextInt();

        // Adjusting index since arrays are 0-indexed
        row--;
        seat--;

        if (row >= 0 && row < NUM_ROWS && seat >= 0 && seat < SEATS_PER_ROW) {
            if (seats[row][seat] == 0) {
                seats[row][seat] = 1; // 1 indicates booked seat
                System.out.println("Seat booked successfully!");
            } else {
                System.out.println("Sorry, this seat is already booked. Please choose another one.");
            }
        } else {
            System.out.println("Invalid row or seat number. Please try again.");
        }
    }

    private static void showSeatingPlan() {
        System.out.println("\nSeating Plan:");
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                if (seats[i][j] == 0) {
                    System.out.print("O"); // O represents available seat
                } else {
                    System.out.print("X"); // X represents sold seat
                }
            }
            System.out.println();
        }
    }
}


public static void buy_seat() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the row letter");
    char row_letter = sc.next().toUpperCase().charAt(0);
    int row_letter_int = row_letter - 65;
    if (row_letter >= 'A' && row_letter <= 'D') {
        System.out.println("Enter the seat number");
        int seat_num = sc.nextInt();

        if (seats[row_letter_int][seat_num-1] == 1) {
            System.out.println("This seat is already booked");
            return;
        }
        else {
            if (row_letter == 'A') {
                seats[0][seat_num - 1] = 1;
            } else if (row_letter == 'B') {
                seats[1][seat_num - 1] = 1;
            } else if (row_letter == 'C') {
                seats[2][seat_num - 1] = 1;
            } else if (row_letter == 'D') {
                seats[3][seat_num - 1] = 1;
            }

        }

        if (seat_num > 14 && seat_num < 1) {
            System.out.println("Enter a valid seat number");

        }
        else {
            System.out.println("Booking Successfully ");
        }
    }
    else {
        System.out.println("Invalid letter please try again");
    }
}