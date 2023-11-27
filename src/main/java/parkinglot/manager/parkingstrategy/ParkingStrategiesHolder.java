package parkinglot.manager.parkingstrategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author GuoWeiLiang
 * @since 2023/11/26 23:42
 */
@Component
public class ParkingStrategiesHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static IParkingStrategy getParkingStrategy(ParkingStrategyEnum parkingStrategyEnum) {
        return applicationContext.getBean(parkingStrategyEnum.getParkingStrategyClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ParkingStrategiesHolder.applicationContext = applicationContext;
    }
}
