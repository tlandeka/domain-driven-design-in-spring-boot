package com.example.excercise.integration.infrastructure.persistence.jpa.payment;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DatastoreSystemsHealthIntegrationTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void dbPrimaryIsOk() {
        try {
            DatabaseMetaData metadata = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            assertThat(metadata, is(notNullValue()));
            assertThat(catalogName, is(equalTo("test_db")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
