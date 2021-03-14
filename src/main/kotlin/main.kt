fun main(){
    val PrevPaySum = 0.00
    val CardType = "MasterCard"
    val CurrentAmmount = 11350.00

    when(CardType){
        "Vk Pay"-> {
            when {
                ((CurrentAmmount <= 15000.00) && (CurrentAmmount + PrevPaySum <= 40000.00)) -> {
                      println("comissiya $CardType ($CurrentAmmount): " + calculatePay(PrevPaySum,CardType,CurrentAmmount))
                }
                else -> println("$CardType maksimalnaya summa perevoda VK Pay 15000 za raz i 40000 za mesyac")
            }
         }
        else -> {
            when {
                ((CurrentAmmount <= 150000.00) && (CurrentAmmount + PrevPaySum <= 600000.00)) -> {
                    println("comissiya $CardType ($CurrentAmmount): " + calculatePay(PrevPaySum,CardType,CurrentAmmount))
                }
            }
        }
    }
    //println("тест");
 }




fun calculatePay(prevPay:Double=0.00,cardT:String,currAmount:Double):Double{
    val commision:Double = when(cardT){
        "Vk Pay" -> 0.00
        "MasterCard","Maestro" -> {
            when {
                (currAmount + prevPay) < 75000 -> 0.0
                else -> 0.06
            }
        }
        "Visa","Mir" -> 0.075
        else -> 0.00
    }
    if(commision>0.0)
        return commision*currAmount
    else
        return 0.0
}