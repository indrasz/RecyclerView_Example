package com.wahyuindra.recyclerviewexample.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahyuindra.recyclerviewexample.databinding.ItemListBinding
import com.wahyuindra.recyclerviewexample.model.Mahasiswa

class ListAdapter(private val list: ArrayList<Mahasiswa>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mahasiswa: Mahasiswa) {
            with(binding) {
                Glide.with(this.root)
                    .load(mahasiswa.images)
                    .into(binding.ivMahasiswa)

                binding.tvMahasiswaName.text = mahasiswa.mahasiswaName
                binding.tvMahasiswaNim.text = mahasiswa.mahasiswaNim
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}