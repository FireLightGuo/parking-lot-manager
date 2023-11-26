package parkinglot.manager.parkingstrategy;

import parkinglot.manager.parkingstrategy.impl.ParkingStrategy3;
import parkinglot.manager.parkingstrategy.impl.ParkingStrategy4;

/**
 * @author GuoWeiLiang
 * @since 2023/11/26 23:42
 */
public abstract class ParkingStrategiesHolder {
    public static final IParkingStrategy S3 = new ParkingStrategy3();

    public static final IParkingStrategy S4 = new ParkingStrategy4();
}
