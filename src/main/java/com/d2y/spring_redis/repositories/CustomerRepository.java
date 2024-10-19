package com.d2y.spring_redis.repositories;

import com.d2y.spring_redis.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
