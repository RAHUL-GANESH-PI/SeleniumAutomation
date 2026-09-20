package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class javaPractice {
	int a = 1;

	@AfterEach
	void afterAll() {
		System.out.println("****************");
	}

	@Test
	void java() {
		List<Integer> list = List.of(3, 8, 15, 22, 7, 41, 12);
		System.out.println("Even numbers in Given Integer List: ");
		list.stream().filter(n -> (n % 2 == 0)).collect(Collectors.toList()).forEach(n -> System.out.println(n));
	}

	@Test
	void java1() {
		List<String> list = List.of("rahul", "akash", "ramesh", "ravi");
		System.out.println("String List to UpperCase: ");
		list.stream().map(n -> n.toUpperCase()).collect(Collectors.toList()).forEach(n -> System.out.println(n));
	}
	
	@Test
	void java2() {
		List<Integer> list = List.of(3, 8, 15, 22, 7, 41, 12);
		System.out.println("Numbers greater than 10: ");
	    list.stream().filter(n -> n>10).forEach(n -> System.out.println(n));
	}
	
	@Test
	void java3() {
		System.out.println("Filtering values greater than 4 : ");
		List<String> list = List.of("java", "sql", "junit", "postman", "swing");
		list.stream().filter( n -> n.length()>4).forEach(n -> System.out.println(n));
	}
	
	@Test
	void java4() {
		System.out.println("Converting every name to titlecase: ");
		List<String> list = List.of("rahul", "akash", "ramesh", "ravi");
		list.stream().map(n -> n.substring(0,1).toUpperCase() + n.substring(1).toLowerCase()).forEach(n -> System.out.println(n));
	}
}
