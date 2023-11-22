package com.ryangst.gas_log.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ryangst.gas_log.model.Fuel
import com.ryangst.gas_log.model.SupplyRecord
import java.util.concurrent.Executors

@Database(entities = [Fuel::class, SupplyRecord::class], version = 1)
abstract class AppDatabase(): RoomDatabase() {

    abstract fun fuelDAO(): FuelDAO
    abstract fun supplyRecordDAO(): SupplyRecordDAO


    companion object {
        private lateinit var instance: AppDatabase

        val callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                // Do the database seeding here
                // You can use DAOs or direct SQL queries
                Executors.newSingleThreadExecutor().execute {
                    val fuels = listOf(
                        Fuel().apply {
                            name = "Diesel"
                            price = 3.50
                        },
                        Fuel().apply {
                            name = "Petrol"
                            price = 3.80
                        },
                        Fuel().apply {
                            name = "Electric"
                            price = 0.0
                        }
                    )

                    // Insert fuels into the database
                    instance.fuelDAO().insertAll(fuels)
                }
            }
        }
        fun getDatabase(context: Context): AppDatabase {
            if (!::instance.isInitialized) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context, AppDatabase::class.java, "gas_log.db")
                        .addCallback(callback).allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }


}