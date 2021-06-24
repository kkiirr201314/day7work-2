import kotlin.math.roundToInt

const val  TAVERN_NAME = "Taerny's Folly"

var playerGold = 0
var playerSilver = 0
var playerDrogonCoin = 5
var totalPurse = playerDrogonCoin * 1.43

fun main() {
    placeOrder("shandy ,Dragon's Breath, 5.91")
}
fun performPurchase(price: Double) {
    displayBalance()
    println("玩家錢包總餘額: ${"%.2f".format(totalPurse)} 個金幣")
    if (totalPurse >= price) {
        println("購買品項需要: $price 個金幣")
        totalPurse = (totalPurse - price)/1.43
        playerGold = playerGold - "%.0f".format(price).toInt()
        playerSilver = (totalPurse % 1 * 100).roundToInt()
        println("玩家購買後錢包餘額: dragon: ${"%.4f".format(totalPurse)}")
    } else {
        println("抱歉，錢包裡面錢不夠了！！！")
    }
}
private  fun displayBalance() {
    println("玩家錢包餘額: dragan: $playerDrogonCoin")
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
    performPurchase(price.toDouble())

    //  val phrase = "Ah, dlicious $name!"
    //  println("Madrigal 驚呼道: ${toDragonSpeak(phrase)}")
    val phrase = if (name == "Dragon's Breath"){
        "Madrigal 驚呼道: ${toDragonSpeak("Ah, dlicious $name!")}"
    } else {
        "Madrigal 說道: 感謝 $name ."
    }
    println(phrase)
}