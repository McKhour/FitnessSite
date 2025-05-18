package hu.nye.fitnessSite;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainTest {

	@Test
	void testHiddenHttpMethodFilterBean() {
		Main main = new Main();
		HiddenHttpMethodFilter filter = main.hiddenHttpMethodFilter();
		assertNotNull(filter, "A HiddenHttpMethodFilter bean nem lehet null");
	}
}
