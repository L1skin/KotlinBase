package corporation

enum class EmployeePosition (val title: String) {
    DIRECTOR(title = "Director"),
    ACCOUNTANT(title = "Accountant"),
    ASSISTANT(title = "Assistant"),
    CONSULTANT(title = "Consultant")
}