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

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Checks if it is cheaper to buy hospitals in every city
        if (hospitalCost < highwayCost) {
            return hospitalCost * n;
        }
        long minCost = 0;
        int rootOne = 0;
        int rootTwo = 0;
        // Array of cities where index = node and value = root
        int edgesAndRoots[] = new int[n + 1];
        // Set all edges equal to eachother
        for(int i = 1; i < edgesAndRoots.length; i++){
            edgesAndRoots[i] = i;
        }
        // For each node
        for(int i = 0; i < cities.length; i++){
            // Check root of left city
            rootOne = edgesAndRoots[cities[i][0]];
            // Check root of right city
            rootTwo = edgesAndRoots[cities[i][1]];
            // Checks if we need to check the roots of the rootOne
            if(rootOne != edgesAndRoots[cities[i][1]]){
                rootOne = getFinalRoot(edgesAndRoots[rootOne], rootOne, edgesAndRoots);
            }
            // Checks if we need to check the roots of the rootTwo
            if(rootTwo != edgesAndRoots[cities[i][1]]){
                rootTwo = getFinalRoot(edgesAndRoots[rootTwo], rootTwo, edgesAndRoots);
            }
            // If roots are not the same, make 1st city root of 2nd city
            if(rootOne != rootTwo){
                edgesAndRoots[cities[i][1]] = cities[i][0];
            }
        }
        int counter = 0;
        // Counts sub-graphs by counting which nodes are equal to themselves
        for(int i = 1; i < edgesAndRoots.length; i++){
            System.out.println("node: " + i + ", root: " + edgesAndRoots[i]);
            if(edgesAndRoots[i] == i){
                counter++;
            }
        }

        System.out.println(counter);
        minCost = (counter * hospitalCost) + (highwayCost * (n - counter));
        return minCost;
    }
    private static int getFinalRoot(int root, int city, int edgesAndRoots[]){
        int rootCopy = root;
        int cityCopy = city;
        while(rootCopy != cityCopy){
            cityCopy = rootCopy;
            rootCopy = edgesAndRoots[cityCopy];
        }
        return root;
    }
}

