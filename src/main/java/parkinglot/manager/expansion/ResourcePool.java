package parkinglot.manager.expansion;

import parkinglot.ParkingLot;
import parkinglot.exception.ResourcePoolEmptyException;

import java.util.LinkedList;
import java.util.List;

/**
 * 资源池
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 21:43
 */
public abstract class ResourcePool {
    private static LinkedList<ParkingLot> parkingLots = new LinkedList<>();

    // 设置资源池数据
    public static void setParkingLots(List<Integer> parkingLotCapacities) {
        LinkedList<ParkingLot> list = new LinkedList<>();
        for (Integer capacity : parkingLotCapacities) {
            list.add(new ParkingLot(capacity));
        }
        ResourcePool.parkingLots = list;
    }

    public static ParkingLot pickParkingLot() {
        if (isEmpty()) {
            throw new ResourcePoolEmptyException();
        }
        return parkingLots.removeFirst();
    }

    public static boolean isEmpty() {
        return parkingLots.isEmpty();
    }
}
