package com.szymix.customer.dao;

import com.szymix.customer.CustomerRowMapper;
import com.szymix.customer.models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerJDBCDataAccessService implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    public CustomerJDBCDataAccessService(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        var sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql, customerRowMapper);
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        var sql = """
                SELECT * FROM customer
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, customerRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        var sql = """
                INSERT INTO customer(name, email, age)
                VALUES (?, ?, ?)
                """;
        int inserted = jdbcTemplate.update(sql, customer.getName(),
                customer.getEmail(), customer.getAge());
        System.out.println("jdbcTemplate.update = " + inserted);
    }

    @Override
    public boolean existsCustomerWithEmail(String email) {
        var sql = """
                SELECT count(id)
                FROM customer
                WHERE email = ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);

        return count != null && count > 0;
    }

    @Override
    public boolean existsCustomerWithId(Long id) {
        var sql = """
                SELECT count(id)
                FROM customer
                WHERE id = ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    @Override
    public void deleteCustomerById(Long id) {
        var sql = """
                DELETE
                FROM customer
                WHERE id = ?
                """;
        int deleted = jdbcTemplate.update(sql, id);
        System.out.println("jdbcTemplate.delete = " + deleted);
    }

    @Override
    public void updateCustomer(Customer update) {
        if (update.getName() != null) {
            var sql = """
            UPDATE customer
            SET name = ?
            WHERE id = ?
            """;
            int updated = jdbcTemplate.update(sql, update.getName(), update.getId());
            System.out.println("update customer name result = " + updated);
        }
        if (update.getEmail() != null) {
            var sql = """
            UPDATE customer
            SET email = ?
            WHERE id = ?
            """;
            int updated = jdbcTemplate.update(sql, update.getEmail(), update.getId());
            System.out.println("update customer email result = " + updated);
        }
        if (update.getAge() != null) {
            var sql = """
            UPDATE customer
            SET age = ?
            WHERE id = ?
            """;
            int updated = jdbcTemplate.update(sql, update.getAge(), update.getId());
            System.out.println("update customer age result = " + updated);
        }
    }
}
