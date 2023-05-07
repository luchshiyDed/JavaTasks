package D6.Entities.RespocesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class ScheduledDTO {
    String city_name;
    String airport_name;
    String flight_no;
    OffsetDateTime date;
    LocalDateTime date_local;

}
