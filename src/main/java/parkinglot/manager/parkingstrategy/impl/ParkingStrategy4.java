package parkinglot.manager.parkingstrategy.impl;

import org.springframework.stereotype.Component;
import parkinglot.exception.NoEnoughParkingSpotException;
import parkinglot.Ticket;
import parkinglot.Vehicle;
import parkinglot.manager.parkingstrategy.IParkingStrategy;
import parkinglot.parkingboy.IParkingBoy;

import java.util.Comparator;
import java.util.List;

/**
 * 停车策略4：选择空置率最高的停车仔去停
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 21:43
 */
@Component
public class ParkingStrategy4 implements IParkingStrategy {
    @Override
    public Ticket park(Vehicle vehicle, List<IParkingBoy> parkingBoys) {
        IParkingBoy parkingBoy = parkingBoys.stream()
                .filter(boy -> !boy.isFull())
                .max(Comparator.comparingDouble(IParkingBoy::getEmptyRate))
                .orElseThrow(NoEnoughParkingSpotException::new);

        return parkingBoy.park(vehicle);
    }
}
