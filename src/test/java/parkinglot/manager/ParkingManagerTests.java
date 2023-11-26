package parkinglot.manager;

import org.junit.jupiter.api.Test;
import parkinglot.ParkingLot;
import parkinglot.parkingboy.IParkingBoy;
import parkinglot.parkingboy.impl.NormalParkingBoy;
import parkinglot.parkingboy.impl.SmartParkingBoy;
import parkinglot.parkingboy.impl.SuperParkingBoy;

import java.util.List;

/**
 * @author GuoWeiLiang
 * @since 2023/11/26 23:57
 */
public class ParkingManagerTests {
    @Test
    void testPark() {
        List<IParkingBoy> parkingBoys = List.of(
                new NormalParkingBoy(List.of(
                        new ParkingLot(2),
                        new ParkingLot(2)
                )),
                new SmartParkingBoy(List.of(
                        new ParkingLot(2),
                        new ParkingLot(2)
                )),
                new SuperParkingBoy(List.of(
                        new ParkingLot(2),
                        new ParkingLot(2)
                ))
        );

        ParkingManager parkingManager = new ParkingManager(parkingBoys);
    }
}
