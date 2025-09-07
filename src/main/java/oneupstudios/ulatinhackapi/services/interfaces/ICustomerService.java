package oneupstudios.ulatinhackapi.services.interfaces;

import oneupstudios.ulatinhackapi.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(long id);
    void saveCustomer(Customer customer);
    List<Customer> getCustomerByType(String type);
}
