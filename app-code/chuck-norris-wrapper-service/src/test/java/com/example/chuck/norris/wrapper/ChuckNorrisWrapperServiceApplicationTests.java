/*----------------------------------------------------------------------------*/
/* Source File:   CHUCKNORRISWRAPPERSERVICEAPPLICATIONTESTS.JAVA              */
/* Description:   Spring Boot Context test.                                   */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.11/2019                                                 */
/* Last Modified: Oct.11/2019                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2019 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2019  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.chuck.norris.wrapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring Boot Context test.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2019
 * @since 11 (JDK), Oct.11/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChuckNorrisWrapperServiceApplicationTests {
	@Autowired
	private ApplicationContext appContext;

	/**
	 * Load Spring Boot App to validate it is well configured.
	 */
	@Test
	public void contextLoads() {
		assertThat(appContext).isNotNull();
	}

}
