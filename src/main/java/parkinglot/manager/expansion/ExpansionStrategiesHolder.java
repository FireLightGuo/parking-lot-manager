package parkinglot.manager.expansion;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import parkinglot.parkingboy.IParkingBoy;

import java.util.Collection;
import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/26 23:26
 */
@Component
public class ExpansionStrategiesHolder implements InitializingBean, ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static Collection<IExpansionStrategy> expansionStrategies;

    @Override
    public void afterPropertiesSet() throws Exception {
        expansionStrategies = applicationContext.getBeansOfType(IExpansionStrategy.class).values();
    }

    public IExpansionStrategy getExpansionStrategy(ExpansionStrategyEnum expansionStrategyEnum) {
        return applicationContext.getBean(expansionStrategyEnum.getExpansionStrategyClass());
    }

    // 执行扩容
    public static void doExpand(List<IParkingBoy> parkingBoys) {
        for (IExpansionStrategy expansionStrategy : expansionStrategies) {
            if (expansionStrategy.isMatchStrategy(parkingBoys)) {
                expansionStrategy.expand(parkingBoys);
                break;
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ExpansionStrategiesHolder.applicationContext = applicationContext;
    }
}
