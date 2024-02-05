package com.notation.campusnote.ApiService.Results


data class SignUpResult(
    val code: String,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
){
        data class Result(
            val accesstoken: String,
            val refreshtoken: String
        )
}

