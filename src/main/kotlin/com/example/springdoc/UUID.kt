package com.example.springdoc

import java.util.*

fun shortId() = UUID.randomUUID().toString().replace("-","").substring(0, 4)
