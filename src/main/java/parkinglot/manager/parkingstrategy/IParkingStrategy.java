package parkinglot.manager.parkingstrategy;

import parkinglot.Ticket;
import parkinglot.Vehicle;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.List;

/**
 * 停车策略-接口
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 21:42
 */
public interface IParkingStrategy {
    // 选择一个停车仔去停车
    Ticket park(Vehicle vehicle, List<AbstractParkingBoy> parkingBoys);
}
