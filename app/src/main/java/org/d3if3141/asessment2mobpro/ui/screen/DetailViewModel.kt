package org.d3if3141.asessment2mobpro.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3141.asessment2mobpro.database.PinjamanDao
import org.d3if3141.asessment2mobpro.model.Peminjaman
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val  dao: PinjamanDao): ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, jumlah: String, tenggat: String) {
        val peminjaman = Peminjaman(
            tanggal = formatter.format(Date()),
            nama = nama,
            jumlah = jumlah,
            tenggat = tenggat
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(peminjaman)
        }
    }

    suspend fun getPeminjaman(id: Long): Peminjaman? {
        return dao.getPeminjamanById(id)
    }


    fun update(id: Long, nama: String, jumlah: String, tenggat: String) {
        val peminjaman = Peminjaman(
            id = id,
            tanggal = formatter.format(Date()),
            nama = nama,
            jumlah = jumlah,
            tenggat = tenggat,
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(peminjaman)
        }
    }

        fun delete(id: Long) {
            viewModelScope.launch(Dispatchers.IO) {
                dao.deleteById(id)
            }
        }
}
