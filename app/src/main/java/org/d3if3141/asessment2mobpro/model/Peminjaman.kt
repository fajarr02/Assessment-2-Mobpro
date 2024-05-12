package org.d3if3141.asessment2mobpro.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pinjaman")
data class Peminjaman(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val jumlah: String,
    val tenggat: String,
    val tanggal: String
)
