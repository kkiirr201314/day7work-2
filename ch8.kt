const val  TAVERN_NAME = "Taerny's Folly"

var playerGold = 10
var playerSilver = 10

fun main() {
    placeOrder("shandy ,Dragon's Breath, 5.91")
}
fun performurchase() {
    displayBalance()
}

private  fun displayBalance() {
    println("玩家錢包餘額: Gold: $playerGold , Silver: $playerSilver")
}



private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")){
        when (it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            "A" -> "4"
            "E" -> "3"
            "I" -> "1"
            "O" -> "0"
            "U" -> "|_|"
            else -> it.value
        }
    }

private  fun placeOrder(menuData: String){
    val indexOfAppstrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfAppstrophe)
    println("Madrigal對 $tavernMaster 說了他們訂的酒水。 ")
    //  println(menuData)
    //  val data = menuData.split(',')
    //  val type = data[0]
    //  val name = data[1]
    //  val price = data[2]
    val (type,name,price) = menuData.split(',')
    val message = "Madrigal 買了一杯 $name ($type) 花了 $price."
    println(message)
    performurchase()

    //  val phrase = "Ah, dlicious $name!"
    //  println("Madrigal 驚呼道: ${toDragonSpeak(phrase)}")
    val phrase = if (name == "Dragon's Breath"){
        "Madrigal 驚呼道: ${toDragonSpeak("Ah, dlicious $name!")}"
    } else {
        "Madrigal 說道: 感謝 $name ."
    }
    println(phrase)
}