package oneupstudios.ulatinhackapi.controllers;

import oneupstudios.ulatinhackapi.dtos.DateIntervalDTO;
import oneupstudios.ulatinhackapi.dtos.EnergyConsumptionDTO;
import oneupstudios.ulatinhackapi.entities.EnergyConsumption;
import oneupstudios.ulatinhackapi.exceptions.ResourceNotFoundException;
import oneupstudios.ulatinhackapi.services.interfaces.ICustomerService;
import oneupstudios.ulatinhackapi.services.interfaces.IEnergyConsumptionService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("energy")
public class EnergyConsumptionController {
    private final IEnergyConsumptionService service;
    private final ICustomerService customerService;
    private final ModelMapper mapper;

    public EnergyConsumptionController(IEnergyConsumptionService service, ICustomerService customerService) {
        this.service = service;
        this.customerService = customerService;
        mapper = new ModelMapper();
    }

    @GetMapping("list-all")
    public List<EnergyConsumptionDTO> listAll() {
        return service.get().stream().map(x -> mapper.map(x, EnergyConsumptionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("get/{id}")
    public EnergyConsumptionDTO getById(@PathVariable("id") long id) {
        var entity = service.getEnergyConsumption(id);
        if (entity == null) {
            throw new ResourceNotFoundException("No such energy consumption");
        }
        var dto = mapper.map(entity, EnergyConsumptionDTO.class);
        dto.setCustomerId(entity.getCustomer().getCustomerId());
        return dto;
    }

    @PostMapping
    public void save(@RequestBody EnergyConsumptionDTO dto) {
        var entity = mapper.map(dto, EnergyConsumption.class);
        entity.setCustomer(customerService.getCustomer(dto.getCustomerId()));
        service.save(entity);
    }

    @PostMapping("save-all")
    public void saveAll(@RequestBody List<EnergyConsumptionDTO> dto) {
        service.saveAll(dto.stream().map(d -> {
            var entity = mapper.map(d, EnergyConsumption.class);
            entity.setCustomer(customerService.getCustomer(d.getCustomerId()));
            return entity;
        }).collect(Collectors.toList()));
    }

    @GetMapping("list-customer-type")
    public List<EnergyConsumptionDTO> listByCustomerType(@RequestParam("type") String type) {
        return service.getAllByCustomerType(type).stream().map(x ->
                        mapper.map(x, EnergyConsumptionDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("list-customer-id/{id}")
    public List<EnergyConsumptionDTO> listByCustomerId(@PathVariable("id") long id) {
        return service.getAllByCustomerId(id).stream().map(x -> mapper.map(x, EnergyConsumptionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("list-between")
    public List<EnergyConsumptionDTO> listBetweenDates(@RequestBody DateIntervalDTO dto) {
        return service.getBetweenDates(dto.getFrom(), dto.getTo()).stream()
                .map(x -> mapper.map(x, EnergyConsumptionDTO.class)).collect(Collectors
                        .toList());
    }

}
