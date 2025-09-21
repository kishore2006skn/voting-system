import java.util.Scanner;

public class VotingSystem {

    private static int tvkVotes = 0;
    private static int dmkVotes = 0;
    private static int admkVotes = 0;
    private static boolean votingOpen = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== Voting System ==========");
            System.out.println("1. Vote for TVK");
            System.out.println("2. Vote for DMK");
            System.out.println("3. Vote for ADMK");
            System.out.println("4. Admin Login");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    vote("TVK");
                    break;
                case 2:
                    vote("DMK");
                    break;
                case 3:
                    vote("ADMK");
                    break;
                case 4:
                    adminLogin(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Voting System...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void vote(String candidate) {
        if (!votingOpen) {
            System.out.println("Voting is closed.");
            return;
        }

        switch (candidate) {
            case "TVK":
                tvkVotes++;
                break;
            case "DMK":
                dmkVotes++;
                break;
            case "ADMK":
                admkVotes++;
                break;
        }

        System.out.println("Your vote for " + candidate + " has been recorded.");
    }

    private static void adminLogin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String user = scanner.next();
        System.out.print("Enter admin password: ");
        String pass = scanner.next();

        if (user.equals("admin") && pass.equals("admin123")) {
            System.out.println(" Admin login successful.");
            adminMenu(scanner);
        } else {
            System.out.println(" Invalid admin credentials.");
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Results");
            System.out.println("2. Close Voting");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    showResults();
                    break;
                case 2:
                    votingOpen = false;
                    System.out.println(" Voting is now closed.");
                    break;
                case 3:
                    System.out.println(" Logged out from admin.");
                    return;
                default:
                    System.out.println(" Invalid option.");
            }
        }
    }

    private static void showResults() {
        System.out.println("\n📊 Voting Results:");
        System.out.println("TVK Votes  : " + tvkVotes);
        System.out.println("DMK Votes  : " + dmkVotes);
        System.out.println("ADMK Votes : " + admkVotes);
        int total = tvkVotes + dmkVotes + admkVotes;
        System.out.println("Total Votes: " + total);
        System.out.flush(); 
    }
}
