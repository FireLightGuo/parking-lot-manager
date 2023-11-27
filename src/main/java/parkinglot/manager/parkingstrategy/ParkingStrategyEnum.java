package parkinglot.manager.parkingstrategy;

import parkinglot.manager.parkingstrategy.impl.ParkingStrategy3;
import parkinglot.manager.parkingstrategy.impl.ParkingStrategy4;

/**
 * @author GuoWeiLiang
 * @since 2023/11/27 23:55
 */
public enum ParkingStrategyEnum {
    S3(ParkingStrategy3.class),
    S4(ParkingStrategy4.class),
    ;
    private final Class<? extends IParkingStrategy> parkingStrategyClass;

    ParkingStrategyEnum(Class<? extends IParkingStrategy> parkingStrategyClass) {
        this.parkingStrategyClass = parkingStrategyClass;
    }

    public Class<? extends IParkingStrategy> getParkingStrategyClass() {
        return parkingStrategyClass;
    }
}
