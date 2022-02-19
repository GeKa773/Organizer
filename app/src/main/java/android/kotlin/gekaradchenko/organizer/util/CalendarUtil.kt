package android.kotlin.gekaradchenko.organizer.util

import java.util.*

class CalendarUtil {

    private val calendar = Calendar.getInstance()

    // ------------------ високосный год ------------------
    private fun isBissextile(): Boolean {
        val y: Int = calendar.get(Calendar.YEAR)
        return y % 4 == 0 && y % 100 != 0 || y % 400 == 0
    }

    // --------- максимальное число дней в месяце ---------
     fun maxMonth(): Int {
        val month = calendar[Calendar.MONTH]
        val days = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        if (month == 1 && isBissextile()) days[1] = 29
        return days[month]
    }

    fun getCalendar(): Calendar = calendar

    // ------- с какого дня недели начинается месяц -------
    private fun firstDay(): Int {
        var dayWeek = calendar[Calendar.DAY_OF_WEEK]
        var day = calendar[Calendar.DAY_OF_MONTH]
        while (day-- > 0) if (--dayWeek < 1) dayWeek = 7
        return dayWeek
    }

    // ---------------------- шапка ----------------------
    private fun header() {
        val months = arrayOf(
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        )
        val month = calendar[Calendar.MONTH]
        val year = calendar[Calendar.YEAR]
        System.out.printf("%14s, %d\n", months[month], year)
        println("  Пн  Вт  Ср  Чт  Пт  Сб  Вс")
    }

    // ----------------------------------------------------

    fun arrayDay() {
        header()
        var c: Int
        var i = 1
        val first = firstDay()
        val maxDay = maxMonth()
        c = 1
        while (c < first) {
            print("    ")
            ++c
        }
        while (i <= maxDay) {
            var d = if (c++ == first) first else 1
            while (d++ <= 7 && i <= maxDay) System.out.printf("%4d", i++)
            println()
        }
    }
}