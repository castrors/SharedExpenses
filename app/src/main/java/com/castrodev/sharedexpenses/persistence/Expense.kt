package com.castrodev.sharedexpenses.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "id")
                   val id: Long = 0,
                   @ColumnInfo(name = "title")
                   val title: String,
                   @ColumnInfo(name = "contact")
                   val contact: String,
                   @ColumnInfo(name = "value")
                   val value: Double)