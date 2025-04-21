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

        when(productType) {
            0 -> {print("Enter the product callories: ")
                val productCallories = readln().toInt()
                val foodCard = FoodCard(name = productName, brand = productBrand, price = productPrice, calories = productCallories)
                foodCard.printInfo()
            }
            1 -> {print("Enter the product wattage: ")
                val productWattage = readln().toInt()
                val applianceCard = AppliancesCard(name = productName, brand = productBrand, price = productPrice, wattage = productWattage)
                applianceCard.printInfo()
            }
            2 -> {print("Enter the product size: ")
                val productSize = readln().toFloat()
                val shoesCard = ShoesCard(name = productName, brand = productBrand, price = productPrice, size  = productSize)
                shoesCard.printInfo()
            }
        }

    }
}