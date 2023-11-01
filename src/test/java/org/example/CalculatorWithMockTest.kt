package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.opentest4j.AssertionFailedError
import kotlin.test.assertEquals
// Kelas CalculatorWithMockTest berisi unit test yang menggunakan objek mock untuk menguji kelas Calculator
class CalculatorWithMockTest {
    // menguji apakah metode add pada objek mock mengembalikan nilai yang telah di-mock
    @Test
    fun `test mock calculator add method returns mocked value`() {
        val mockCalculator = mock(Calculator::class.java) // Membuat objek mock Calculator
        `when`(mockCalculator.add(5, 5)).thenReturn(20)  // Mengatur mock untuk mengembalikan 20 saat metode add dipanggil dengan parameter 5 dan 5

        val actual = mockCalculator.add(5, 5) // Memanggil metode add pada objek mock
        println("Actual result from mock: $actual") // Mencetak hasil aktual dari objek mock
        assertEquals(expected = 20, actual) // Memastikan hasil yang diharapkan adalah 20 sesuai dengan mock
    }
    // Unit test kedua, menguji apakah metode add pada objek mock tidak mengembalikan nilai untuk kasus yang tidak ditangani
    @Test
    fun `test mock calculator add method does not return a value for unhandled case`() {
        val mockCalculator = mock(Calculator::class.java) // Membuat objek mock Calculator
        `when`(mockCalculator.add(5, 5)).thenReturn(20) // Mengatur mock untuk mengembalikan 20 saat metode add dipanggil dengan parameter 5 dan 5

        val actual = mockCalculator.add(5, 10) // Memanggil metode add pada objek mock dengan parameter yang tidak ditangani oleh mock
        println("Actual result from mock: $actual") // Mencetak hasil aktual dari objek mock
        assertThrows<AssertionFailedError> { assertEquals(expected = 15, actual) } // Memastikan bahwa metode add tidak mengembalikan nilai yang diharapkan dan menghasilkan AssertionFailedError
    }
}