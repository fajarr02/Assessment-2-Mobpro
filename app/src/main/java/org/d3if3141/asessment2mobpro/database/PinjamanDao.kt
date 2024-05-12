package org.d3if3141.asessment2mobpro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3141.asessment2mobpro.model.Peminjaman


@Dao
interface PinjamanDao {

    @Insert
    suspend fun insert(peminjaman: Peminjaman)

    @Update
    suspend fun update(peminjaman: Peminjaman)

    @Query("SELECT * FROM pinjaman ORDER BY tanggal DESC")
    fun getPeminjaman(): Flow<List<Peminjaman>>

    @Query("SELECT * FROM pinjaman WHERE id = :id")
    suspend fun getPeminjamanById(id: Long): Peminjaman?

    @Query("DELETE FROM pinjaman WHERE id = :id")
    suspend fun deleteById(id: Long)

}
