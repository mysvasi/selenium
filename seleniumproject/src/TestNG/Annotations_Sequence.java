package TestNG;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Annotations_Sequence {

	@Test
	public void testCase1() {

		System.out.println("testCase1");
	}

	@Test
	public void testCase2() {

		System.out.println("testCase2");
	}

	@Before
	public void beforeMethod() {

		System.out.println("beforeMethod");
	}

	@After
	public void afterMethod() {

		System.out.println("afterMethod");
	}

	@Before
	public void beforeClass() {

		System.out.println("beforeClass");
	}

	@After
	public void afterClass() {

		System.out.println("afterClass");
	}

	@Before
	public void beforeTest() {

		System.out.println("beforeTest");
	}

	@After
	public void afterTest() {

		System.out.println("afterTest");
	}

	@Before
	public void beforeSuite() {

		System.out.println("beforeSuite");
	}

	@After
	public void afterSuite() {

		System.out.println("afterSuite");
	}

}
