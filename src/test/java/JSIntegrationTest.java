import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.reply.test.model.Apple;

public class JSIntegrationTest {

	@Test
	public void testReturningAString() throws Exception {
		String greeting = JavaScriptEngine.<String>call("defaultGreeting");
		
		assertThat(greeting).isEqualTo("Hello world");
	}
	
	@Test
	public void testReadingAParameter() throws Exception {
		String greeting = JavaScriptEngine.<String>call("greet", "Rashmi");
		
		assertThat(greeting).isEqualTo("Hello Rashmi");
	}
	

	@Test
	public void testReturningAnInt() throws Exception {
		Integer helloWorldLength = JavaScriptEngine.<Integer>call("defaultGreetingLength");
		
		assertThat(helloWorldLength).isEqualTo("Hello world".length());
	}

	@Test
	public void testReadingArray() throws Exception {
		String greeting = JavaScriptEngine.<String>call("greetArray", new Object[] { new String[] {"Hello", "world"}});
		
		assertThat(greeting).isEqualTo("Hello world");
	}
	
	@Test
	public void testReturningArray() throws Exception {
		Object greetingObject = JavaScriptEngine.<String[]>call("greetIntoArray");
		
		String[] greeting = (String[]) greetingObject;
		assertThat(greeting).containsExactly("Hello", "world");
	}
	
	@Test
	public void testReadingACustom() throws Exception {
		final Apple apple = new Apple();
		String greeting = JavaScriptEngine.<String>call("greetFruitAndDrain", apple);
		
		assertThat(greeting).isEqualTo("Hello Apple");
		assertThat(apple.getJuice()).isEqualTo(90);
	}
	
	@Test
	public void testCreatingACustom() throws Exception {
		final Apple apple = JavaScriptEngine.<Apple>call("createApple");
		
		assertThat(apple).isInstanceOf(Apple.class);
		assertThat(apple.getName()).isEqualTo("Apple");
		assertThat(apple.getJuice()).isEqualTo(100);
	}
	
	@Test
	public void testReadingACollection() throws Exception {
		final Apple firstApple = new Apple();
		final Apple secondApple = new Apple();
		secondApple.drain(10);
		final Apple thirdApple = new Apple();
		thirdApple.drain(50);
		
		final double totalJuice = JavaScriptEngine.<Double>call("countJuice", ImmutableSet.builder().add(firstApple, secondApple, thirdApple).build());

		assertThat(totalJuice).isEqualTo(240d);
	}
	
	@Test
	public void testRetuningACollection() throws Exception {
		
		final Set<Apple> basket = JavaScriptEngine.<Set<Apple>>call("createFruitBasket");
		
		assertThat(basket).isNotEmpty();
		assertThat(basket.size()).isEqualTo(3);
	}
	
}
