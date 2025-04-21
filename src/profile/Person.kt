package profile

class Person {
    val name: String
    val age: Int
    val height: Int
    val weight: Int

    constructor(name: String, age: Int, height: Int, weight: Int) {
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
    }

    fun personInfo() {
        println("\nName: ${this.name}\nAge: ${this.age}\nHeight: ${this.height}\nWeight: ${this.weight}\n")
    }

    fun sayHello() {
        println("${this.name} say Hello!")
    }
    fun run(){
        repeat(10) {
            print("Running...")
        }
        print("\n")
    }
}