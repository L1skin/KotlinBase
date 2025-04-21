package corporation

class Director(
    name: String,
    age: Int
): Worker(name = name, age = age) {

    fun takeCofee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("Thank you, ${assistant.name}! The $drinkName is very tasty")
    }
    fun getConsultantToWork(consultant: Consultant) {
        val customersCount = consultant.serveCustomers()
        println("Consultant ${consultant.name} serve $customersCount customers!")
    }

    override fun work() {
        println("I'm drinking coffee...")
    }


}