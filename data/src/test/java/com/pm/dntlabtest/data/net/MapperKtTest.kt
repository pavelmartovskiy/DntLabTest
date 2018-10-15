package com.pm.dntlabtest.data.net

import com.pm.dntlabtes.domain.model.Category
import org.junit.Assert.*
import org.junit.Test

class MapperKtTest {
    @Test
    fun `should return Category`() {
        val source = CategoryData(1L, "Name", "Url")
        val actual = source.map()
        compare(source, actual)
    }

    private fun compare(source: CategoryData, actual: Category) {
        assertEquals(source.id, actual.id)
        assertEquals(source.name, actual.name)
        assertEquals(source.icon, actual.icon)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw IllegalArgumentException id is null`() {
        val source = CategoryData(null, "Name", "Url")
        source.map()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw IllegalArgumentException name is null`() {
        val source = CategoryData(null, "Name", "Url")
        source.map()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `should throw IllegalArgumentException icon is null`() {
        val source = CategoryData(null, "Name", "Url")
        source.map()
    }


    @Test
    fun `should return Category List`() {
        val source = listOf(
                CategoryData(1L, "Name1", "Url1"),
                CategoryData(2L, "Name2", "Url2"),
                CategoryData(3L, "Name3", "Url3")
        )
        val actual = source.mapCategoryDataList()

        actual.forEachIndexed { index, category ->
            compare(source = source[index], actual = category)
        }
    }


    @Test(expected = IllegalArgumentException::class)
    fun `should throw IllegalArgumentException second element's name is null` () {
        val source = listOf(
                CategoryData(1L, "Name1", "Url1"),
                CategoryData(2L, null, "Url2"),
                CategoryData(3L, "Name3", "Url3")
        )
        val actual = source.mapCategoryDataList()

        actual.forEachIndexed { index, category ->
            compare(source = source[index], actual = category)
        }
    }
}