package parkinglot.parkingboy;

import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.Vehicle;

import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 0:30
 */
public abstract class AbstractParkingBoy {
    List<ParkingLot> parkingLots;

    public AbstractParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public boolean isFull() {
        return getEmptyNum() == 0;
    }

    public int getEmptyNum() {
        int emptyNum = 0;
        for (ParkingLot parkingLot : parkingLots) {
            emptyNum += parkingLot.getEmptyNum();
        }
        return emptyNum;
    }

    public int getCapacity() {
        int capacity = 0;
        for (ParkingLot parkingLot : parkingLots) {
            capacity += parkingLot.getCapacity();
        }
        return capacity;
    }

    public double getEmptyRate() {
        return (double) getEmptyNum() / getCapacity();
    }

    /**
     * 停车
     *
     * @param vehicle 车
     * @return 停车票 如果车位已满，则返回null
     */
    public abstract Ticket park(Vehicle vehicle);
}
