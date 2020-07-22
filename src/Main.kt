fun main() {

    val cityName = getCity()
    val temperature = getTemperature(cityName)
    println("$cityName $temperature")

    val city = City(cityName, temperature)
    val feeling = feelingTemperature(city.temperature).feel
    println("В городе ${city.name} сейчас $feeling")
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

private fun feelingTemperature(temperature: Float): FeelingWeather =
    when (temperature) {
        in -50f..15f -> FeelingWeather.COLD
        in 15f..25f -> FeelingWeather.COMFORT
        in 25f..50f -> FeelingWeather.HOT
        else -> FeelingWeather.HELL
    }
