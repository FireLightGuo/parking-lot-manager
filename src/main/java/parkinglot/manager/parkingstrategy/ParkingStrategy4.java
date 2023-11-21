package parkinglot.manager.parkingstrategy;

import parkinglot.Ticket;
import parkinglot.Vehicle;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.Comparator;
import java.util.List;

/**
 * 停车策略4：选择空置率最高的停车仔去停
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 21:43
 */
public class ParkingStrategy4 implements IParkingStrategy {
    @Override
    public Ticket park(Vehicle vehicle, List<AbstractParkingBoy> parkingBoys) {
        AbstractParkingBoy parkingBoy = parkingBoys.stream()
                .filter(boy -> !boy.isFull())
                .max(Comparator.comparingDouble(AbstractParkingBoy::getEmptyRate))
                .orElse(null);
        return parkingBoy.park(vehicle);
    }
}
