package parkinglot.manager.expansion;

import parkinglot.parkingboy.IParkingBoy;

import java.util.List;

/**
 * 扩容策略
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 22:56
 */
public interface IExpansionStrategy {
    // 判断是否满足扩容策略
    boolean isMatchStrategy(List<IParkingBoy> parkingBoys);

    // 执行扩容
    void expand(List<IParkingBoy> parkingBoys);
}
