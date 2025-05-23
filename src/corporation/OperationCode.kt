package corporation

enum class OperationCode(val title: String) {
     EXIT(title = "Exit"),
     REGISTER_NEW_ITEM(title = "Register new item"),
     SHOW_ALL_ITEMS(title = "Show all items"),
     REMOVE_PRODUCT_CARD(title = "Remove product card"),
     REGISTER_NEW_EMPLOYEE(title = "Register new employee"),
     FIRE_AN_EMPLOYEE(title = "Fire an employee"),
     SHOW_ALL_EMLOYEES(title = "Show all employees")
}