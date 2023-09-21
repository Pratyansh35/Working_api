package com.example.sampleapplication.viewmodel

import androidx.lifecycle.MutableLiveData

class PaymentsViewModel {
// Every Business Logic Associated With Payment
    lateinit var isPaymentDone: MutableLiveData<Boolean>

    fun checkPayments(){
        isPaymentDone.value = true
        // Create an Interface
        // Invoke a CallBack
    }

    private fun getPaymentsStatus(): Boolean {
        // Do an API Call
        return true
    }
}


