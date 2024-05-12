package org.d3if3141.asessment2mobpro.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3141.asessment2mobpro.model.Peminjaman

class MainViewModel : ViewModel() {

    val data = getDataDummy()

    private fun getDataDummy(): List<Peminjaman> {
        val data = mutableListOf<Peminjaman>()
        for (i in 29 downTo 20){
            data.add(
                Peminjaman(
                    i.toLong(),
                    "Zaki $i",
                    "Rp 100000$i",
                    "3 Bulan",
                    "2024-05-$i 12:34:56"
                )
            )
        }
        return data
    }

}
