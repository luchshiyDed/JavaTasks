package D6;

import D6.Entities.RespocesDTO.AirportsDTO;
import D6.Entities.RespocesDTO.CityDTO;
import D6.Entities.RespocesDTO.ScheduledDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@AllArgsConstructor
@RestController
@RequestMapping("/D6")
public class DataController {
    @GetMapping("/city")
    public Iterable<CityDTO> getCities() {
        return DataRepository.getInstance().getCities();
    }

    @GetMapping("/airport")
    public Iterable<AirportsDTO> getAirports() {
        return DataRepository.getInstance().getAirports();
    }

    @GetMapping("/city/{city_name}")
    public Iterable<?> getAirportsFromCity(@PathVariable String city_name) {
        return DataRepository.getInstance().getAirportsInCity(city_name);
    }

    @GetMapping("/airport/arrival/{airport_name}")
    public Iterable<ScheduledDTO> getArrivals(@PathVariable String airport_name) {
        return DataRepository.getInstance().getAirportArrivals(airport_name);
    }

    @GetMapping("/airport/departure/{airport_name}")
    public Iterable<ScheduledDTO> getDepartures(@PathVariable String airport_name) {
        return DataRepository.getInstance().getAirportDepartures(airport_name);
    }

    @GetMapping("/flight")
    public Iterable<?> getFlights(String source, String destination, Date departure, Date arrival, String tz, String seat_type) {
        return null;
    }

    @PutMapping("/booking")
    public ResponseEntity<?> book(String flight_no, String seat_type) {
        return null;
    }

    @PutMapping("/reg")
    public ResponseEntity<?> register(String flight_no, String ticket) {
        return null;
    }

}
