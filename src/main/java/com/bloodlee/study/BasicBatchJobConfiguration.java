package com.bloodlee.study;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * Job Configuration<br/>
 * 
 * Datasource 없이 사용할 경우 extends DefaultBatchConfigurer 설정.
 * @author Bred
 *
 */
@Configuration
@EnableBatchProcessing
@Slf4j
public class BasicBatchJobConfiguration extends DefaultBatchConfigurer {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	protected Tasklet tasklet() {

		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution,
					ChunkContext context) {
				log.info("Tasklet");
				return RepeatStatus.FINISHED;
			}
		};

	}

	@Bean
	public Job job() throws Exception {
		log.info("Job");
		return this.jobs.get("job").start(step1()).build();
	}

	@Bean
	protected Step step1() throws Exception {
		log.info("Step1");
		return this.steps.get("step1").tasklet(tasklet()).build();
	}
}
