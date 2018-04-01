package phan.spring.rest.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import phan.spring.rest.control.Control;
import phan.spring.rest.control.ControlRepository;
import phan.spring.rest.device.Device;
import phan.spring.rest.device.DeviceRepository;
import phan.spring.rest.room.Room;
import phan.spring.rest.room.RoomRepository;
import phan.spring.rest.user.User;
import phan.spring.rest.user.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final ControlRepository controls;
    private final UserRepository users;
    private final RoomRepository rooms;
    private final DeviceRepository devices;

    @Autowired
    public DatabaseLoader(ControlRepository controls, UserRepository users, RoomRepository rooms, DeviceRepository
            devices) {
        this.controls = controls;
        this.users = users;
        this.rooms = rooms;
        this.devices = devices;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> userList = Arrays.asList(
                new User("admin", "User1", new String[]{"ROLE_USER", "ROLE_ADMIN"}, "password"),
                new User("admin2", "User2", new String[]{"ROLE_USER", "ROLE_ADMIN"}, "password"),
                new User("user", "User3", new String[]{"ROLE_USER"}, "password")

        );
        users.save(userList);

        String[] roomChoice = {
                "Kitchen",
                "Living Room",
                "Garage",
                "Dining Room",
                "Bed Room"
        };

        List<Room> roomList = new ArrayList<>();
        List<Device> deviceList = new ArrayList<>();
        List<Control> controlList = new ArrayList<>();

        IntStream.range(1, 20)
                .forEach(i -> {
                    String room = roomChoice[i % roomChoice.length];

                    Room r = new Room(room, (int) (Math.random() * 1000));
                    Device d = new Device("Device " + i);
                    Control c = new Control("Control " + i);

                    int randomUser = (int) (Math.random() * userList.size());

                    r.addDevice(d);
                    r.addAdministrator(userList.get(randomUser));
                    d.addControl(c);

                    roomList.add(r);
                    deviceList.add(d);
                    controlList.add(c);
                });

        rooms.save(roomList);
        devices.save(deviceList);
        controls.save(controlList);
    }
}
