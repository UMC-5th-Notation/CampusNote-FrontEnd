package com.notation.campusnote.ApiService.Results

data class UserResult(
    val code: String,
    val isSuccess: Boolean,
    val message: String,
    val result: String
)