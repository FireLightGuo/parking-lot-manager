package parkinglot.manager.expansion;

import parkinglot.manager.ResourcePool;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.Comparator;
import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 23:05
 */
public class ExpansionStrategy2Singleton extends AbstractExpansionStrategy {
    public static final ExpansionStrategy2Singleton instance = new ExpansionStrategy2Singleton();

    @Override
    protected void register() {
        expansionStrategies.add(instance);
    }

    @Override
    public boolean isMatchStrategy(List<AbstractParkingBoy> parkingBoys) {
        return getTotalEmptyRate(parkingBoys) < 0.25;
    }

    private double getTotalEmptyRate(List<AbstractParkingBoy> parkingBoys) {
        int totalEmptyNum = 0;
        int totalCapacity = 0;
        for (AbstractParkingBoy parkingBoy : parkingBoys) {
            totalEmptyNum += parkingBoy.getEmptyNum();
            totalCapacity += parkingBoy.getCapacity();
        }
        return (double) totalEmptyNum / totalCapacity;
    }

    /*
       扩容策略二：
       当所有的停车仔的停车场的总空置率 < 25%，给剩余剩余车位最少的停车仔弹一个车位
       如果有多个停车仔都最少，则多个停车仔均需分配
    */
    @Override
    public void expand(List<AbstractParkingBoy> parkingBoys) {
        for (AbstractParkingBoy parkingBoy : getBoysWithMinEmptyNum(parkingBoys)) {
            if (!ResourcePool.isEmpty()) {
                break;
            }
            parkingBoy.addParkingLot(ResourcePool.pickParkingLot());
        }
    }

    // 获取剩余剩余车位最少的停车仔（可能同时有多个）
    private List<AbstractParkingBoy> getBoysWithMinEmptyNum(List<AbstractParkingBoy> parkingBoys) {
        AbstractParkingBoy minBoy = parkingBoys.stream().min(Comparator.comparingInt(AbstractParkingBoy::getEmptyNum)).get();
        return parkingBoys.stream().filter(boy -> boy.getEmptyNum() == minBoy.getEmptyNum()).toList();
    }
}
