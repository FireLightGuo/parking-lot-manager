package parkinglot.parkingboy.impl;

import parkinglot.ParkingLot;
import parkinglot.parkingboy.AbstractParkingBoy;

import java.util.List;
import java.util.Optional;

/**
 * 普通停车仔：将车顺序停放到多个停车场
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 0:31
 */
public class NormalParkingBoy extends AbstractParkingBoy {
    public NormalParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    protected Optional<ParkingLot> chooseParkingLotForPark() {
        return parkingLots.stream()
                .filter(ParkingLot::isParkable)
                .findFirst();
    }
}
