package org.d3if3141.asessment2mobpro.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3141.asessment2mobpro.model.Peminjaman

class DetailViewModel: ViewModel() {

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
