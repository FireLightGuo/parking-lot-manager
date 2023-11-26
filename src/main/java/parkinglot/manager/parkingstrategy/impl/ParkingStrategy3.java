package parkinglot.manager.parkingstrategy.impl;

import parkinglot.exception.NoEnoughParkingSpotException;
import parkinglot.Ticket;
import parkinglot.Vehicle;
import parkinglot.manager.parkingstrategy.IParkingStrategy;
import parkinglot.parkingboy.IParkingBoy;

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
    public Ticket park(Vehicle vehicle, List<IParkingBoy> parkingBoys) {
        IParkingBoy parkingBoy = parkingBoys.stream()
                .filter(boy -> !boy.isFull())
                .min(Comparator.comparingInt(IParkingBoy::getEmptyNum))
                .orElseThrow(NoEnoughParkingSpotException::new);

        return parkingBoy.park(vehicle);
    }
}
