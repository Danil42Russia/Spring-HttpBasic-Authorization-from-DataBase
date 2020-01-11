package ru.danil42russia.hbfdb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HbfdbApplication

fun main(args: Array<String>) {
	runApplication<HbfdbApplication>(*args)
}
