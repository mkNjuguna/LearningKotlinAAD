import kotlin.math.PI
import kotlin.math.sqrt

fun main(){
    //Instantiation of SquareCabin()
    val squareCabin = SquareCabin(6, 50.0)
    with(squareCabin){
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    //Instantiation of RoundHut()
    val roundHut = RoundHut(3, 10.0)
    with(roundHut){
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    //Instantiation of RoundTower()
    val roundTower = RoundTower(4, 15.5)
    with(roundTower){
        println("\nRound Tower\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")

    }

}
//The main abstract parent class
abstract class Dwelling(private var residents: Int){
     abstract val  buildingMaterial: String
     abstract val capacity: Int

     fun hasRoom(): Boolean {
         return residents < capacity
     }

    abstract fun floorArea(): Double

    fun getRoom(){
        if (capacity > residents){
            residents++
            println("You got a room!")
        } else{
            println("Sorry, at capacity and no rooms left.")
        }
    }
 }
//Subclass of Dwelling()
class SquareCabin(residents: Int, val length: Double): Dwelling(residents){
    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double {
        return length * length
    }
}

//Subclass of Dwelling()
open class RoundHut(residents: Int, val radius: Double): Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double{
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)

    }

}

//Subclass of Dwelling()
class RoundTower(residents: Int, radius: Double, val floors: Int = 2): RoundHut(residents, radius){
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }

}
