package corporation

import java.io.File

class Accountant (
    name: String,
    age: Int = 0
): Worker(name = name, age = age) {

    val file = File("product_cards.txt")

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
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun removeProductCard(){
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()

        for (card in cards) {
            if(card.name == name) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    fun saveProductCardToFile(productCard: ProductCard){
        file.appendText("${productCard.name}%")
        file.appendText("${productCard.brand}%")
        file.appendText("${productCard.price}%")

        when(productCard) {
            is FoodCard -> {
                val productCalories = productCard.calories
                file.appendText("$productCalories%${ProductType.FOOD}\n")
            }
            is AppliancesCard -> {
                val productWattage = productCard.wattage
                file.appendText("$productWattage%${ProductType.APPLIANCE}\n")
            }
            is ShoesCard -> {
                val productSize = productCard.size
                file.appendText("$productSize%${ProductType.SHOE}\n")
            }
        }
    }

    fun loadAllCards():MutableList<ProductCard> {
        val cards:MutableList<ProductCard> = mutableListOf<ProductCard>()
        val content = file.readText().trim()
        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val prorerties = cardAsString.split("%")
            val name = prorerties[0]
            val brand = prorerties[1]
            val price = prorerties[2].toInt()
            val type = prorerties.last()
            val productType = ProductType.valueOf(type)

            val productCard = when(productType) {
                ProductType.FOOD -> {
                    val calories = prorerties[3].toInt()
                    FoodCard(name, brand, price, calories)
                }
                ProductType.APPLIANCE -> {
                    val wattage = prorerties[3].toInt()
                    AppliancesCard(name, brand, price, wattage)
                }
                ProductType.SHOE -> {
                    val size = prorerties[3].toFloat()
                    ShoesCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun showAllItems(){
        val content = file.readText().trim()

        if (content.isEmpty()) {
            return
        }

        val cardsAsString = content.split("\n")
        for (cardAsString in cardsAsString) {
            val prorerties = cardAsString.split("%")
            val name = prorerties[0]
            val brand = prorerties[1]
            val price = prorerties[2].toInt()
            val type = prorerties.last()
            val productType = ProductType.valueOf(type)

            val productCard = when(productType) {
                ProductType.FOOD -> {
                    val calories = prorerties[3].toInt()
                    FoodCard(name, brand, price, calories)
                }
                ProductType.APPLIANCE -> {
                    val wattage = prorerties[3].toInt()
                    AppliancesCard(name, brand, price, wattage)
                }
                ProductType.SHOE -> {
                    val size = prorerties[3].toFloat()
                    ShoesCard(name, brand, price, size)
                }
            }
            productCard.printInfo()
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
        file.appendText("$productName%")
        print("Enter the product brand: ")
        val productBrand = readln()
        file.appendText("$productBrand%")
        print("Enter the product price: ")
        val productPrice = readln().toInt()
        file.appendText("$productPrice%")

        when(productType) {
            ProductType.FOOD -> {
                print("Enter the product calories: ")
                val productCalories = readln().toInt()
                file.appendText("$productCalories%")
            }
            ProductType.APPLIANCE -> {
                print("Enter the product wattage: ")
                val productWattage = readln().toInt()
                file.appendText("$productWattage%")
            }
            ProductType.SHOE -> {
                print("Enter the product size: ")
                val productSize = readln().toFloat()
                file.appendText("$productSize%")
            }
        }
        file.appendText("$productType\n")
    }
}