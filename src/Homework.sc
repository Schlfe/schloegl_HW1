//Homework 1, Schloegl Ferdinand, Partner: Urch Stephan
// 08.10.2015
// @formatter:off

// FOREACH:
val food = List("Apple","Schnitzel","Steak","Hamburger","Cheese")
//variant 1:
food.foreach(println)
//variant 2: anon function
food foreach (dish => println(s"I will have $dish for lunch"))

//variant 3: named function
def countLengthOfDish(dish:String) = println(dish.length)
food foreach countLengthOfDish
// FILTER:
//named function
def foodStartsWith(letter:String)(dish:String) = dish.startsWith(letter)
val filteredFood = food.filter(foodStartsWith("S"))
val filteredFood2 = food filter (foodStartsWith("S"))
// anon function
val filterFood3 = food.filter(_.length == 5)
//MAP
val numbers = List(2,6,5,4,2,5,1,63,2)

//named function
def doublerFunction(number:Int) = number * 2
val doubledNumbers=numbers.map(doublerFunction)

//anon function
val doubledNumbers2=numbers.map(_*2)
//REDUCE
//named
def sumNumber(sum:Int,currentNumber:Int) = sum + currentNumber
val sumOfList = numbers.reduce(sumNumber)
//anon
val productOfList = numbers.reduce(_*_)
//FOLD LEFT AND RIGHT

val numbersForFold = List(1,2,3,4)
numbersForFold.foldLeft(10)(_-_) //same as fold
//10 + ( - 1 - 2 - 3 - 4 )
numbersForFold.foldRight(10)(_-_)
//(1 - (2 - ( -3 - 4))) + 10
// foldRight goes throught list backwards


//Explanation of Person with Children
case class Person(firstname: String, lastname: String,
                  children: Option[Set[Person]] = None)
val benji = Person("Benjamin","Miller")
val judy = Person("Judy","Miller")
val jane = Person("Jane","Miller",Some(Set(benji,judy)))
List(benji,judy,jane) foreach {
  case Person(firstname,_,None) => println(s"$firstname has no kids")
  case Person(firstname,_,Some(kids)) =>
    println(s"$firstname has kids ${kids.map(_.firstname).mkString(" and ")}")
}

// the children value is optional, keyword Option
// eg. Benjamin Miller has no children argument, if we ask for it
// => we get None
// Jane Miller has a argument in the constructor, so she has a Set of children

// Own Optional Example
case class TradingGood (name:String,price:Double,comment: Option[String]=None)
  val good1 = TradingGood("Iron",5.6)
  val good2 = TradingGood("Wood",1.2)
  val good3 = TradingGood("Coal",3.3,Some("Special coal from Silicon Valley"))
    List(good1,good2,good3) foreach {
    case TradingGood(name,price,None) => println(s"$name costs $price comment: None")
    case TradingGood(name,price,com) => println(s"$name costs $price comment: $com" )
  }


