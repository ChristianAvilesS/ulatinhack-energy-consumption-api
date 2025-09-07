package oneupstudios.ulatinhackapi.controllers;

import oneupstudios.ulatinhackapi.dtos.CustomerDTO;
import oneupstudios.ulatinhackapi.entities.Customer;
import oneupstudios.ulatinhackapi.exceptions.ResourceNotFoundException;
import oneupstudios.ulatinhackapi.services.interfaces.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private final ICustomerService service;
    private final ModelMapper mapper;

    public CustomerController(ICustomerService service) {
        this.service = service;
        mapper = new ModelMapper();
    }

    @GetMapping("list-all")
    public List<CustomerDTO> listCustomers() {
        return service.getCustomers().stream().map(c -> mapper.map(c, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("get/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") long id) {
        var entity = service.getCustomer(id);
        if (entity == null) {
            throw new ResourceNotFoundException("No such energy consumption");
        }
        return mapper.map(service.getCustomer(id), CustomerDTO.class);
    }

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO dto) {
        service.saveCustomer(mapper.map(dto, Customer.class));
    }

    @GetMapping("list-type")
    public List<CustomerDTO> listCustomersByType(@RequestParam("type") String type) {
        return service.getCustomerByType(type).stream().map(c -> mapper.map(c, CustomerDTO.class))
                .collect(Collectors.toList());
    }
}
