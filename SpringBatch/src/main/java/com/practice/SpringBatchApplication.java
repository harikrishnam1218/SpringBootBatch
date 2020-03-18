package com.practice;


import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringBatchApplication {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}
	
	@Scheduled(fixedDelay=5000)
	public void doJob() {
		JobParameters parameters=new JobParametersBuilder()
				.addString("JobId", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		try {
			JobExecution jobExecution=jobLauncher.run(job, parameters);
			if(jobExecution.getStatus().equals(BatchStatus.COMPLETED)){
				jobExecution.stop();
			}
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
