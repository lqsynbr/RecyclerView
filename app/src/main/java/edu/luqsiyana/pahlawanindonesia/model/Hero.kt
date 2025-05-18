package edu.luqsiyana.pahlawanindonesia.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Hero(
    var nama: String,
    var deskripsi: String,
    var foto: Int
) : Parcelable
