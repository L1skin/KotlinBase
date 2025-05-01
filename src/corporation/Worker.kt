package corporation

open class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val employePosition: EmployeePosition
) {
    open fun work() {
        println("I'm working now...")
    }
}