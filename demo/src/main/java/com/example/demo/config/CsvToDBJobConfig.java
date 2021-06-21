package com.example.demo.config;



import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.demo.entity.Customer;
 
@Configuration
public class CsvToDBJobConfig {
	
	private static final String CustInsertQry = "INSERT " +
            "INTO customer(id, first_name, sur_name, email) " +
            "VALUES (?, ?, ?, ?)";
     
    @Bean
    ItemWriter<Customer> csvFileDatabaseItemWriter(DataSource dataSource, 
                                                     NamedParameterJdbcTemplate jdbcTemplate) {
    	JdbcBatchItemWriter<Customer> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(dataSource);
        databaseItemWriter.setJdbcTemplate(jdbcTemplate);
        databaseItemWriter.setSql(CustInsertQry); 
        
        ItemPreparedStatementSetter<Customer> custSetter = 
                new CustomerPreparedStatementSetter();
        databaseItemWriter.setItemPreparedStatementSetter(custSetter);
        
        return databaseItemWriter;
    }
}