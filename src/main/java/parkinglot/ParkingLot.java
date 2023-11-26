package parkinglot;

import parkinglot.exception.NoEnoughParkingSpotException;

import java.util.HashMap;
import java.util.Map;

/**
 * 停车场
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 0:29
 */
public class ParkingLot {
    // 停车场容量
    private final int capacity;

    // 停车位 map
    private final Map<Ticket, Vehicle> parkingSpotMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpotMap = new HashMap<>(capacity);
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
            throw new NoEnoughParkingSpotException();
        }
        Ticket ticket = new Ticket(this);
        parkingSpotMap.put(ticket, vehicle);
        return ticket;
    }

    // 取车
    public Vehicle retrieveVehicle(Ticket ticket) {
        return parkingSpotMap.remove(ticket);
    }

    // 空车位数量
    public int getEmptyNum() {
        return capacity - parkingSpotMap.size();
    }

    // 空置率
    public double getEmptyRate() {
        return (double) getEmptyNum() / capacity;
    }
}
