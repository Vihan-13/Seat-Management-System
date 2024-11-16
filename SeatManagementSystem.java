import java.util.Scanner;

public class SeatManagementSystem {
    private static final int ROWS_OPTION_1 = 12;
    private static final int ROWS_OPTION_2 = 14;
    private static final int SEATS_PER_ROW = 10;
    private static int[][] seatsOption1 = new int[ROWS_OPTION_1][SEATS_PER_ROW];
    private static int[][] seatsOption2 = new int[ROWS_OPTION_2][SEATS_PER_ROW];

    public static void main(String[] args) {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Seat Management System!");
            System.out.println("1. View Available Seats (Option 1)");
            System.out.println("2. View Available Seats (Option 2)");
            System.out.println("3. Book a Seat");
            System.out.println("4. Exit");
            System.out.println("5. Show Seating Plan (Option 1)");
            System.out.println("6. Show Seating Plan (Option 2)");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableSeats(seatsOption1);
                    break;
                case 2:
                    displayAvailableSeats(seatsOption2);
                    break;
                case 3:
                    bookSeat(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                case 5:
                    showSeatingPlan(seatsOption1);
                    break;
                case 6:
                    showSeatingPlan(seatsOption2);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSeats() {
        for (int i = 0; i < ROWS_OPTION_1; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                seatsOption1[i][j] = 0; // 0 indicates available seat
            }
        }
        for (int i = 0; i < ROWS_OPTION_2; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                seatsOption2[i][j] = 0; // 0 indicates available seat
            }
        }
    }

    private static void displayAvailableSeats(int[][] seats) {
        System.out.println("\nAvailable Seats:");
        for (int i = 0; i < seats.length; i++) {
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

        int[][] selectedSeats = (row < ROWS_OPTION_1) ? seatsOption1 : seatsOption2;

        if (row >= 0 && row < selectedSeats.length && seat >= 0 && seat < SEATS_PER_ROW) {
            if (selectedSeats[row][seat] == 0) {
                selectedSeats[row][seat] = 1; // 1 indicates booked seat
                System.out.println("Seat booked successfully!");
            } else {
                System.out.println("Sorry, this seat is already booked. Please choose another one.");
            }
        } else {
            System.out.println("Invalid row or seat number. Please try again.");
        }
    }

    private static void showSeatingPlan(int[][] seats) {
        System.out.println("\nSeating Plan:");
        for (int i = 0; i < seats.length; i++) {
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
