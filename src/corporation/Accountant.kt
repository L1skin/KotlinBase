package corporation

class Accountant (
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {

    override fun work() {

        while(true) {
            print("Enter the operation code. ")
            val operationCodes = OperationCode.entries

            for ((index, code) in operationCodes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationCodes.size - 1) {
                    print(", ")
                } else {
                    print(": ")
                }
            }

            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]

            when(operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
            }
        }
    }

    fun registerNewItem() {

        val productTypes = ProductType.entries

        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()) {
            print("$index - ${type.title}")
            if (index < productTypes.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }

        val productTypeIndex = readln().toInt()
        val productType = productTypes[productTypeIndex]

        print("Enter the product name: ")
        val productName = readln()
        print("Enter the product brand: ")
        val productBrand = readln()
        print("Enter the product price: ")
        val productPrice = readln().toInt()

        val card = when(productType) {
            ProductType.FOOD -> {
                print("Enter the product calories: ")
                val productCalories = readln().toInt()
                FoodCard(name = productName, brand = productBrand, price = productPrice, calories = productCalories)
            }
            ProductType.APPLIANCE -> {
                print("Enter the product wattage: ")
                val productWattage = readln().toInt()
                AppliancesCard(name = productName, brand = productBrand, price = productPrice, wattage = productWattage)
            }
            ProductType.SHOE -> {
                print("Enter the product size: ")
                val productSize = readln().toFloat()
                ShoesCard(name = productName, brand = productBrand, price = productPrice, size  = productSize)
            }
        }
        card.printInfo()
    }
}