import java.util.*;

public class CatAndMouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        for (int i = 0; i < numCases; i++) {
            String[] initialLine = scanner.nextLine().split(" ");
            int numRooms = Integer.parseInt(initialLine[0]);
            int catHome = Integer.parseInt(initialLine[1]);
            int mouseHome = Integer.parseInt(initialLine[2]);
            
            // Create adjacency matrices for cat and mouse doors
            boolean[][] catDoors = new boolean[numRooms][numRooms];
            boolean[][] mouseDoors = new boolean[numRooms][numRooms];
            
            // Read cat doors
            while (scanner.hasNext()) {
                String[] doorLine = scanner.nextLine().split(" ");
                int catFrom = Integer.parseInt(doorLine[0]);
                int catTo = Integer.parseInt(doorLine[1]);
                if (catFrom == -1 && catTo == -1) {
                    break;
                }
                catDoors[catFrom - 1][catTo - 1] = true;
            }
            
            // Read mouse doors
            while (scanner.hasNext()) {
                String[] doorLine = scanner.nextLine().split(" ");
                int mouseFrom = Integer.parseInt(doorLine[0]);
                int mouseTo = Integer.parseInt(doorLine[1]);
                if (mouseFrom == -1 && mouseTo == -1) {
                    break;
                }
                mouseDoors[mouseFrom - 1][mouseTo - 1] = true;
            }
            
            // Check if there is a path for cat and mouse to meet
            boolean canMeet = canMeet(catDoors, mouseDoors, catHome - 1, mouseHome - 1, numRooms);
            
            // Check if mouse can make a round trip without meeting the cat
            boolean canRoundTrip = canRoundTrip(catDoors, mouseDoors, catHome - 1, mouseHome - 1, numRooms);
            
            // Output the result
            System.out.println((canMeet ? "Y" : "N") + " " + (canRoundTrip ? "Y" : "N"));
            
            if (i < numCases - 1) {
                System.out.println(); // Separate outputs for multiple test cases
            }
        }
        
        scanner.close();
    }
    // Depth-first search to check if cat and mouse can meet
    private static boolean canMeet(boolean[][] catDoors, boolean[][] mouseDoors, int catRoom, int mouseRoom, int numRooms) {
        boolean[] catVisited = new boolean[numRooms];
        boolean[] mouseVisited = new boolean[numRooms];
        return dfs(catDoors, mouseDoors, catVisited, mouseVisited, catRoom, mouseRoom);
    }

    private static boolean dfs(boolean[][] catDoors, boolean[][] mouseDoors, boolean[] catVisited, boolean[] mouseVisited, int catRoom, int mouseRoom) {
        catVisited[catRoom] = true;

        if (catRoom == mouseRoom) {
            return true;
        }

        for (int i = 0; i < numRooms; i++) {
            if (catDoors[catRoom][i] && !catVisited[i]) {
                if (dfs(catDoors, mouseDoors, catVisited, mouseVisited, i, mouseRoom)) {
                    return true;
                }
            }
            if (mouseDoors[catRoom][i] && !mouseVisited[i]) {
                if (dfs(catDoors, mouseDoors, catVisited, mouseVisited, catRoom, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Depth-first search to check if mouse can make a round trip
    private static boolean canRoundTrip(boolean[][] catDoors, boolean[][] mouseDoors, int catRoom, int mouseRoom, int numRooms) {
        boolean[] visited = new boolean[numRooms];
        visited[mouseRoom] = true;
        return roundTripDFS(catDoors, mouseDoors, visited, catRoom, mouseRoom, numRooms);
    }

    private static boolean roundTripDFS(boolean[][] catDoors, boolean[][] mouseDoors, boolean[] visited, int catRoom, int currentRoom, int numRooms) {
        for (int i = 0; i < numRooms; i++) {
            if (mouseDoors[currentRoom][i] && !visited[i] && !catDoors[currentRoom][i]) {
                if (i == mouseRoom) {
                    return true; // Mouse can make a round trip
                }
                visited[i] = true;
                if (roundTripDFS(catDoors, mouseDoors, visited, catRoom, i, numRooms)) {
                    return true;
                }
            }
        }
        return false;
    }

}
