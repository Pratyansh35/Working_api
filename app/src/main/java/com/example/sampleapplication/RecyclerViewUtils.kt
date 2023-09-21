package com.example.sampleapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleapplication.databinding.ListItemBinding
import com.example.sampleapplication.networkUtils.BreedDetails


class BreedViewHolder(
    private val binding: ListItemBinding
):RecyclerView.ViewHolder(binding.root){

    fun bind(context: Context, data: BreedDetails){
        binding.itembreed.text = data.name
        binding.itemcategory.text = data.category
        binding.itemOrigin.text = data.origin

        // image later
        Glide.with(context).load(data.iamgeReference.imageUrl).into(binding.itemImg)
    }
}

class DogBreedAdapter(
    private val context: Context,
    private var breeds: List<BreedDetails>
): RecyclerView.Adapter<BreedViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount() = breeds.size

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.bind(context,breeds[position])
    }
    fun refreshList(newDataList: List<BreedDetails>){
        breeds = newDataList
        notifyDataSetChanged()

    }
}