package com.example.sampleapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sampleapplication.viewmodel.PaymentsViewModel

class SingUpFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        if(PaymentsViewModel().isPaymentDone.observe()){
//            // Show Payment Done
//        }else{
//            // Show Payment failed
//        }
   return super.onCreateView(inflater, container, savedInstanceState)
  }
}