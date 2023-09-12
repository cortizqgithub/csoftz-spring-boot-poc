package com.acme.simple.validation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleValidationApplication

fun main(args: Array<String>) {
    runApplication<SimpleValidationApplication>(*args)
}
