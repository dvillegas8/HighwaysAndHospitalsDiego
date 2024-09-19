/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Diego Villegas
 *
 */

public class HighwaysAndHospitals {
    // Returns the minimum cost to provide hospital access for all citizens in Menlo County.
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Checks if it is cheaper to buy hospitals in every city
        if (hospitalCost < highwayCost) {
            return (long) hospitalCost * n;
        }
        long minCost = 0;
        int cityX = 0;
        int cityY = 0;
        int temp = 0;
        int cityB = 0;
        // Array of cities where index = node and value = root
        int edgesAndRoots[] = new int[n + 1];
        // For each edge
        for(int i = 0; i < cities.length; i++){
            // Get left city
            cityX = cities[i][0];
            // Find top root/city of left city
            while(edgesAndRoots[cityX] > 0){
                cityX = edgesAndRoots[cityX];
            }
            // Get right city
            cityY = cities[i][1];
            // Find top root/city of right city
            while(edgesAndRoots[cityY] > 0){
                cityY = edgesAndRoots[cityY];
            }
            // Path compression
            while(edgesAndRoots[cities[i][0]] > 0){
                temp = edgesAndRoots[cities[i][0]];
                edgesAndRoots[cities[i][0]] = cityX;
                cities[i][0] = temp;
            }
            while(edgesAndRoots[cities[i][1]] > 0){
                temp = edgesAndRoots[cities[i][1]];
                edgesAndRoots[cities[i][1]] = cityY;
                cities[i][1] = temp;
            }
            // If cities are not the same, do weight balancing
            if(cityX != cityY){
                // Weight balancing
                if(edgesAndRoots[cityY] < edgesAndRoots[cityX]){
                    // Update length of right city
                    edgesAndRoots[cityY] = edgesAndRoots[cityY] + edgesAndRoots[cityX] - 1;
                    // Set the left city's root at the right city
                    edgesAndRoots[cityX] = cityY;
                }
                else{
                    // Update length of left city
                    edgesAndRoots[cityX] = edgesAndRoots[cityX] + edgesAndRoots[cityY] - 1;
                    // Set the right city's root at the left city
                    edgesAndRoots[cityY] = cityX;
                }
            }
        }
        int counter = 0;
        // Counts sub-graphs by counting which nodes are equal to themselves
        for(int i = 1; i < edgesAndRoots.length; i++){
            //System.out.println("node: " + i + ", root: " + edgesAndRoots[i]);
            if(edgesAndRoots[i] <= 0){
                counter++;
            }
        }
        //System.out.println(counter);
        minCost = ((long) counter * hospitalCost) + ((long) highwayCost * (n - counter));
        return minCost;
    }
}

