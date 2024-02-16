import kotlin.random.Random

fun main() {
    val cities = listOf("Бийск", "Барнаул", "Новосибирск", "Омск", "Томск", "Красноярск", "Иркутск", "Кемерово", "Новокузнецк", "Братск", "Улан-Удэ", "Чита", "Курск", "Владивосток", "Хабаровск")

    var continueWork = true

    while (continueWork) {
        println("Если хотите завершить работу (EXIT), если составить поезд (нажмите Enter): ")
        when (readLine()?.toUpperCase()) {
            "" -> createTrainPlan(cities)
            "EXIT" -> continueWork = false
            else -> println("Неверный ввод. Попробуйте еще раз.")
        }
    }
}

fun createTrainPlan(cities: List<String>) {
    val origin = cities.random()
    var destination = origin
    while (destination == origin) {
        destination = cities.random()
    }
    println("Шаг 1: Создано направление - $origin - $destination")

    val passengers = Random.nextInt(5, 201)
    println("Шаг 2: Продано билетов ($passengers)")

    val train = formTrain(passengers)
    println("Шаг 3: Сформирован поезд")
    println("Шаг 4: Поезд отправлен.\n")
    println("Поезд $origin - $destination, состоящий из ${train.size} вагонов отправлен.")
    var remainingPassengers = passengers
    for ((index, capacity) in train.withIndex()) {
        val passengersInWagon = if (remainingPassengers >= capacity) capacity else remainingPassengers
        println("Вагон ${index + 1}: Вместимость - $capacity, Пассажиров - $passengersInWagon")
        remainingPassengers -= passengersInWagon
    }
    println("\n")
}

fun formTrain(passengers: Int): List<Int> {
    var trainCapacity = 0
    val train = mutableListOf<Int>()
    while (trainCapacity < passengers) {
        val wagonCapacity = Random.nextInt(5, 26)
        train.add(wagonCapacity)
        trainCapacity += wagonCapacity
    }
    return train
}