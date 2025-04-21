fun main() {
    open class PowerTool(
        val brand: String,
        val model: String,
    ) {
        open fun turnOn() {
            println("Электроинструмент включен")
        }
    }

    class Drill(
        brand: String,
        model: String,
        val drillChuckDiameter: Int,
    ): PowerTool(brand, model) {
        override fun turnOn() {
            println("Дрель сверлит")
        }
    }

    class AngleGrinder(
        brand: String,
        model: String,
        val discDiameter: Int,
    ): PowerTool(brand, model) {
        override fun turnOn() {
            println("УШМ режет")
        }
    }

    class ChainSaw(
        brand: String,
        model: String,
        val chainSawTireLength: Int,
    ): PowerTool(brand, model) {
        override fun turnOn() {
            println("Цепная пила пилит")
        }
    }

    fun task() {
        val drill: Drill = Drill("brand", "model", 0)
        val angleGrinder: AngleGrinder = AngleGrinder("brand", "model", 0 )
        val chainSaw: ChainSaw = ChainSaw("brand", "model", 0)

        val powerTools: List<PowerTool> = listOf<PowerTool>(drill, angleGrinder, chainSaw)

            for(powerTool in powerTools){
                powerTool.turnOn()
            }
    }
}