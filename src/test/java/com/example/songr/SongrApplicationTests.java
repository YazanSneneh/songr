package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	public void contextLoads() {
		Album andJusticeForAll = new Album("And justice for all","Metallica",20,2,"https://cdn.europosters.eu/image/1300/textile-postermetallica-and-justice-for-all-i85083.jpg");

		assertEquals("expected title", "And justice for all",andJusticeForAll.getTitle());
	}

}
