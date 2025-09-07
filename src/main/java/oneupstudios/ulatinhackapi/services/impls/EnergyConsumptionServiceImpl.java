package oneupstudios.ulatinhackapi.services.impls;

import oneupstudios.ulatinhackapi.entities.EnergyConsumption;
import oneupstudios.ulatinhackapi.repositories.IEnergyConsumptionRepos;
import oneupstudios.ulatinhackapi.services.interfaces.IEnergyConsumptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnergyConsumptionServiceImpl implements IEnergyConsumptionService {

    private final IEnergyConsumptionRepos repos;

    public EnergyConsumptionServiceImpl(IEnergyConsumptionRepos repos) {
        this.repos = repos;
    }

    @Override
    public List<EnergyConsumption> get() {
        return repos.findAll();
    }

    @Override
    public void save(EnergyConsumption energyConsumption) {
        repos.save(energyConsumption);
    }

    @Override
    public void saveAll(List<EnergyConsumption> list) {
        repos.saveAll(list);
    }

    @Override
    public EnergyConsumption getEnergyConsumption(long id) {
        return repos.findById(id).orElse(null);
    }

    @Override
    public List<EnergyConsumption> getAllByCustomerId(long id) {
        return repos.getAllByCustomerId(id);
    }

    @Override
    public List<EnergyConsumption> getAllByCustomerType(String type) {
        return repos.getAllByCustomerType(type);
    }

    @Override
    public List<EnergyConsumption> getBetweenDates(LocalDateTime from, LocalDateTime to) {
        return repos.getBetweenDates(from, to);
    }
}
