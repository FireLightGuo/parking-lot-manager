package parkinglot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 0:29
 */
public class ParkingLot {
    private final int capacity;

    private final Map<Ticket, Vehicle> parkingSpaceMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpaceMap = new HashMap<>(capacity);
    }

    public boolean isParkable() {
        return getEmptyNum() > 0;
    }

    public int getCapacity() {
        return capacity;
    }

    // 停车
    public Ticket park(Vehicle vehicle) {
        if (!isParkable()) {
            throw new NoEnoughParkingSpaceException();
        }
        Ticket ticket = new Ticket();
        parkingSpaceMap.put(ticket, vehicle);
        return ticket;
    }

    // 取车
    public Vehicle getVehicle(Ticket ticket) {
        return parkingSpaceMap.get(ticket);
    }

    // 空车位数量
    public int getEmptyNum() {
        return capacity - parkingSpaceMap.size();
    }

    // 空置率
    public double getEmptyRate() {
        return (double) getEmptyNum() / getCapacity();
    }
}
