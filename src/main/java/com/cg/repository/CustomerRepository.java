package com.cg.repository;

import com.cg.model.Customer;
import com.cg.model.dto.CustomerResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public List<Customer> findAllByIdNot(Long id);
//    @Query("SELECT NEW com.cg.model.dto.CustomerResDTO ( " +
//            "cus.id, " +
//            "cus.fullName, " +
//            "cus.email, " +
//            "cus.phone, " +
//            "cus.balance, " +
//            "cus.locationRegion" +
//            ") " +
//            "FROM Customer AS cus"
//    )
//    List<CustomerResDTO> findAllCustomerResDTO();
}
