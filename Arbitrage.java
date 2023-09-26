import java.util.*;

/**
 * The CurrencyExchange class provides a method to detect arbitrage in a given set of exchange rates
 * between currencies. It uses the Bellman-Ford algorithm to check for negative cycles in the exchange rate graph.
 */
public class Arbitrage {
    /**
     * Represents an edge in the exchange rate graph.
     */
    static class Edge {
        int source, destination;
        double rate;

        /**
         * Constructs a new Edge instance.
         *
         * @param source      The index of the source currency.
         * @param destination The index of the destination currency.
         * @param rate        The exchange rate from source to destination currency.
         */
        Edge(int source, int destination, double rate) {
            this.source = source;
            this.destination = destination;
            this.rate = rate;
        }
    }

    /**
     * Detects arbitrage in a given list of edges and currency count.
     *
     * @param edges The list of edges representing exchange rates.
     * @param n     The number of currencies.
     * @return True if arbitrage is possible, otherwise false.
     */
    public static boolean detectArbitrage(List<Edge> edges, int n) {
        double[] distances = new double[n];
        Arrays.fill(distances, 0.0);

        // Relax edges V - 1 times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                double newDistance = distances[edge.source] - Math.log(edge.rate);
                if (newDistance < distances[edge.destination]) {
                    distances[edge.destination] = newDistance;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            double newDistance = distances[edge.source] - Math.log(edge.rate);
            if (newDistance < distances[edge.destination]) {
                return true; // Negative cycle detected, arbitrage is possible
            }
        }

        return false; // No negative cycle detected, no arbitrage
    }

    /**
     * Main method to read input and perform arbitrage detection.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            List<Edge> edges = new ArrayList<>();

            // Read currencies and exchange rates
            Map<String, Integer> currencyToIndex = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String currency = scanner.next();
                currencyToIndex.put(currency, i);
            }

            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                String sourceCurrency = scanner.next();
                double rate = scanner.nextDouble();
                String destinationCurrency = scanner.next();

                int sourceIndex = currencyToIndex.get(sourceCurrency);
                int destinationIndex = currencyToIndex.get(destinationCurrency);

                edges.add(new Edge(sourceIndex, destinationIndex, rate));
            }

            boolean arbitragePossible = detectArbitrage(edges, n);

            System.out.println("Case " + caseNumber + ": " + (arbitragePossible ? "Yes" : "No"));
            caseNumber++;
        }

        scanner.close();
    }
}
