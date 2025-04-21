package corporation

class FoodCard(
    name: String,
    brand: String,
    price: Int,
    val calories: Int
): ProductCard(
    name = name,
    brand = brand,
    price = price
) {
    override fun printInfo() {
        super.printInfo()
        println("Calories: $calories")
    }
}