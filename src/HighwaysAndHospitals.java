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
        int minCost = 0;
        // Idea: Find which cities have a city in common and build a hospital in that city and have the other cities connect to it
        int sortedCities[][] = new int[cities.length][2];
        // Separate cities in order to see which ones are connected and which are not
        // Find most common city
        int costOnlyHospitals = n * hospitalCost;
        for(int i = 0; i < cities.length; i++){
            for(int j = 0; j < cities[0].length; j++){
                sortedCities[i][j] = cities[i][j];
            }
        }
        int temp = 0;
        int tempTwo = 0;
        // sort the cities from smallest to largest using the first element
        // Bubble sort (can probably change this later for a more efficient method
        for(int i = 1; i < cities.length; i++){
            for(int j = 0; j < cities.length - i; j++){
                if(sortedCities[j][0] > sortedCities[j + 1][0]){
                    // Swap
                    temp = sortedCities[j][0];
                    tempTwo = sortedCities[j][1];
                    sortedCities[j][0] = sortedCities[j + 1][0];
                    sortedCities[j][1] = sortedCities[j + 1][1];
                    sortedCities[j + 1][0] = temp;
                    sortedCities[j + 1][1] = tempTwo;
                }
            }
        }
        // Cut of the array into sections
        // Situation for when there is only 2 cities
        if(n == 2){
            minCost = highwayCost + hospitalCost;
            if(minCost > costOnlyHospitals){
                return costOnlyHospitals;
            }
        }
        // Debugging
        for(int i = 0; i < sortedCities.length; i++){
            System.out.println(sortedCities[i][0] + ", " + sortedCities[i][1]);
        }
        // We can probably use some sort of sorting algorithm to do this
        // Also im assuming some these have so that it might be cheaper to just build a hospital in every city so I have to figure out how to do that
        // I think it would also be beneficial if we can somehow separate the cities because we know some of them are not connected
        // After we figure out the cheapest way to build using highways, we compare to if we were to only use cities to see if it is cheaper
        if(minCost > costOnlyHospitals){
            return costOnlyHospitals;
        }
        return minCost;
    }
}
