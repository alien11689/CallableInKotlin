package com.blogspot.przybyszd.kotlin

import java.util.concurrent.Callable

class MyJob : Callable<Int> {
    override fun call() = 42
}