package com.acme.validate

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestPocValidateApplication

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestPocValidateApplication::class).run(*args)
}
