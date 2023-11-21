package parkinglot.manager.expansion;

import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author GuoWeiLiang
 * @since 2023/11/21 22:56
 */
public abstract class AbstractExpansionStrategy {
    protected static final Set<AbstractExpansionStrategy> expansionStrategies =
            new HashSet<>();

    protected abstract void register();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractExpansionStrategy other) {
            return this.getClass().equals(other.getClass());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    public static void doExpand(List<AbstractParkingBoy> parkingBoys) {
        for (AbstractExpansionStrategy expansionStrategy : expansionStrategies) {
            if (expansionStrategy.isMatchStrategy(parkingBoys)) {
                expansionStrategy.expand(parkingBoys);
                break;
            }
        }
    }

    protected abstract boolean isMatchStrategy(List<AbstractParkingBoy> parkingBoys);

    protected abstract void expand(List<AbstractParkingBoy> parkingBoys);
}
