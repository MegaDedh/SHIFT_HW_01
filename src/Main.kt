fun main() {

    val cityName = getCity()
    val temperature = getTemperature(cityName)
    println("$cityName $temperature")

    val city = City(cityName, temperature)
    println("В городе ${city.name} сейчас ${feelingTemperature(city.temperature)}")
}

private fun getCity(): String {
    println("Напиши название города:")

    val city = readLine()

    if (city.isNullOrBlank()) {
        throw error("Empty cityName")
    } else {
        return city
    }

}

private fun getTemperature(city: String): Float {
    println(
        "Сколько градусов цельсия в $city ?"
    )
    return readLine()?.toFloatOrNull() ?: throw error("Invalid temperature")
}

private fun feelingTemperature(temperature: Float): String =
    when (temperature) {
        in -50f..15f -> "холодно"
        in 15f..25f -> "комфортно"
        in 25f..50f -> "жарко"
        else -> "адище"
    }