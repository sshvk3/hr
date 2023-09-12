import java.util.*;

/**
 * This program determines if it is possible for all banks to pay back their debts using only their monetary reserves and credits.
 * The program takes input specifying the number of banks, their monetary reserves, and debenture information and outputs whether a bailout is necessary or not.
 */
public class BankDebentures {
    /**
     * Checks if it is possible to liquidate all debentures without a bailout from the Central Bank of Nlogonia.
     *
     * @param B        The number of banks.
     * @param N        The number of debentures.
     * @param reserves An array of monetary reserves for each bank.
     * @param debts    An array of debtor bank IDs for each debenture.
     * @param credits  An array of creditor bank IDs for each debenture.
     * @param values   An array of debenture values.
     * @return 'true' if it is possible to liquidate all debentures without a bailout, 'false' otherwise.
     */
    public static boolean isPossibleToLiquidate(int B, int N, int[] reserves, int[] debts, int[] credits, int[] values) {
        // Use dynamic programming to check if it's possible to liquidate the debentures
        int[] balance = new int[B];

        for (int i = 0; i < N; i++) {
            balance[debts[i] - 1] -= values[i];
            balance[credits[i] - 1] += values[i];
        }

        for (int i = 0; i < B; i++) {
            if (balance[i] + reserves[i] < 0) {
                return false; // Not possible to liquidate
            }
        }

        return true; // Possible to liquidate
    }

    /**
     * Main method for reading input and printing results.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int B = scanner.nextInt(); // Number of banks
            int N = scanner.nextInt(); // Number of debentures

            if (B == 0 && N == 0) {
                break; // End of input
            }

            int[] reserves = new int[B];
            for (int i = 0; i < B; i++) {
                reserves[i] = scanner.nextInt(); // Monetary reserves of each bank
            }

            int[] debts = new int[N];
            int[] credits = new int[N];
            int[] values = new int[N];

            for (int i = 0; i < N; i++) {
                debts[i] = scanner.nextInt(); // Debtor bank
                credits[i] = scanner.nextInt(); // Creditor bank
                values[i] = scanner.nextInt(); // Debenture value
            }
            System.out.println(isPossibleToLiquidate(B, N, reserves, debts, credits, values) ? "S" : "N");
        }

        scanner.close();
    }
}
