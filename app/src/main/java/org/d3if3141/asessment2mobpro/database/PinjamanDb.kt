package org.d3if3141.asessment2mobpro.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3141.asessment2mobpro.model.Peminjaman

@Database(entities = [Peminjaman::class], version = 1, exportSchema = false)
abstract class PinjamanDb : RoomDatabase() {

    abstract val dao: PinjamanDao

    companion object {

        @Volatile
        private var INSTANCE:   PinjamanDb? = null

        fun getInstance(context: Context): PinjamanDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PinjamanDb::class.java,
                        "pinjaman.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}
