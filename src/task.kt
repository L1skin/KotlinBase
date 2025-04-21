fun main() {
    data class DeliveryObject (
        val length: Int,
        val width: Int,
        val height: Int,
        val weight: Double
    ){}


    data class Pack (
        val length: Int,
        val width: Int,
        val height: Int,
        var type: String = "Картонная коробка",
        val weight: Double
    ){}

    data class Cargo (
        val length: Int,
        val width: Int,
        val height: Int,
        val typePackaging: String,
        val netWeight: Double,
        val grossWeight: Double
    ){
        fun printInfo() {
            print(
                """Длина: $length
                   Ширина: $width
                   Высота: $height
                   Тип упаковки: $typePackaging
                   Вес нетто: $netWeight
                   Вес брутто: $grossWeight"""
            )
        }
    }


    class Warehouse (){
        fun getPack (deliveryObject: DeliveryObject):Pack {
            val pack = Pack(length = deliveryObject.length + 1,
                width = deliveryObject.width + 1,
                height = deliveryObject.height + 1,
                weight = 0.3)
            return pack
        }


        fun packCargo (deliveryObject: DeliveryObject):Cargo {
            val pack = getPack(deliveryObject)
            val cargo = Cargo(
                length = pack.length,
                width = pack.width,
                height = pack.height,
                typePackaging = pack.type,
                netWeight = deliveryObject.weight,
                grossWeight = deliveryObject.weight + pack.weight
            )
            return cargo
        }
    }


    fun task() {
        val data = readln().split(" ")
        val deliveryObject = DeliveryObject(
            length = data[0].toInt(),
            width = data[1].toInt(),
            height = data[2].toInt(),
            weight = data[3].toDouble()
        )
        val warehouse = Warehouse()
        val packedCargo = warehouse.packCargo(deliveryObject)
        packedCargo.printInfo()
    }
}