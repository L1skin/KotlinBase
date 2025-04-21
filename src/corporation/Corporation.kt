package corporation

fun main() {
    val director = Director(name = "John", age = 51)
    val assistant = Assistant(name = "Nick", age = 30)
    val consultant = Consultant(name = "Alex")
    val accountant = Accountant(name = "Matt")

    val employees = listOf<Worker>(director, consultant, assistant, accountant)

    for (employee in employees) {
        employee.work()
    }
}