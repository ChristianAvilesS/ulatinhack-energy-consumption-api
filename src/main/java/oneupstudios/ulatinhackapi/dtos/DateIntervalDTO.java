package oneupstudios.ulatinhackapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DateIntervalDTO {
    private LocalDateTime from;
    private LocalDateTime to;
}
