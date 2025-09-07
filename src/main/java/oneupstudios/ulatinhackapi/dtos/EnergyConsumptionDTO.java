package oneupstudios.ulatinhackapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EnergyConsumptionDTO {
    private Long consumptionId;
    private Long customerId;
    private LocalDateTime recordDateTime;
    private BigDecimal consumption_kwh;
    private BigDecimal reactive_kvarh;
    private BigDecimal voltage;
    private BigDecimal currentA;
    private BigDecimal costUSD;
    private BigDecimal co2Emisions;
}
