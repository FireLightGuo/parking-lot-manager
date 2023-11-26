package parkinglot.manager.expansion.impl;

import parkinglot.manager.expansion.ResourcePool;
import parkinglot.manager.expansion.IExpansionStrategy;
import parkinglot.parkingboy.IParkingBoy;

import java.util.Comparator;
import java.util.List;

/**
 * <h2>扩容策略二</h2>
 * 当所有的停车仔的停车场的总空置率 < 25%时扩容，给剩余剩余车位最少的停车仔弹一个车位，
 * 如果有多个停车仔都最少，则多个停车仔均需分配
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 23:05
 */
public class ExpansionStrategy2 implements IExpansionStrategy {
    @Override
    public boolean isMatchStrategy(List<IParkingBoy> parkingBoys) {
        return getTotalEmptyRate(parkingBoys) < 0.25;
    }

    private double getTotalEmptyRate(List<IParkingBoy> parkingBoys) {
        int totalEmptyNum = 0;
        int totalCapacity = 0;
        for (IParkingBoy parkingBoy : parkingBoys) {
            totalEmptyNum += parkingBoy.getEmptyNum();
            totalCapacity += parkingBoy.getCapacity();
        }
        return (double) totalEmptyNum / totalCapacity;
    }

    @Override
    public void expand(List<IParkingBoy> parkingBoys) {
        List<IParkingBoy> boysWithMinEmptyNum = getBoysWithMinEmptyNum(parkingBoys);
        for (IParkingBoy parkingBoy : boysWithMinEmptyNum) {
            if (!ResourcePool.isEmpty()) {
                break;
            }
            parkingBoy.addParkingLot(ResourcePool.pickParkingLot());
        }
    }

    // 获取剩余剩余车位最少的停车仔（可能同时有多个）
    private List<IParkingBoy> getBoysWithMinEmptyNum(List<IParkingBoy> parkingBoys) {
        IParkingBoy minBoy = parkingBoys.stream().min(Comparator.comparingInt(IParkingBoy::getEmptyNum)).get();
        return parkingBoys.stream().filter(boy -> boy.getEmptyNum() == minBoy.getEmptyNum()).toList();
    }
}
