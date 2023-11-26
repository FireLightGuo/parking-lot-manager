package parkinglot.parkingboy.impl;

import parkinglot.ParkingLot;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 聪明停车仔：将车停在【空车位】最多的停车场
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 0:31
 */
public class SmartParkingBoy extends AbstractParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    protected Optional<ParkingLot> chooseParkingLotForPark() {
        return parkingLots.stream()
                .filter(ParkingLot::isParkable)
                .max(Comparator.comparingInt(ParkingLot::getEmptyNum));
    }
}
