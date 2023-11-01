package org.example.ecommerce

// Kelas ini berfungsi untuk mewakili pesanan atau order
class Order(private val product: String, private val quantity: Int) {
    // Deklarasi properti warehouse yang berfungsi untuk tempat  penyimpanan produk
    private lateinit var warehouse: Warehouse
    // Deklarasi properti IsFilled yang digunakan untuk menyimpan status pesanan
    private var isFilled: Boolean = false

    // Function fill digunakan untuk mengisi pesanan produk dari gudang
    fun fill(warehouse: Warehouse) {
        this.warehouse = warehouse
        isFilled = this.warehouse.remove(product, quantity)
    }

    // Function isFilled digunakan untuk memeriksa apakah pesanan telah diisi atau belum
    fun isFilled(): Boolean {
        return isFilled
    }
}