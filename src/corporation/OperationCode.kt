package corporation

enum class OperationCode(val title: String) {
     EXIT(title = "Exit"), REGISTER_NEW_ITEM(title = "Register new item"), SHOW_ALL_ITEMS(title = "Show all items")
}