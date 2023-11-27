package parkinglot.manager.expansion;

import parkinglot.manager.expansion.impl.ExpansionStrategy1;
import parkinglot.manager.expansion.impl.ExpansionStrategy2;

/**
 * @author GuoWeiLiang
 * @since 2023/11/27 23:45
 */
public enum ExpansionStrategyEnum {
    S1(ExpansionStrategy1.class),
    S2(ExpansionStrategy2.class),
    ;

    private final Class<? extends IExpansionStrategy> expansionStrategyClass;

    ExpansionStrategyEnum(Class<? extends IExpansionStrategy> expansionStrategyClass) {
        this.expansionStrategyClass = expansionStrategyClass;
    }

    public Class<? extends IExpansionStrategy> getExpansionStrategyClass() {
        return expansionStrategyClass;
    }
}
