/**
 * 
 */
function defaultGreeting() {
	return "Hello world";
}
	
function greet(name) {
	return "Hello " + name;
}

function defaultGreetingLength() {
	return 11;
}

function greetArray(words) {
	var wordsArray = Java.from(words);
	return wordsArray.join(" ");
}
		
function greetIntoArray() {
	return Java.to(["Hello", "world"], Java.type("java.lang.String[]"));
};

function greetFruitAndDrain(apple) {
	apple.drain(10);
	return "Hello " + apple.getName();
}
		
function createApple() {
	return new com.reply.test.model.Apple();
}
	
function countJuice(fruitBasket) {
	var juice = 0;
	fruitBasket.stream().forEach(function (fruit) {
		juice += fruit.getJuice()
	});
	
	return juice;
}

function createFruitBasket() {
	var basket = new java.util.HashSet();
	basket.add(createApple());
	basket.add(createApple());
	basket.add(createApple());

	return basket;
}
