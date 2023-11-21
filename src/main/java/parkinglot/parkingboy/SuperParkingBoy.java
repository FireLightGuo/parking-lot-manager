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
public class SuperParkingBoy extends AbstractParkingBoy {
    public SuperParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    /**
     * 超级停车仔：将车停在【空置率】最高的停车场
     */
    @Override
    public Ticket park(Vehicle vehicle) {
        ParkingLot parkingLot = parkingLots
                .stream().max(Comparator.comparingDouble(ParkingLot::getEmptyRate)).get();
        return parkingLot.park(vehicle);
    }
}
