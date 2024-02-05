package com.notation.campusnote.ApiService.Results

data class CrawlResult(
    val code: String,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
){
    data class Result(
        val id: Int,
        val lessonDetailsDtoList: List<LessonDetailsDto>,
        val lessonName: String,
        val semester: String,
        val university: String
    )

    data class LessonDetailsDto(
        val dayOfWeek: String,
        val location: String,
        val professorName: String,
        val runningTime: String,
        val startTime: String
    )
}