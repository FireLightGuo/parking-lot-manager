package parkinglot.parkingboy;

import parkinglot.exception.NoEnoughParkingSpotException;
import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.Vehicle;

import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/26 23:13
 */
public interface IParkingBoy {
    /**
     * 停车
     *
     * @param vehicle 车
     * @return 停车票
     * @throws NoEnoughParkingSpotException 如果车位已满
     */
    Ticket park(Vehicle vehicle) throws NoEnoughParkingSpotException;

    List<ParkingLot> getParkingLots();

    void addParkingLot(ParkingLot parkingLot);

    boolean isFull();

    int getEmptyNum();

    int getCapacity();

    double getEmptyRate();
}
