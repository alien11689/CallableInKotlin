package com.blogspot.przybyszd.kotlin

import spock.lang.Specification

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CallableExampleTest extends Specification {

    ExecutorService executorService = Executors.newSingleThreadExecutor()

    CallableExample callableExample = new CallableExample(executorService)

    def 'should submit callable as class instance from kotlin'() {
        expect:
            callableExample.callableAsClassInstance() == 42
    }

    def 'should submit callable as inline implementation from kotlin'() {
        expect:
            callableExample.callableAsInlineImplementation() == 42
    }

    def 'should submit callable as closure from kotlin'() {
        when:
            callableExample.callableAsClosure() == 42
        then:
            thrown(ClassCastException)
    }

    def 'should submit callable as map from kotlin'() {
        when:
            callableExample.callableAsMap() == 42
        then:
            thrown(ClassCastException)
    }

    def 'should submit callable as passed closure from kotlin'() {
        expect:
            callableExample.callableAsPassedLocalFunction() == 42
    }

}
