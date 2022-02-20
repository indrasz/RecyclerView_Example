package com.wahyuindra.recyclerviewexample.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mahasiswa (
    val mahasiswaName: String?,
    val mahasiswaNim: String?,
    val images: Int
):Parcelable