package org.example.ecommerce

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// Kelas OrderInteractionTest adalah unit test yang menguji function pada interaksi kelas Order
class OrderInteractionTest {
    private val LAPTOP = "Macbook" // Inisialasi produk laptop
    // Unit test untuk memastikan kapasitas gudang berkurang saat pesanan terpenuhi
    @Test
    fun `test warehouse capacity is reduced on fulfilling order`() {
        val order = Order(LAPTOP, 50) // Membuat pesanan 50 unit produk laptop Mackbook
        val warehouseMock = mock(Warehouse::class.java) // Membuat objek mock Warehouse

        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(0) // Mengatur mock untuk mengembalikan stok Macbook 0
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(true) // Mengatur mock untuk mengembalikan true saat pesanan diisi

        order.fill(warehouseMock) // Memproses pengisian pesanan
        assertTrue(order.isFilled()) // Memastikan pesanan terisi saat proses berlangsung
        assertEquals(0, warehouseMock.getInventory(LAPTOP)) // Memastikan stok gudang berkurang menjadi 0
    }

    // Unit test untuk memastikan kapasitas gudang tidak berkurang ketika pesanan tidak dapat dipenuhi
    @Test
    fun `test warehouse capacity is not reduced when order cannot be fulfilled`() {
        val order = Order(LAPTOP, 51) // Membuat pesanan untuk 51 unit produk laptop Macbook
        val warehouseMock = mock(Warehouse::class.java) // Membuat objek mock Warehouse
        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(50) // Mengatur mock untuk mengembalikan stok Macbook 50
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(false) // Mengatur mock untuk mengembalikan false saat pesanan tidak dapat diisi

        order.fill(warehouseMock) // Memproses pengisian pesanan
        assertFalse(order.isFilled()) // Memastikan pesanan tidak terisi
        assertEquals(50, warehouseMock.getInventory(LAPTOP)) // Memastikan stok gudang tetap 50
    }
}