package parkinglot.manager.expansion;

import parkinglot.manager.expansion.impl.ExpansionStrategy1;
import parkinglot.manager.expansion.impl.ExpansionStrategy2;
import parkinglot.parkingboy.IParkingBoy;

import java.util.List;
import java.util.Set;

/**
 * @author GuoWeiLiang
 * @since 2023/11/26 23:26
 */
public abstract class ExpansionStrategiesHolder {
    private static final Set<IExpansionStrategy> EXPANSION_STRATEGIES = Set.of(
            new ExpansionStrategy1(),
            new ExpansionStrategy2()
    );

    // 执行扩容
    public static void doExpand(List<IParkingBoy> parkingBoys) {
        for (IExpansionStrategy expansionStrategy : EXPANSION_STRATEGIES) {
            if (expansionStrategy.isMatchStrategy(parkingBoys)) {
                expansionStrategy.expand(parkingBoys);
                break;
            }
        }
    }
}
