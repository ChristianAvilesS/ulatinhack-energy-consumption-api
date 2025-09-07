package oneupstudios.ulatinhackapi.services.impls;

import oneupstudios.ulatinhackapi.entities.Customer;
import oneupstudios.ulatinhackapi.repositories.ICustomerRepos;
import oneupstudios.ulatinhackapi.services.interfaces.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private final ICustomerRepos repos;

    public CustomerServiceImpl(ICustomerRepos repos) {
        this.repos = repos;
    }

    @Override
    public List<Customer> getCustomers() {
        return repos.findAll();
    }

    @Override
    public Customer getCustomer(long id) {
        return repos.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        repos.save(customer);
    }

    @Override
    public List<Customer> getCustomerByType(String type) {
        return repos.findByType(type);
    }
}
