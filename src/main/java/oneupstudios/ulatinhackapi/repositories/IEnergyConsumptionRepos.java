package oneupstudios.ulatinhackapi.repositories;

import oneupstudios.ulatinhackapi.entities.EnergyConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IEnergyConsumptionRepos extends JpaRepository<EnergyConsumption,Long> {
    @Query("SELECT e FROM EnergyConsumption e " +
            "WHERE e.customer.customerId = :id")
    List<EnergyConsumption> getAllByCustomerId(@Param("id") long id);

    @Query("SELECT e FROM EnergyConsumption e " +
            "WHERE e.customer.customerType = :type")
    List<EnergyConsumption> getAllByCustomerType(@Param("type") String type);

    @Query("SELECT e FROM EnergyConsumption e " +
            "WHERE e.recordDateTime BETWEEN :start AND :end")
    List<EnergyConsumption> getBetweenDates(@Param("start") LocalDateTime from, @Param("end") LocalDateTime to);
}
