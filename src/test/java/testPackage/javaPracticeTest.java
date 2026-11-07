package testPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class javaPracticeTest {

	@Test
	void java() {
		List<Integer> list = List.of(3, 8, 22,18 , 12, 15);
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
		list.stream().filter(n -> n > 10).forEach(n -> System.out.println(n));
	}

	@Test
	void java3() {
		System.out.println("Filtering values greater than 4 : ");
		List<String> list = List.of("java", "sql", "junit", "postman", "swing");
		list.stream().filter(n -> n.length() > 4).forEach(n -> System.out.println(n));
	}

	@Test
	void java4() {
		System.out.println("Converting every name to titlecase: ");
		List<String> list = List.of("rahul", "akash", "ramesh", "ravi");
		list.stream().map(n -> n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase())
				.forEach(n -> System.out.println(n));
	}

	@Test
	void java5() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add(1, "7");
		System.out.println(list);
		System.out.println("--------------")	;
		System.out.println(list.subList(3, 5));
		
		String name = "rahul";
		for(char c: name.toCharArray()) {
			System.out.println(c);
		}
		
		String name1 = "343rah$$)@(!.ul}";
		System.out.println(name1.replaceAll("[^0-9a-zA-Z]", ""));
		System.out.println(name1.replaceAll("[^a-zA-Z]", ""));
		
	}
	
	@Test
	void java6() {
		String sentence = "this is his list";
		int index = 0;
		int count = 0;
		String is = "is";
		while((index = sentence.trim().indexOf("is",index))!= -1) {
			count++;
			System.out.println("Index of " + count + "occurance: " + index);
			index += is.length(); 
		}
		System.out.println("is has been repeated " + count + " number of times");
	}
	
	@Test
	void java7() {
		String txt = "rahulganesh";
		char character = 'a';
		int index = 0;
		int count = 0;
		while((index = txt.indexOf(character,index))!=-1) {
			count++;
			index+=1;
		}
		System.out.println("'" + character + "'" + " has occurred " + count +" times in the given string: " + txt);
		
	}
}
