package com.example.sampleapplication.networkUtils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.sampleapplication.R
import com.example.sampleapplication.databinding.ActivityCoroutineTestBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineTest : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_test)

        // Coroutine
        // ThreadPool -> 10 operations || we have to create 10 different threads
        // LightWeight -> We can run multiple Coroutines in a single thread
        // Same coroutine can switch contexts( jumps from IO to Main thread)
        // IO Thread -> 1CR(Network call) | 2 CR (fetch this data and push it to Database) | 3CR (Complex Calculation)

       /*
       Creating a UI
       thread {
            // Network functions (2sec to respond) -- Backound Thread
        }
        // UPDATEUI --- Main thread once the Network call is complete

        */

       /* This is The correct Way but not best way
            // Create a UI
            thread {
                   // Network Function(2sec to respond) -- Background thread
                   runOnUiThread {
                               // UpdateUi -- Main Thread once The Network call is complete
                   }
            }
        */

       // this is the Best Way to Run background and Foreground

       GlobalScope.launch(Dispatchers.IO) {
            // Network Call
            // DataBase Call
            withContext(Dispatchers.Main){
                //Update Ui
            }
        }

        // Attached with the Current Activities LifeCycle
        lifecycleScope.launch {
            // Write my Coroutine definition here
        }

    }
}

// Threads are Used for small processes that are to be executed in Background
// for Ex -> Network Call, A Database call -> an Image/Audio Download, Complex Calculation,etc
