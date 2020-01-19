package com.gtstar.fsm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FsmApplication.class)
@Transactional
@Rollback
public class FsmApplicationTests {

	@Test
	public void contextLoads() {

	}

}
