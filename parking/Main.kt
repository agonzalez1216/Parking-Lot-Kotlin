package parking

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val parkingLot = ParkingLot()
    while (true) {
        val action = scanner.next()
        when (action) {
            "exit" -> break
            "status" -> parkingLot.status()
            "create" -> parkingLot.create()
            "leave" -> parkingLot.leave()
            "park" -> parkingLot.park()
            "spot_by_color" -> parkingLot.spotByColor()
            "reg_by_color" -> parkingLot.regByColor()
            "spot_by_reg" -> parkingLot.spotByReg()
        }
    }
}

