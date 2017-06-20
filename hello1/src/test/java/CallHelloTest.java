
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.hello1.Hello2Client;
import com.example.hello1.Hello2Service;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;








import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class CallHelloTest {
	public static final String HELLO2_PATH = "/hello2";
	@MockBean
    private Hello2Client hello2Client;
	
	@Autowired
	private Hello2Service hello2Service;
	
	@Before(value = "")
	public void setUp() throws Exception {
	}

	@After(value = "")
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testCallHello2Fail() throws Exception {
		String result = hello2Service.callHello2();
		System.out.println(result);
//		assertThat(result, is("hello3"));
	}
	
	
	
	@Configuration
	@EnableAspectJAutoProxy
	@EnableHystrix
	public static class SpringConfig {
		//this bean is the key point for hystrix test
		@Bean
		public HystrixCommandAspect hystrixCommandAspect() {
			return new HystrixCommandAspect();
		}
		
		@Bean
		public Hello2Service hello2Service() {
			return new Hello2Service();
		}
		
	}

}

