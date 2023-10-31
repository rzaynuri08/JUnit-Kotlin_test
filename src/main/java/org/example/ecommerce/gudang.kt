package org.example.ecommerce

// Kelas Warehouse digunakan untuk mengelola stok produk dalam gudang
class Warehouse {
    // Properti warehouse adalah sebuah hashmap yang digunakan untuk menyimpan stok produk
    private val warehouse: HashMap<String, Int> = hashMapOf()
    // Fungsi add digunakan untuk menambahkan produk ke stok gudang dengan jumlah tertentu
    fun add(product: String, quantity: Int) {
        warehouse[product] = quantity
    }

    // Function remove digunakan untuk mengurangi stok produk yang berada di gudang berdasarkan jumlah yang diinginkan
    fun remove(product: String, quantity: Int): Boolean {
        // jika ingin mencari produk tetapi produk yang diinginkan tidak ada dalam gudang maka cetak "produk tidak tersedia di gudang"
        if (warehouse.contains(product).not()) {
            println("Product not found in warehouse")
            return false
        }
        // jika jumlah produk adalah 0 maka cetak "tidak ada item dari produk ini di gudang"
        if (warehouse[product] == 0) {
            println("No items for this product in the warehouse")
            return false
        }
        // jika produk kurang dari jumlah yang diinginkan maka cetak "Tidak cukup barang di gudang"
        if (warehouse[product]!! < quantity) {
            println("Not enough items in the warehouse")
            return false
        }
        val currentQty = warehouse[product]
        val newQty = currentQty!!.minus(quantity)
        warehouse[product] = newQty
        return true
    }

    // Function getInventory berfungsi untuk melihat stok yang ada berdasarkan nama produk
    fun getInventory(product: String): Int? {
        return warehouse.get(product)
    }
}