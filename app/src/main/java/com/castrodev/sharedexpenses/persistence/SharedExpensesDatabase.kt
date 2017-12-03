package com.castrodev.sharedexpenses.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Expense::class), version = 1, exportSchema = false)
abstract class SharedExpensesDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object {

        @Volatile private var INSTANCE: SharedExpensesDatabase? = null

        fun getInstance(context: Context): SharedExpensesDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        SharedExpensesDatabase::class.java, "SharedExpenses.db")
                        .allowMainThreadQueries()
                        .build()
    }
}