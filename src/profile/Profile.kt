package profile

fun main() {

    print("Input 1st name: ")
    val name = readln()
    print("Input 1st age: ")
    val age = readln().toInt()
    print("Input 1st height: ")
    val height = readln().toInt()
    print("Input 1st weight: ")
    val weight = readln().toInt()

    val first = Person(name = name, age = age, height = height, weight = weight)


    first.personInfo()
    first.sayHello()
    first.run()
}