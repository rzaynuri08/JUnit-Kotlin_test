package org.example

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
// Kelas CalculatorTest berisi unit test untuk menguji fungsi-fungsi dalam kelas Calculator
class CalculatorTest {
    // menguji apakah kalkulator dapat menambahkan dari dua angka tersebur
    @Test
    fun `Test calculator can add two numbers`() {
        val calculator = Calculator() // Membuat objek kalkulator
        val expected = 10 // Hasil yang diharapkan
        assertEquals(expected, calculator.add(5, 5)) // memastiskan apakah hasil penambahan sesuai apa tidak dengan yang diharapkan
    }
    // menguji apakah kalkulator dapat mengurangkan dari dua angka tersebut
    @Test
    fun `Test calculator can subtract two numbers`() {
        val calculator = Calculator() // Membuat objek kalkulator
        assertEquals(5, calculator.sub(15, 10)) // memastikan apakah hasil pengurangan sesuai apa tidak dengan yang diharapkan
    }
}