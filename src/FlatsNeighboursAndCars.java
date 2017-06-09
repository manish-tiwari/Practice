import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manish on 09-06-2017.
 */
public class FlatsNeighboursAndCars {
    static int[][] nCarsAtAppt = new int[16][16];
    static Map<String, Integer> nCarsAtApptMap = new HashMap<>();

    public static void main(String[] args) {
        allotCarsToEveryAppartment();
        Map<String, Integer> appartmentAndNeighboursTotalCarsMap = findNeighboursTotalCars();
        int totalCarsInNeighbours = 0;
        String flatWithMostCarsInNeighbours = null;
        for (String appartment :
                appartmentAndNeighboursTotalCarsMap.keySet()) {
            if (totalCarsInNeighbours < appartmentAndNeighboursTotalCarsMap.get(appartment)) {
                totalCarsInNeighbours = appartmentAndNeighboursTotalCarsMap.get(appartment);
                flatWithMostCarsInNeighbours = appartment;
            }
        }
        System.out.println("Hurray...\n\nFlat with most no. of cars in neighbours is " + flatWithMostCarsInNeighbours + " with total of " + totalCarsInNeighbours + " !!!");

    }

    private static Map<String, Integer> findNeighboursTotalCars() {
        Map<String, Integer> appartmentToNeighboursTotalCarsMapping = new HashMap<>();
        for (String appt :
                nCarsAtApptMap.keySet()) {
            int xCordinate = Integer.parseInt(appt.substring(0, 1));
            int yCordinate = Integer.parseInt(appt.substring(1, 2));
            List<String> neighbours = findNeigbours(xCordinate, yCordinate);

            int totalCarsInNeighbour = 0;
            for (String neighbour :
                    neighbours) {
                if (nCarsAtApptMap.containsKey(neighbour)) {
                    totalCarsInNeighbour += nCarsAtApptMap.get(neighbour);
                }
            }
            appartmentToNeighboursTotalCarsMapping.put(appt, totalCarsInNeighbour);


        }
        return appartmentToNeighboursTotalCarsMapping;
    }

    private static List<String> findNeigbours(int x, int y) {
        List<String> neighbours = new ArrayList<>();
        neighbours.add((String.valueOf(x + 1)) + (String.valueOf(y)));
        neighbours.add((String.valueOf(x)) + (String.valueOf(y + 1)));
        neighbours.add((String.valueOf(x + 1)) + (String.valueOf(y + 1)));
        neighbours.add((String.valueOf(x - 1)) + (String.valueOf(y)));
        neighbours.add((String.valueOf(x)) + (String.valueOf(y - 1)));
        neighbours.add((String.valueOf(x - 1)) + (String.valueOf(y - 1)));
        neighbours.add((String.valueOf(x + 1)) + (String.valueOf(y - 1)));
        neighbours.add((String.valueOf(x - 1)) + (String.valueOf(y + 1)));
        return neighbours;
    }

    private static void allotCarsToEveryAppartment() {

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int nCars = Integer.parseInt(String.valueOf(Math.random() * 10000000).substring(0, 2)) + 1;
                String apptAddress = String.valueOf(row) + String.valueOf(col);
                System.out.println("Cars at appt address " + apptAddress + " is -->" + nCars);
                nCarsAtApptMap.put(apptAddress, nCars);
            }
        }
        System.out.println("Total no. of appartmnts is " + nCarsAtApptMap.size());
    }


}

