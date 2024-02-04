package com.notation.campusnote.semester

import com.google.gson.annotations.SerializedName

data class SemesterList(
    @SerializedName("semester") val semester: String,
    @SerializedName("noteNum") val noteNum: Int
)
