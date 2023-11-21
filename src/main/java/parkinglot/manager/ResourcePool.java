package parkinglot.manager;

import parkinglot.ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 21:43
 */
public class ResourcePool {
    private static List<ParkingLot> parkingLots = new ArrayList<>(Arrays.asList(
            new ParkingLot(10),
            new ParkingLot(10),
            new ParkingLot(10)
    ));

    public static ParkingLot pickParkingLot() {
        return null;
    }

    public static boolean isEmpty() {
        return false;
    }
}
