import javax.sound.midi.Soundbank
//import com.sun.prism.impl.Disposer.Record
// TODO send repo link to pietia@

object main {
  def task1(): Unit = {
    val weekdays = List("Poniedzialek", "Wtoerk", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")

    // a
    for (day <- weekdays)
      print(day + " ")
    println

    // b
    for (day <- weekdays if day(0) == 'P')
      print(day + " ")
    println

    // c
    weekdays.foreach(day => print(day + " "))
    println

    // d
    var i = 0
    while (i < weekdays.length) {
      print(weekdays(i) + " ")
      i += 1
    }
    println

    // e
    def printWeekdays(l : List[Any]) : Unit = {
      if (!l.isEmpty) {
        print(l.head + " ")
        printWeekdays(l.tail)
      }
    }
    printWeekdays(weekdays)
    println

    // f
    def printWeekdaysBackwards(l : List[Any]) : Unit = {
      if (!l.isEmpty) {
        print(l.last + " ")
        printWeekdaysBackwards(l.init)
      }
    }
    printWeekdaysBackwards(weekdays)
    println

    // g
    print(weekdays.foldLeft("")(_ +_ + " "))
    println

    print(weekdays.foldRight("")(_ + " " + _))
    println

    // h
    print(weekdays.filter(_.startsWith("P")).foldLeft("")(_ +_ + " "))
    println("\n-------------------------------------------------------")
  }

  def task2(): Unit = {
    val wares = Map("Axe" -> 1000, "Epic Axe" -> 1001, "Sword" -> 99, "Map" -> 123)
    val waresDiscount = wares.mapValues(_ * 0.9)

    waresDiscount.foreach(ware => print(ware + " "))
    println("\n-------------------------------------------------------")
  }

  def task3(): Unit = {
    def giveTuple(t : (Any, Any, Any)) : Unit = {
      if (t._1.getClass == t._2.getClass || t._1.getClass == t._3.getClass || t._2.getClass == t._3.getClass) {
        print("Zla krotka - odaj krotke o roznych typach")
        return
      }

      t.productIterator.foreach(element => print(element + " - " + element.getClass + "\n"))
    }
    val tBad = Tuple3(3, "d", 3)
    val tGood = Tuple3(1, "e", 'd')
    giveTuple(tBad)
    println
    giveTuple(tGood)
    println("-------------------------------------------------------")
  }

  def task4(): Unit = {
    val heroes = Map("Fredo" -> 33, "Aragore" -> 99, "Gimlo" -> 45, "Gambalf" -> 150)
    println("Fredo's HP: " + heroes.get("Fredo"))
    println("Lelgolas' HP: " + heroes.get("Lelgolas"))
    println("Why Lelgolas has None HP? Is his record empty? " + heroes.get("Lelgolas").isEmpty)
    println("Yep, it's empty. That means he's " + heroes.get("Lelgolas").getOrElse("RIP"))
    println("-------------------------------------------------------")
  }

  def task5(): Unit = {
    def whatDayIsToday(s : String): String = s match {
      case "Poniedzialek" | "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
      case "Sobota" | "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }

    val testCases = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela", "dfeser")
    testCases.foreach(s => println(whatDayIsToday(s)))

    println("-------------------------------------------------------")
  }

  def task6(): Unit = {
    class BankAccount(startAmount : Float = 0.0f) {
      private var _acc = startAmount
      def acc = _acc

      def deposit(amount : Float): Unit = {
        _acc += amount
      }

      def withdraw(amount : Float): Boolean = {
        if (amount > _acc)
          return false
        else
          _acc -= amount
        return true
      }
    }

    var ba = new BankAccount(100)
    println(ba.acc)
    ba.withdraw(50)
    println(ba.acc)
    ba.deposit(99)
    println(ba.acc)
    ba = new BankAccount
    println(ba.acc)
    ba.withdraw(50)
    println(ba.acc)
    ba.deposit(99)
    println(ba.acc)
    ba.withdraw(50)
    println(ba.acc)
//    ba.acc = 32
    println("-------------------------------------------------------")
  }

  def task7(): Unit = {
    case class Person(firstName : String, lastName : String)

    def greet(p : Person) : String = p match {
      case p if p.lastName == "Kmicic" => "Tys nie Babinicz, tys Kmicic!"
      case p if p.firstName == "Andrzej" => "Andrzeju, nie denerwuj sie."
      case p if p.firstName == "Pietia" => "Czy egzamin bedzie trudny?"
      case _ => "Witaj, przybyszu!"
    }

    val p1 = new Person("fsefser", "ersfr")
    val p2 = new Person("Andrzej", "Kmicic")
    val p3 = new Person("Andrzej", "Kuklinowski")
    val p4 = new Person("Pietia", "Pietia")

    println(greet(p1))
    println(greet(p2))
    println(greet(p3))
    println(greet(p4))
    println("-------------------------------------------------------")
  }

  def task8(): Unit = {
    def noZeroes(l : List[Int]) : List[Int] = l.filterNot(e => e == 0)

    val noZeroesList = noZeroes(List(0, 1, 2, 3, 4, 0, 5, 6, 0, 7, 80, 9, 0, 0, 0))
    noZeroesList.foreach(e => print(e + " "))
    println("\n-------------------------------------------------------")
  }

  def main(args: Array[String]) {
    task1
    task2
    task3
    task4
    task5
    task6
    task7
    task8
  }
}