package com.castrodev.sharedexpenses.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "expenses")
data class Expense(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "id")
                   var id: Long = 0,
                   @ColumnInfo(name = "title")
                   var title: String = "",
                   @ColumnInfo(name = "contact")
                   var contact: String = "",
                   @ColumnInfo(name = "value")
                   var value: Double = 0.0) : Serializable