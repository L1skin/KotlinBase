package cats

fun main() {
    val cat = Cat("Sofa")
    println(cat.legsCount)
    println(cat.name)
    cat.playWithMouse()
    println()

    val lion = Lion(countInPride = 25)
    println(lion.countInPride)
    println(lion.legsCount)
}