package com.example.demo.config;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.example.demo.entity.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
 
final class CustomerPreparedStatementSetter implements ItemPreparedStatementSetter<Customer> {
 
    @Override
    public void setValues(Customer customer, 
                          PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, customer.getId());
        preparedStatement.setString(2, customer.getFirstName());
        preparedStatement.setString(3, customer.getSurName());
        preparedStatement.setString(4, customer.getEmail());
    }
}