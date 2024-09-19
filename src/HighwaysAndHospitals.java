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
        int leftTopRoot = 0;
        int rightTopRoot = 0;
        int originalRoot = 0;
        int leftCity = 0;
        int rightCity = 0;
        // Array of cities where index = node and value = root
        int[] edgesAndRoots = new int[n + 1];
        // For each edge
        for(int i = 0; i < cities.length; i++){
            // Get left city
            leftCity = cities[i][0];
            leftTopRoot = leftCity;
            // Find top root/city of left city
            while(edgesAndRoots[leftTopRoot] > 0){
                leftTopRoot = edgesAndRoots[leftTopRoot];
            }
            // Get right city
            rightCity = cities[i][1];
            rightTopRoot = rightCity;
            // Find top root/city of right city
            while(edgesAndRoots[rightTopRoot] > 0){
                rightTopRoot = edgesAndRoots[rightTopRoot];
            }
            // Path compression for left city
            while(edgesAndRoots[leftCity] > 0){
                originalRoot = edgesAndRoots[leftCity];
                edgesAndRoots[leftCity] = leftTopRoot;
                leftCity = originalRoot;
            }
            // Path compression for right city
            while(edgesAndRoots[rightCity] > 0){
                originalRoot = edgesAndRoots[rightCity];
                edgesAndRoots[rightCity] = rightTopRoot;
                rightCity = originalRoot;
            }
            // If roots/cities are not the same, do weight balancing
            if(leftTopRoot != rightTopRoot){
                // Weight balancing, if right city's order is bigger
                if(edgesAndRoots[rightTopRoot] < edgesAndRoots[leftTopRoot]){
                    // Update length of right city
                    edgesAndRoots[rightTopRoot] = edgesAndRoots[rightTopRoot] + edgesAndRoots[leftTopRoot] - 1;
                    // Set the left city's root as the right city
                    edgesAndRoots[leftTopRoot] = rightTopRoot;
                }
                else{
                    // Update length of left city
                    edgesAndRoots[leftTopRoot] = edgesAndRoots[leftTopRoot] + edgesAndRoots[rightTopRoot] - 1;
                    // Set the right city's root as the left city
                    edgesAndRoots[rightTopRoot] = leftTopRoot;
                }
            }
        }
        int counter = 0;
        // Finds number of clusters
        for(int i = 1; i < edgesAndRoots.length; i++){
            if(edgesAndRoots[i] <= 0){
                counter++;
            }
        }
        // Formula to count total cost
        minCost = ((long) counter * hospitalCost) + ((long) highwayCost * (n - counter));
        return minCost;
    }
}

