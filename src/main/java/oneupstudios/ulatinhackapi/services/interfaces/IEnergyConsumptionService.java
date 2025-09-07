package oneupstudios.ulatinhackapi.services.interfaces;

import oneupstudios.ulatinhackapi.entities.EnergyConsumption;

import java.time.LocalDateTime;
import java.util.List;

public interface IEnergyConsumptionService {
    List<EnergyConsumption> get();
    void save(EnergyConsumption energyConsumption);
    void saveAll(List<EnergyConsumption> list);
    EnergyConsumption getEnergyConsumption(long id);
    List<EnergyConsumption> getAllByCustomerId(long id);
    List<EnergyConsumption> getAllByCustomerType(String type);
    List<EnergyConsumption> getBetweenDates(LocalDateTime from, LocalDateTime to);
}
