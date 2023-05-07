package D6.Entities.RequestsDTO;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class FlightDTO {
    String departure;
    String arrival;
    LocalDateTime firstDate;
    LocalDateTime secondDate;
    String fare;

    public FlightDTO(String departure, String arrival, LocalDateTime firstDate, LocalDateTime secondDate, String fare) {
        this.departure = departure;
        this.arrival = arrival;
        this.firstDate = firstDate;
        this.secondDate = secondDate;
        this.fare = fare;
    }

    Integer points=3;
}
