package parkinglot;

/**
 * 停车票
 *
 * @author GuoWeiLiang
 * @since 2023/11/21 0:28
 */
public class Ticket {
    // 所属停车场
    private final ParkingLot parkingLot;

    public Ticket(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
