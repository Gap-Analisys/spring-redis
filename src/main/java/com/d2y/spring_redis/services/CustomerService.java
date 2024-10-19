package com.d2y.spring_redis.services;

import com.d2y.spring_redis.models.Customer;
import com.d2y.spring_redis.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Cacheable(value = "customers", key = "#id")
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Cacheable(value = "customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @CachePut(value = "customers", key = "#customer.id")
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @CachePut(value = "customers", key = "#customer.id")
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @CacheEvict(value = "customers", key = "#id")
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

