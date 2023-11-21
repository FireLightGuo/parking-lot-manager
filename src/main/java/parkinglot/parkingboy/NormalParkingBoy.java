package parkinglot.parkingboy;

import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.Vehicle;

import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 0:31
 */
public class NormalParkingBoy extends AbstractParkingBoy {
    public NormalParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    /**
     * 普通停车仔：将车顺序停放到多个停车场
     */
    @Override
    public Ticket park(Vehicle vehicle) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isParkable()) {
                return parkingLot.park(vehicle);
            }
        }
        return null;
    }
}
