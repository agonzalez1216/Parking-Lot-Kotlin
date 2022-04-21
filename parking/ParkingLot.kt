package parking

data class Car(val registration: String, val color: String)

class ParkingLot {
    private var parkingSpots: MutableList<Car?> = mutableListOf()
    fun status() {
        if (parkingSpots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }

        val noOfOccupiedSpots = parkingSpots.count { car -> car != null }
        if (noOfOccupiedSpots == 0) {
            println("Parking lot is empty.")
            return
        }

        for (car in parkingSpots) {
            if (car != null) {
                println("${parkingSpots.indexOf(car) + 1} ${car.registration} ${car.color}")
            }
        }
    }

    fun create(){
        val size = scanner.nextInt()
        println("Created a parking lot with $size spots.")
        parkingSpots = MutableList(size) { null }
    }

    fun leave() {
        if (parkingSpots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }

        val spot = scanner.nextInt()
        if (parkingSpots[spot - 1] == null) {
            println("There is no car in spot $spot.")
        } else {
            parkingSpots[spot - 1] = null
            println("Spot $spot is free.")
        }
    }

    fun park() {
        if (parkingSpots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }

        val firstFreeSpot = parkingSpots.indexOfFirst { car -> car == null }
        if (firstFreeSpot < 0) {
            println("Sorry, the parking lot is full.")
            return
        }

        val registration = scanner.next()
        val color = scanner.next()

        parkingSpots[firstFreeSpot] = Car(registration, color)

        println("$color car parked in spot ${firstFreeSpot + 1}.")
    }

    fun spotByColor() {
        if (parkingSpots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        val color = scanner.next()
        println(parkingSpots.withIndex()
            .filter { car -> car.value?.color.equals(color, ignoreCase = true) }
            .joinToString { car -> "${car.index + 1}" }
            .ifEmpty { "No cars with color $color were found." }
        )
    }

    fun regByColor() {
        if (parkingSpots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        val color = scanner.next()
        println(parkingSpots.withIndex()
            .filter { car -> car.value?.color.equals(color, ignoreCase = true) }
            .joinToString { car -> "${car.value?.registration}" }
            .ifEmpty { "No cars with color $color were found." }
        )
    }

    fun spotByReg() {
        if (parkingSpots.isEmpty()) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        val registration = scanner.next()
        println(parkingSpots.withIndex()
            .filter { car -> car.value?.registration == registration }
            .joinToString { car -> "${car.index + 1}" }
            .ifEmpty { "No cars with registration number $registration were found." }
        )
    }
}