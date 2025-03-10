package com.example.finance_tracker.repository

import androidx.lifecycle.LiveData
import com.example.finance_tracker.dao.TransactionDao
import com.example.finance_tracker.model.Transaction

class TransactionRepository(val dao: TransactionDao) {

    fun getAllTransaction(): LiveData<List<Transaction>> {
        return dao.getTransaction()
    }

    fun getMonthlyTransaction(month:Int,Year:Int): LiveData<List<Transaction>>{
        return dao.getMonthlyTransaction(month,Year)
    }

    fun getYearlyTransaction(year:Int): LiveData<List<Transaction>>{
        return dao.getYearlyTransaction(year)
    }

    fun insertTransaction(transaction: Transaction){
        dao.insertTransaction(transaction)
    }

    fun deleteTransaction(id:Int){
        dao.deleteTransaction(id)
    }

    fun updateTransaction(transaction: Transaction){
        dao.updateTransaction(transaction)
    }


}