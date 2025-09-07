package oneupstudios.ulatinhackapi.repositories;

import oneupstudios.ulatinhackapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepos extends JpaRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c " +
            "WHERE c.customerType = :type")
    List<Customer> findByType(@Param("type") String type);
}
