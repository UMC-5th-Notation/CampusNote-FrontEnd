package com.notation.campusnote.ApiService.Results

data class LogInResult(
    val code: String,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
){
    data class Result(
        val accessToken: String,
        val refreshToken: String
    )
}