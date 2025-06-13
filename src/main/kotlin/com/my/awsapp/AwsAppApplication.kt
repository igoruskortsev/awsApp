package com.my.awsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AwsAppApplication

fun main(args: Array<String>) {
    runApplication<AwsAppApplication>(*args)
}
