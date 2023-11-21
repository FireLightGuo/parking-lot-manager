package parkinglot.manager;

import parkinglot.NoEnoughParkingSpaceException;
import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkinglot.Vehicle;
import parkinglot.manager.expansion.AbstractExpansionStrategy;
import parkinglot.manager.parkingstrategy.IParkingStrategy;
import parkinglot.manager.parkingstrategy.ParkingStrategy3;
import parkinglot.manager.parkingstrategy.ParkingStrategy4;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 0:31
 */
public class ParkingManager {
    public static final IParkingStrategy S3 = new ParkingStrategy3();

    public static final IParkingStrategy S4 = new ParkingStrategy4();

    private final List<AbstractParkingBoy> parkingBoys;

    public ParkingManager(List<AbstractParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public Ticket park(Vehicle vehicle) {
        return park(vehicle, S3);
    }

    public Ticket park(Vehicle vehicle, IParkingStrategy parkingStrategy) {
        if (isAllBoyFull() && ResourcePool.isEmpty()) {
            throw new NoEnoughParkingSpaceException();
        }
        Ticket ticket = parkingStrategy.park(vehicle, parkingBoys);
        /*
            扩容策略：
            当manager停完车后，会检查一下是否满足当前的扩容策略，同一时刻只会有一个扩容策略会触发
         */
        AbstractExpansionStrategy.doExpand(parkingBoys);
        return ticket;
    }

    private boolean isAllBoyFull() {
        return parkingBoys.stream().allMatch(AbstractParkingBoy::isFull);
    }

    private double getTotalEmptyRate() {
        int totalEmptyNum = 0;
        int totalCapacity = 0;
        for (AbstractParkingBoy parkingBoy : parkingBoys) {
            totalEmptyNum += parkingBoy.getEmptyNum();
            totalCapacity += parkingBoy.getCapacity();
        }
        return (double) totalEmptyNum / totalCapacity;
    }

    public Vehicle getVehicle(Ticket ticket) {
        for (AbstractParkingBoy parkingBoy : parkingBoys) {
            for (ParkingLot parkingLot : parkingBoy.getParkingLots()) {
                Vehicle vehicle = parkingLot.getVehicle(ticket);
                if (vehicle != null) {
                    return vehicle;
                }
            }
        }
        return null;
    }
}
