package files

import java.io.File

fun main() {
    val file = File("todo_list.txt")

    while(true) {

        print("Enter operation code. ")
        val operations = OperationCode.entries

        for ((index, operation) in operations.withIndex()) {
            print("$index - ${operation.title}")
            if (index < operations.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }

        val userOperation = readln().toInt()
        val operationCode = operations[userOperation]

        when (operationCode) {
            OperationCode.EXIT -> break
            OperationCode.ADD_TODO -> {
                print("Write you text here: ")
                val newText = readln()
                file.appendText("$newText\n")
            }
            OperationCode.SHOW_TODO_LIST -> {
                val content = file.readText().trim()
                val toDoList = content.split("\n")
                for ((index, item) in toDoList.withIndex()) {
                    println("$index - $item")
                }
            }
        }
    }
}