package com.wahyuindra.recyclerviewexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahyuindra.recyclerviewexample.databinding.ActivityMainBinding
import com.wahyuindra.recyclerviewexample.model.Mahasiswa
import com.wahyuindra.recyclerviewexample.util.ListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayListMhs()
    }

    @SuppressLint("Recycle")
    private fun displayListMhs(){
        val listMhs = ArrayList<Mahasiswa>()
        val images = resources.obtainTypedArray(R.array.mahasiswa_image)
        val name = resources.getStringArray(R.array.mahasiswa_name)
        val nim = resources.getStringArray(R.array.mahasiswa_nim)

        for(pos in name.indices){
            listMhs.add(
                Mahasiswa(
                    mahasiswaName = name[pos],
                    mahasiswaNim = nim[pos],
                    images = images.getResourceId(pos, -1)
                )
            )
        }

        binding.rvListData.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListAdapter(listMhs)
            setHasFixedSize(true)
        }
    }
}