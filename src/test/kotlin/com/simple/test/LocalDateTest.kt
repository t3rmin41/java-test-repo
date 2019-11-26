package com.simple.test

import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit


class LocalDateTest {

    @Test
    fun testLocalDateRange() {
        val year1StartDate = LocalDate.of(2019, 5, 22)
        var year1LastDate = year1StartDate.plusMonths(11).withDayOfMonth(year1StartDate.plusMonths(11).lengthOfMonth())

        var year2StartDate = year1LastDate.plusDays(1)
        var year2LastDate = year2StartDate.plusMonths(11).withDayOfMonth(year2StartDate.plusMonths(11).lengthOfMonth())

        var year3StartDate = year2LastDate.plusDays(1)
        var year3LastDate = year3StartDate.plusMonths(11).withDayOfMonth(year3StartDate.plusMonths(11).lengthOfMonth())

        val numOfMonthsBetweenYear1Dates = ChronoUnit.MONTHS.between(year1StartDate, year1LastDate)
        val numOfMonthsBetweenYear2Dates = ChronoUnit.MONTHS.between(year2StartDate, year2LastDate)
        val numOfMonthsBetweenYear3Dates = ChronoUnit.MONTHS.between(year3StartDate, year3LastDate)

        val year1Timestamps = ArrayList<Instant>()
        val year2Timestamps = ArrayList<Instant>()
        val year3Timestamps = ArrayList<Instant>()

        for (i in 0..numOfMonthsBetweenYear1Dates) {
            val monthStartTimestamp: Instant
            if (0L == i) {
                monthStartTimestamp = year1StartDate.plusMonths(i).atTime(0, 0, 0).atZone(ZoneOffset.UTC).toInstant()
            } else {
                monthStartTimestamp = year1StartDate.plusMonths(i).withDayOfMonth(1)
                                        .atTime(0, 0, 0).atZone(ZoneOffset.UTC).toInstant()
            }
            val monthEndTimestamp = year1StartDate.plusMonths(i)
                                                .withDayOfMonth(year1StartDate.plusMonths(i).lengthOfMonth())
                                                .atTime(23, 59, 59).atZone(ZoneOffset.UTC).toInstant()
            year1Timestamps.add(monthStartTimestamp)
            year1Timestamps.add(monthEndTimestamp)
        }

        for (i in 0..numOfMonthsBetweenYear2Dates) {
            val monthStartTimestamp: Instant
            if (0L == i) {
                monthStartTimestamp = year2StartDate.plusMonths(i).atTime(0, 0, 0).atZone(ZoneOffset.UTC).toInstant()
            } else {
                monthStartTimestamp = year2StartDate.plusMonths(i).withDayOfMonth(1)
                        .atTime(0, 0, 0).atZone(ZoneOffset.UTC).toInstant()
            }
            val monthEndTimestamp = year2StartDate.plusMonths(i)
                    .withDayOfMonth(year2StartDate.plusMonths(i).lengthOfMonth())
                    .atTime(23, 59, 59).atZone(ZoneOffset.UTC).toInstant()
            year2Timestamps.add(monthStartTimestamp)
            year2Timestamps.add(monthEndTimestamp)
        }

        for (i in 0..numOfMonthsBetweenYear3Dates) {
            val monthStartTimestamp: Instant
            if (0L == i) {
                monthStartTimestamp = year3StartDate.plusMonths(i).atTime(0, 0, 0).atZone(ZoneOffset.UTC).toInstant()
            } else {
                monthStartTimestamp = year3StartDate.plusMonths(i).withDayOfMonth(1)
                        .atTime(0, 0, 0).atZone(ZoneOffset.UTC).toInstant()
            }
            val monthEndTimestamp = year3StartDate.plusMonths(i)
                    .withDayOfMonth(year3StartDate.plusMonths(i).lengthOfMonth())
                    .atTime(23, 59, 59).atZone(ZoneOffset.UTC).toInstant()
            year3Timestamps.add(monthStartTimestamp)
            year3Timestamps.add(monthEndTimestamp)
        }

        println(year1StartDate)
    }

}