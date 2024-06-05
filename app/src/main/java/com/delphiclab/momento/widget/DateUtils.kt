package com.delphiclab.momento.widget

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

object DateUtils {
    fun getCurrentDay(currentDate: LocalDate): String {
        return currentDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
    }

    fun getCurrentMonth(currentDate: LocalDate): String {
        return currentDate.month.getDisplayName(TextStyle.FULL, Locale.getDefault())
    }

    fun getFormattedCurrentDate(currentDate: LocalDate): String {
        val formatter = DateTimeFormatter.ofPattern("dd MMM", Locale.getDefault())
        return currentDate.format(formatter)
    }


}