package parkinglot.manager.parkingstrategy;

import parkinglot.Ticket;
import parkinglot.Vehicle;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.Comparator;
import java.util.List;

/**
 * 停车策略3：选择首个剩余空间最少的停车仔去停
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 21:42
 */
public class ParkingStrategy3 implements IParkingStrategy {
    @Override
    public Ticket park(Vehicle vehicle, List<AbstractParkingBoy> parkingBoys) {
        AbstractParkingBoy parkingBoy = parkingBoys.stream()
                .filter(boy -> !boy.isFull())
                .min(Comparator.comparingInt(AbstractParkingBoy::getEmptyNum))
                .orElse(null);

        return parkingBoy.park(vehicle);
    }
}
