package corporation

class Assistant (
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {

    fun bringCoffee(count: Int = 1, drink: String = "Cappuccino"): String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$drink\" button")
            println("Wait for the $drink to be prepared")
            println("Take coffee")
            println("Bring $drink to the director")
            println("Put $drink on the table")
            println("Return to the workplace")
            println("")
        }
        return "Espresso"
    }

    override fun work() {
        println("I'm make coffee...")
    }
}