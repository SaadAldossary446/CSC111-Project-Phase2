package test;
//Saad Aldossary 446101262
import java.util.Scanner;

public class LibrarySimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Predefined members
        Member user1 = new Member(1, "User One", 0);
        Member user2 = new Member(2, "User Two", 0);
        Member user3 = new Member(3, "User Three", 0);

        boolean running = true;

        while (running) {

            System.out.println("\n========== Welcome to the Library Simulation ==========");
            System.out.println("Select an option:");
            System.out.println("1. Login as " + user1.getName() + " (ID: " + user1.getId() + ")");
            System.out.println("2. Login as " + user2.getName() + " (ID: " + user2.getId() + ")");
            System.out.println("3. Login as " + user3.getName() + " (ID: " + user3.getId() + ")");
            System.out.println("4. Login as Administrator");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice >= 1 && choice <= 3) {

                Member current;
                if (choice == 1)
                    current = user1;
                else if (choice == 2)
                    current = user2;
                else
                    current = user3;

                //current.reset();

                boolean sessionActive = true;

                while (sessionActive) {

                    System.out.println("\nWelcome, " + current.getName() + "!");
                    System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Exit to Main Menu");
                    System.out.print("Choose an option: ");

                    int userOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (userOption) {
                        case 1:
                            current.viewBorrowedCount();
                            break;
                        case 2:
                            current.borrowOne();
                            break;
                        case 3:
                            current.returnOne();
                            break;
                        case 4:
                            current.displayStatistics();
                            break;
                        case 5:
                            System.out.println("Session ended. Total books currently borrowed: "
                                               + current.getBorrowedCount());
                            sessionActive = false;
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                            break;
                    }
                }

            } else if (choice == 4) {

                System.out.print("Enter admin password: ");
                String password = scanner.nextLine();

                if (!password.equals("admin")) {
                    System.out.println("Invalid password. Access denied.");
                } else {

                    boolean adminActive = true;

                    while (adminActive) {

                        System.out.println("\n===== Administrator Menu =====");
                        System.out.println("1. View Total Revenue");
                        System.out.println("2. Most Frequent Operation");
                        System.out.println("3. Exit to Main Menu");
                        System.out.print("Choose an option: ");

                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (adminChoice) {

                            case 1:
                                System.out.printf("Total Revenue from all borrow operations: %.2f\n",
                                                   Member.TotalRevenue);
                                break;

                            case 2:
                                System.out.println("Most Frequent Operation:");
                                if (Member.TotalBorrows == 0 && Member.TotalReturns == 0) {
                                    System.out.println("- No operations performed yet.");
                                } else if (Member.TotalBorrows > Member.TotalReturns) {
                                    System.out.println("- Borrow");
                                } else if (Member.TotalReturns > Member.TotalBorrows) {
                                    System.out.println("- Return");
                                } else {
                                    System.out.println("- Borrow and Return (Tie)");
                                }
                                break;

                            case 3:
                                adminActive = false;
                                break;

                            default:
                                System.out.println("Invalid option. Try again.");
                                break;
                        }
                    }
                }

            } else if (choice == 5) {

                System.out.println("Thank you for using the Library Simulation. Goodbye!");
                running = false;

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

