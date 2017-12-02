package com.castrodev.sharedexpenses.persistence

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM Expenses")
    fun getAllExpenses(): List<Expense>

    @Query("SELECT * FROM Expenses WHERE id = :id")
    fun findExpenseById(id: Long): Expense

    @Insert(onConflict = REPLACE)
    fun insertExpense(expense: Expense)

    @Update(onConflict = REPLACE)
    fun updateExpense(expense: Expense)

    @Delete
    fun deleteExpense(expense: Expense)
}
