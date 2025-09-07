package oneupstudios.ulatinhackapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class EnergyConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumptionId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private LocalDateTime recordDateTime;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal consumption_kwh;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal reactive_kvarh;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal voltage;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal currentA;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costUSD;

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal co2Emisions;
}
