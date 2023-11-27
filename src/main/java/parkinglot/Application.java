package parkinglot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parkinglot.manager.ParkingManager;
import parkinglot.manager.parkingstrategy.ParkingStrategiesHolder;
import parkinglot.manager.parkingstrategy.ParkingStrategyEnum;
import parkinglot.parkingboy.IParkingBoy;
import parkinglot.parkingboy.impl.NormalParkingBoy;

import java.util.List;
import java.util.Scanner;

/**
 * 启动类
 *
 * @author GuoWeiLiang
 * @since 2023/11/27 23:12
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        runConsole();
    }

    static void runConsole() {
        List<IParkingBoy> parkingBoys = List.of(
                new NormalParkingBoy(List.of(
                        new ParkingLot(1),
                        new ParkingLot(1)
                ))
        );
        ParkingManager parkingManager = new ParkingManager(parkingBoys);
        Scanner scanner = new Scanner(System.in);
        System.out.println("[p:(park)] or [r:(retrieve)] or [q:(quit)]: ");
        while (scanner.hasNext()) {
            System.out.println("[p:(park)] or [r:(retrieve)] or [q:(quit)]: ");
            String word = scanner.next();
            if ("q".equals(word)) {
                break;
            }
            if ("p".equals(word)) {
                Ticket ticket = parkingManager.park(new Vehicle(), ParkingStrategiesHolder.getParkingStrategy(ParkingStrategyEnum.S3));
                System.out.println(ticket);
            }
        }
    }
}
