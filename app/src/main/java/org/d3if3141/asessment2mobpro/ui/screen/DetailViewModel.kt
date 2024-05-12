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

    fun getPeminjaman(id: Long): Peminjaman {
        return Peminjaman(
            id,
            "Zaki $id",
            "Rp 100000$id",
            "6 Bulan",
            "2024-05-$id 12:34:56"
        )
    }
}
