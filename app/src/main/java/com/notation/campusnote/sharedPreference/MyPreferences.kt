package com.notation.campusnote.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class MyPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    // 클라이언트 ID 저장
    fun saveClientId(clientId: String) {
        sharedPreferences.edit().putString("client_id", clientId).apply()
    }

    // 클라이언트 ID 가져오기
    fun getClientId(): String? {
        return sharedPreferences.getString("client_id", null)
    }

    // 클라이언트 ID 저장
    fun saveProfilePic(profilePic: String) {
        sharedPreferences.edit().putString("profile_pic", profilePic).apply()
    }

    // 클라이언트 ID 가져오기
    fun getProfilePic(): String? {
        return sharedPreferences.getString("profile_pic", null)
    }

}