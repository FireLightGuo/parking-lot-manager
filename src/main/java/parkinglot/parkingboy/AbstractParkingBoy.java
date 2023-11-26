package parkinglot.parkingboy;

import parkinglot.exception.NoEnoughParkingSpotException;
import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.Vehicle;

import java.util.List;
import java.util.Optional;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 0:30
 */
public abstract class AbstractParkingBoy implements IParkingBoy {
    protected List<ParkingLot> parkingLots;

    public AbstractParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }


    @Override
    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    @Override
    public boolean isFull() {
        return getEmptyNum() == 0;
    }

    @Override
    public int getEmptyNum() {
        int emptyNum = 0;
        for (ParkingLot parkingLot : parkingLots) {
            emptyNum += parkingLot.getEmptyNum();
        }
        return emptyNum;
    }

    @Override
    public int getCapacity() {
        int capacity = 0;
        for (ParkingLot parkingLot : parkingLots) {
            capacity += parkingLot.getCapacity();
        }
        return capacity;
    }

    @Override
    public double getEmptyRate() {
        return (double) getEmptyNum() / getCapacity();
    }

    /**
     * 停车
     *
     * @param vehicle 车
     * @return 停车票 如果车位已满，则返回null
     */
    @Override
    public Ticket park(Vehicle vehicle) {
        Optional<ParkingLot> parkingLot = chooseParkingLotForPark();
        if (parkingLot.isEmpty()) {
            throw new NoEnoughParkingSpotException();
        }
        return parkingLot.get().park(vehicle);
    }

    protected abstract Optional<ParkingLot> chooseParkingLotForPark();
}
