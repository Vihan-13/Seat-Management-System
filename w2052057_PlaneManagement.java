import java.util.Scanner;


public class w2052057_PlaneManagement{
    private static final int NUM_ROWS = 4;
    private static final int SEATS_PER_ROW = 14;
    private static int[][] seats = new int[NUM_ROWS][SEATS_PER_ROW];


    public static void main(String []args){
        System.out.println ("Welcome to the Plane Management application");


                initializeSeats();
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("\nWelcome to the Seat Management System!");
                    System.out.println ("********************************************");
                    System.out.println("MENU OPTIONS");
                    System.out.println ("********************************************");
                    System.out.println("1) Buy a seat");
                    System.out.println("2) Cancel a Seat");
                    System.out.println("3) Find first available seat");
                    System.out.println("4) Show seating plan");
                    System.out.println("5) Print tickets infromation and total sales");
                    System.out.println("6) Search ticket");
                    System.out.println("0) Exit");
                    System.out.println ("********************************************");
                    System.out.print("Please select an option: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 3:
                            displayAvailableSeats();
                            break;
                        case 1:
                            bookSeat();
                            break;
                        case 4:
                            showseatingplan();
                            break;
                        case 0:
                            System.out.println("Exiting program. Goodbye!");
                            return;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }

            private static void initializeSeats() {
                for (int i = 0; i < NUM_ROWS; i++) {
                    for (int j = 0; j < SEATS_PER_ROW; j++) {
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
                char row = scanner.next().toUpperCase().charAt(0);
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

}