package com.martamazurkozlowska.superapp

import kotlin.test.Test
import kotlin.test.assertEquals

class ComposeAppCommonTest {

    @Test
    fun example() {
        assertEquals(3, 1 + 2)
    }

    @Test
    fun equals() {
        val result = Class1("text1") === Class1(text = "text1")
        assertEquals(expected = false, actual = result)
    }

    @Test
    fun `let apply also with`() {
        val string = Class1("text").let {
            println(it.text)
            it.text.length
        }

        val objectt = Class1("text").apply {
            println(this.text)
            this.text
        }

        val objecttt = Class1("text").also {
            println(it.text)
        }

        val stringg = with(Class1("text")) {
            this.text
        }
    }

    @Test
    fun `data classes`() {
        val class1 = Class1("text")
        val class11 = Class1("text")
        val copy = class1.copy(text = "text3")
        val class2 = Class2("text")
        val class22 = Class2("text")

        println("111")
        println(class1.hashCode())
        println(class11.hashCode())

        println("222")
        println(class2.hashCode())
        println(class22.hashCode())

        val hashset1 = hashSetOf(class1, class11)
        val hashset2 = hashSetOf(class2, class22)
        println(hashset1)
        println(hashset2)

        assertEquals(expected = true, actual = Class1("text") == Class1("text"))
        assertEquals(expected = false, actual = Class2("text") == Class2("text")) // FALSE
    }

    @Test
    fun `sealed classes`() {
        val content = ViewState.Content("loaded successfully")
        val error = ViewState.Error("no internet")

        val viewState: ViewState = content// collect as state with lifecycle in compose, then use

        when (viewState) {
            is ViewState.Content -> { /* ContentView() */
            }

            is ViewState.Error   -> { /* ErrorView() */
            }

            is ViewState.Loading -> println("Loading")
        }
    }
}

data class Class1(
    val text: String,
)

class Class2(
    val text: String,
)

enum class EnumAnimal {
    DOG,
    CAT,
    BIRD
}

sealed class ViewState(val retryAttempts: Int = 0) {
    data class Content(val data: String) : ViewState()
    data class Error(val message: String) : ViewState()
    object Loading : ViewState()
}

