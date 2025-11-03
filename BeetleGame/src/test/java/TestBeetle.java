import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBeetle {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testBeetle() {
		Beetle b = new Beetle();
		// initially no body
		assertFalse(b.addHead());
		assertTrue(b.addBody());
		assertTrue(b.addHead());
		assertTrue(b.addEye());
		assertTrue(b.addEye());
		assertTrue(b.addFeeler());
		assertTrue(b.addFeeler());
		for (int i = 0; i < 6; i++) assertTrue(b.addLeg());
		assertTrue(b.addTail());
		// now should be complete
		assertTrue(b.isComplete());
	}

	@Test
	void testAddHead() {
		Beetle beetle = new Beetle();
		assertFalse(beetle.addHead());
		assertTrue(beetle.addBody());
		assertTrue(beetle.addHead());
		System.out.println("Beetle with Head and Body \n" + beetle.toString());
				
	}

	@Test
	void testAddBody() {
		Beetle beetle = new Beetle();
		assertTrue (beetle.addBody());
		assertFalse(beetle.addBody());
		System.out.println("Beetle with Body \n" + beetle.toString());
	}

	@Test
	void testAddEye() {
		Beetle beetle = new Beetle();
		assertFalse(beetle.addEye());
		assertTrue(beetle.addBody());
		assertFalse(beetle.addEye());
		assertTrue(beetle.addHead());
		assertTrue(beetle.addEye());
		assertTrue(beetle.addEye());
		assertFalse(beetle.addEye());
	}

	@Test
	void testAddFeeler() {
		Beetle beetle = new Beetle();
		assertFalse (beetle.addFeeler());
		assertTrue(beetle.addBody());
		assertFalse(beetle.addFeeler());
		assertTrue(beetle.addHead());
		assertTrue(beetle.addFeeler());
		System.out.println("Beetle with one Feeler \n" + beetle.toString());
		assertTrue(beetle.addFeeler());
		System.out.println("Beetle with two feelers \n" + beetle.toString());
		assertFalse(beetle.addFeeler());
	}

	@Test
	void testAddLeg() {
		Beetle beetle = new Beetle();
		assertFalse(beetle.addLeg());
		assertTrue(beetle.addBody());
		for (int i = 0; i < 6; i++) assertTrue(beetle.addLeg());
		assertFalse(beetle.addLeg());
	}

	@Test
	void testAddTail() {
		Beetle beetle = new Beetle();
		assertFalse(beetle.addTail());
		assertTrue(beetle.addBody());
		assertTrue(beetle.addTail());
		assertFalse(beetle.addTail());
	}

	@Test
	void testIsComplete() {
		Beetle b = new Beetle();
		assertFalse(b.isComplete());
		b.addBody(); b.addHead(); b.addEye(); b.addEye(); b.addFeeler(); b.addFeeler();
		for (int i=0;i<6;i++) b.addLeg();
		b.addTail();
		assertTrue(b.isComplete());
	}

	@Test
	void testToString() {
		Beetle b = new Beetle();
		assertEquals(" ", b.toString());
		b.addBody();
		String s = b.toString();
		assertNotNull(s);
		// when complete, string should contain '#'
		b.addHead(); b.addEye(); b.addEye(); b.addFeeler(); b.addFeeler();
		for (int i=0;i<6;i++) b.addLeg();
		b.addTail();
		assertTrue(b.toString().contains("#"));
	}

}
