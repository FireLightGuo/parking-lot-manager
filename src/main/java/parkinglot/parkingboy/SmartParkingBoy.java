package parkinglot.parkingboy;

import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.Vehicle;

import java.util.Comparator;
import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 0:31
 */
public class SmartParkingBoy extends AbstractParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    /**
     * 聪明停车仔：将车停在【空车位】最多的停车场
     */
    @Override
    public Ticket park(Vehicle vehicle) {
        ParkingLot parkingLot = parkingLots.
                stream().max(Comparator.comparingInt(ParkingLot::getEmptyNum)).get();
        return parkingLot.park(vehicle);
    }
}
