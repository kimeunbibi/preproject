package com.example.demo;

import com.example.demo.Entity.Person;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
    private final JdbcTemplate jdbcTemplate;

    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            System.out.println("!!! JOB FINISHED! Time to verify the results");

            List<Person> result = jdbcTemplate.query("SELECT first_name, last_name FROM person",
                    (rs, row) -> new Person(
                            rs.getString(1),
                            rs.getString(2)));
            result.forEach(person -> System.out.println("Found <" + person + "> in the database."));

        }
    }
}
