package corporation

class Accountant (
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {

    override fun work() {

        while(true) {
            print("Enter the operation code. 0 - exit, 1 - register new item: ")
            val operationCode = readln().toInt()
            if (operationCode == 0) {
                break
            }
            registerNewItem()
        }
    }

    fun registerNewItem() {

        print("Enter the product type. 0 - Food, 1 - Appliance, 2 - Shoe: ")
        val productType = readln().toInt()
        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()

        val card = when(productType) {
            0 -> {
                print("Enter the product callories: ")
                val productCallories = readln().toInt()
                FoodCard(name = productName, brand = productBrand, price = productPrice, calories = productCallories)
            }
            1 -> {print("Enter the product wattage: ")
                val productWattage = readln().toInt()
                AppliancesCard(name = productName, brand = productBrand, price = productPrice, wattage = productWattage)
            }
            else -> {print("Enter the product size: ")
                val productSize = readln().toFloat()
                ShoesCard(name = productName, brand = productBrand, price = productPrice, size  = productSize)
            }
        }
        card.printInfo()

    }
}