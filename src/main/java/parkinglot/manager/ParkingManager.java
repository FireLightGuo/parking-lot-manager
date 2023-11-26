package parkinglot.manager;

import parkinglot.exception.NoEnoughParkingSpotException;
import parkinglot.Ticket;
import parkinglot.Vehicle;
import parkinglot.manager.expansion.ExpansionStrategiesHolder;
import parkinglot.manager.expansion.ResourcePool;
import parkinglot.manager.parkingstrategy.IParkingStrategy;
import parkinglot.parkingboy.IParkingBoy;

import java.util.List;

/**
 * 停车场经理
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 0:31
 */
public class ParkingManager {
    private final List<IParkingBoy> parkingBoys;

    public ParkingManager(List<IParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    // 停车
    public Ticket park(Vehicle vehicle, IParkingStrategy parkingStrategy) {
        // 车位已满 且 资源池已空
        if (isAllBoyFull() && ResourcePool.isEmpty()) {
            throw new NoEnoughParkingSpotException();
        }
        Ticket ticket = parkingStrategy.park(vehicle, parkingBoys);

        // 当manager停完车后，会检查一下是否满足当前的扩容策略，同一时刻只会有一个扩容策略会触发
        ExpansionStrategiesHolder.doExpand(parkingBoys);
        return ticket;
    }

    // 取车
    public Vehicle retrieveVehicle(Ticket ticket) {
        return ticket.getParkingLot().retrieveVehicle(ticket);
    }

    private boolean isAllBoyFull() {
        return parkingBoys.stream().allMatch(IParkingBoy::isFull);
    }
}
