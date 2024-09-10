/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
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
        // Find most common city
        for(int i = 0; i < cities.length; i++){
            for(int j = 0; j < cities.length[0]; j++){

            }
        }
        // We can probably use some sort of sorting algorithm to do this
        // Also im assuming some these have so that it might be cheaper to just build a hospital in every city so I have to figure out how to do that
        // I think it would also be beneficial if we can somehow separate the cities because we know some of them are not connected
        // After we figure out the cheapest way to build using highways, we compare to if we were to only use cities to see if it is cheaper
        int costOnlyHospitals = n * hospitalCost;


        return 0;
    }
}
