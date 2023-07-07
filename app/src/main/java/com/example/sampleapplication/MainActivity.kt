package com.example.sampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapplication.databinding.ActivityMainBinding
import com.example.sampleapplication.networkUtils.BreedDetails
import com.example.sampleapplication.networkUtils.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var breedList = listOf<BreedDetails>()
    private lateinit var adapter: DogBreedAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DogBreedAdapter(this, breedList)

        binding.rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        binding.rv.adapter = adapter

        binding.btn.setOnClickListener{
            binding.pb.visibility = View.VISIBLE
            // Fetch the datails using retrofit call
            api.fetchDogBreeds().enqueue(object : Callback<List<BreedDetails>?> {
                override fun onResponse(
                    call: Call<List<BreedDetails>?>,
                    response: Response<List<BreedDetails>?>
                ) {
                      if(response.isSuccessful){
                          binding.pb.visibility = View.GONE
                          binding.rv.visibility = View.VISIBLE
                          binding.btn.visibility = View.GONE
                          binding.Info.visibility = View.GONE

                          val data = response.body() ?: listOf()
                          adapter.refreshList(data)
                      }
                }

                override fun onFailure(call: Call<List<BreedDetails>?>, t: Throwable) {
                    binding.pb.visibility = View.GONE
                    Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_SHORT).show()
                }
            })

        }
    }
}

/*
* Database -> [user1, user2, user3]
* Hosted somewhere on the cloud [so that it can be accessed on a network connection] ->server
* Backend -> Interacts wuth these servers and this DB, works as a bridge between a User and cloud
* Flow of Data is done using certain APIs
*GET, POST, FETCH, PUT
* insertContacts(list) {} -> http://www.xyz.com/getAllContacts/ -> Retrofit Library(Http Request)
* */