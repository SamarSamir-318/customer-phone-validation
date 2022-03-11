package eg.com.jumia.repository;

import eg.com.jumia.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.phone LIKE CONCAT('%',:phone,'%')")
    List<Customer> findByPhoneLike(@Param("phone")String name);
}
