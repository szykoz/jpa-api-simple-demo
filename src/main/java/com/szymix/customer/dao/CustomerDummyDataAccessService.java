package com.szymix.customer.dao;

import com.szymix.customer.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("in_mem")
public class CustomerDummyDataAccessService implements CustomerDao {
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();

        Customer alex = new Customer(1L, "Alex", "alex@gmail.com", 21);
        customers.add(alex);

        Customer anna = new Customer(2L, "Anna", "anna@gmail.com", 19);
        customers.add(anna);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        Long maxId = customers.stream()
                .map(Customer::getId)
                .max(Long::compareTo)
                .orElse(1L);
        customer.setId(++maxId);
        customers.add(customer);
    }

    @Override
    public boolean existsCustomerWithEmail(String email) {
        return customers.stream().anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public boolean existsCustomerWithId(Long id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public void deleteCustomerById(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public void updateCustomer(Customer update) {
        customers.removeIf(c -> c.getId().equals(update.getId()));
        customers.add(update);
    }
}
