package com.blogspot.przybyszd.kotlin

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService

class CallableExample(private val executorService: ExecutorService) {

    fun callableAsClassInstance() = executorService.submit(MyJob()).get()

    fun callableAsInlineImplementation() = executorService.submit(Callable<Int> { 42 }).get()

    fun callableAsClosure() =
            executorService.submit({ 42 } as Callable<Int>).get()

    // It does not compile
    //    private fun callMe() = 42
    //    fun callableAsPassedFunction(): Int? {
    //        return executorService.submit(::callMe).get()
    //    }

    fun callableAsMap() =
            executorService.submit(mapOf("call" to { 42 }) as Callable<Int>).get()

    private val callMe = { 42 }

    fun callableAsPassedLocalFunction(): Int? {
        return executorService.submit(callMe).get()
    }
}