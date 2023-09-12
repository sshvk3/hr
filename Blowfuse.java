import java.util.Scanner;

/**
 * This class represents a solution for a problem involving electrical devices and power consumption.
 */
public class Blowfuse {
    /**
     * The main method of the program.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 0;

        while (true) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int c = scanner.nextInt();

            if (n == 0 && m == 0 && c == 0) {
                break;
            }

            int[] devices = new int[n];
            boolean[] isOn = new boolean[n];
            int maxConsumption = 0;
            int currentConsumption = 0;
            boolean fuseBlown = false;

            for (int i = 0; i < n; i++) {
                devices[i] = scanner.nextInt();
            }

            for (int i = 0; i < m; i++) {
                int deviceNumber = scanner.nextInt() - 1; // Adjusting for 0-based indexing
                if (isOn[deviceNumber]) {
                    currentConsumption -= devices[deviceNumber];
                } else {
                    currentConsumption += devices[deviceNumber];
                }

                isOn[deviceNumber] = !isOn[deviceNumber];

                if (currentConsumption > c) {
                    fuseBlown = true;
                }

                maxConsumption = Math.max(maxConsumption, currentConsumption);
            }

            testCase++;

            System.out.println("Sequence " + testCase);
            if (fuseBlown) {
                System.out.println("Fuse was blown.");
            } else {
                System.out.println("Fuse was not blown.");
                System.out.println("Maximal power consumption was " + maxConsumption + " amperes.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
