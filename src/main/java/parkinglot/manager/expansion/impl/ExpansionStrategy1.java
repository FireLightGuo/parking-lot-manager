package parkinglot.manager.expansion.impl;

import parkinglot.manager.expansion.ResourcePool;
import parkinglot.manager.expansion.IExpansionStrategy;
import parkinglot.parkingboy.IParkingBoy;

import java.util.List;

/**
 * <h2>扩容策略一</h2>
 * 当所有的停车仔都停满时扩容，给每一个停车仔都弹一个车位，
 * 如果剩余停车场的数量少于停车仔的数量，则顺序给停车仔分配停车场，直到分完为止
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 23:02
 */
public class ExpansionStrategy1 implements IExpansionStrategy {
    @Override
    public boolean isMatchStrategy(List<IParkingBoy> parkingBoys) {
        return parkingBoys.stream().allMatch(IParkingBoy::isFull);
    }

    @Override
    public void expand(List<IParkingBoy> parkingBoys) {
        for (IParkingBoy parkingBoy : parkingBoys) {
            if (!ResourcePool.isEmpty()) {
                break;
            }
            parkingBoy.addParkingLot(ResourcePool.pickParkingLot());
        }
    }
}
