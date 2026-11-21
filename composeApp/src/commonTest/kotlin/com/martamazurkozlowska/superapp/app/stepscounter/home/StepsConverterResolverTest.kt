package com.martamazurkozlowska.superapp.app.stepscounter.home

import com.martamazurkozlowska.superapp.ui.components.sexitem.GenderUiModel
import kotlin.test.Test
import kotlin.test.assertEquals

class StepsConverterResolverTest {

    private val resolver = StepsConverterResolver()

    @Test
    fun `GIVEN 1000 steps and male WHEN get kilometers sum THEN correct result`() {
        val result = resolver.getKilometersSum(1000, GenderUiModel.Male)
        assertEquals(expected = 0.8f, actual = result)
    }

    @Test
    fun `GIVEN 1000 steps and female WHEN get kilometers sum THEN correct result`() {
        val result = resolver.getKilometersSum(1000, GenderUiModel.Female)
        assertEquals(expected = 0.66f, actual = result)
    }
}