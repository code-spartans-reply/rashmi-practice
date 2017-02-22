/**
 * 
 */

function defaultGreeting() {
	// return the classin "Hello world" string;
	return "Hello world";
}
	
function greet(name) {
	// say "Hello " to the named person;
	var text1 = "Hello";
	var text2 = "_";
	var text3 = text1.concat(text2);
	text3 = text3.replace("_", " ");
    return text3+name;
}

function defaultGreetingLength() {
	// return the number of character composing the "Hello world" string;
	var str = "Hello World";
	return str.length;
}

function greetArray(words) {
	// Join all the strings in the Java array "words" together, separated with a single white space.
	// You can use Java.from(words) in order to transform Java array into JavaScript array.;
	//words = ["Hello", "World"];
	var wordsArray = [];
	wordsArray = Java.from(words);
	var w = wordsArray.toString().replace(",", " ");
	return w;
}
		
function greetIntoArray() {
	// Return a Java "String[]" containing the strings "Hello" and "world".
	// You can use "Java.to" in order to translate a JavaScript array into a Java one.
	// You can also use "Java.type" for specifying the correct type
	var str = "Hello world";
	var strToArray = str.split(" ");
	var javaStringArray = Java.to(strToArray, Java.type("java.lang.String[]"));

	return javaStringArray;
};

function greetFruitAndDrain(apple) {
	// Drain 10 units of juice from the fiven apple, and then say "Hello" to the fruitname!
	var appleTask =  Java.type("com.reply.test.model.Apple");
    var newApple = new appleTask();
    var units = Number(10);
    units.class;

    var drainTask = newApple.drain(parseInt(10));
    print(newApple.drain(parseInt(10)), typeof parseInt(10));
    if(drainTask != undefined){
        return drainTask;
    }
    else{
        return "Hello".concat("_", newApple.getName())
    }
}
		
function createApple() {
	// create a new Apple and give it back to Java!
	var appleTask =  Java.type("com.reply.test.model.Apple");
    var newApple = new appleTask();

    return newApple;
}
	
function countJuice(fruitBasket) {
	// Count how much juice there is in all the apples in the basket.
	// return the number.
    var fruitTask =  Java.type("com.reply.test.model.Apple");
    var basket = new fruitTask();
    var countTask = basket.getJuice();

	return countTask;

}

function createFruitBasket() {
	// Create a java.util.HashSet containing three apples!
	var HashSet = Java.type("java.util.HashSet");
	var getApple = Java.type("com.reply.test.model.Apple");
	var newApple = new getApple();
	var count = 3;
	var hs = new HashSet();

    for(i in count){
        hs[i].add(newApple);
    }
    print(hs);
	return hs;
}
