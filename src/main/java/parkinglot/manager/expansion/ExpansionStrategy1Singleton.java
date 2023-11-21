package parkinglot.manager.expansion;

import parkinglot.manager.ResourcePool;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 23:02
 */
public class ExpansionStrategy1Singleton extends AbstractExpansionStrategy {
    public static final ExpansionStrategy1Singleton instance = new ExpansionStrategy1Singleton();

    @Override
    protected void register() {
        expansionStrategies.add(instance);
    }

    @Override
    public boolean isMatchStrategy(List<AbstractParkingBoy> parkingBoys) {
        return parkingBoys.stream().allMatch(AbstractParkingBoy::isFull);
    }

    /*
        扩容策略一：
        当所有的停车仔都停满时扩容，给每一个停车仔都弹一个车位，
        如果剩余停车场的数量少于停车仔的数量，则顺序给停车仔分配停车场，直到分完为止
     */
    @Override
    public void expand(List<AbstractParkingBoy> parkingBoys) {
        for (AbstractParkingBoy parkingBoy : parkingBoys) {
            if (!ResourcePool.isEmpty()) {
                break;
            }
            parkingBoy.addParkingLot(ResourcePool.pickParkingLot());
        }
    }
}
