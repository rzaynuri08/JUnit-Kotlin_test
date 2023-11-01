package io.automationhacks.ecommerce

import org.example.ecommerce.Order
import org.example.ecommerce.Warehouse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// Kelas OrderStateTest berisi unit test untuk menguji keadaan pesanan dan pengaruhnya terhadap kapasitas gudang
class OrderStateTest {
    private val LAPTOP = "Macbook" // Inisialisasi produk laptop
    private val MOUSE = "Logitech Mouse" // Inisialisasi produk mouse
    private val warehouse = Warehouse()

    // Fungsi setup yang dijalankan sebelum setiap unit test untuk menginisialisasi stok produk di gudang
    @BeforeEach
    fun setUp() {
        warehouse.add(LAPTOP, 50) // Menambahkan 50 unit produk laptop Macbook ke gudang
        warehouse.add(MOUSE, 20)  // Menambahkan 20 unit produk mouse Logitech Mouse ke gudang
    }
    // Unit test untuk memastikan pesanan terpenuhi jika kapasitas di gudang mencukupi
    @Test
    fun `test order is fulfilled if capacity in warehouse is sufficient`() {
        val order = Order(LAPTOP, 20) // Membuat pesanan untuk 20 unit laptop Macbook
        order.fill(warehouse) // Mengisi pesanan dari gudang
        assertTrue(order.isFilled()) // Memastikan pesanan terisi
        assertEquals(30, warehouse.getInventory(LAPTOP)) // Memastikan stok Macbook di gudang berkurang menjadi 30
    }
    // Unit test untuk memastikan pesanan tidak terpenuhi jika kapasitas di gudang tidak mencukupi
    @Test
    fun `test order is not fulfilled if capacity in warehouse is insufficient`() {
        val order = Order(MOUSE, 21) // Membuat pesanan untuk 21 unit Logitech Mouse
        order.fill(warehouse) // Mengisi pesanan dari gudang
        assertFalse(order.isFilled()) // Memastikan pesanan tidak terisi
        assertEquals(20, warehouse.getInventory(MOUSE)) // Memastikan stok Logitech Mouse di gudang tetap 20
    }

}