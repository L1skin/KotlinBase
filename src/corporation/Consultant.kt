package corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name: String,
    age: Int = 0
): Worker(id = id, name = name, age = age, employePosition = EmployeePosition.CONSULTANT) {

    fun sayHello(){
        if (age != 0) {
            println("Hello! My name is ${this.name}, my age is ${this.age}")
        } else {
            println("Hello! My name is ${this.name}")
        }
    }

    fun serveCustomers(): Int {
        val count = Random.nextInt(0,100)
        repeat(count) {
            print("The customer is served! ")
        }
        println()
        return count
    }

    override fun work() {
        println("I'm serve customers...")
    }
}
