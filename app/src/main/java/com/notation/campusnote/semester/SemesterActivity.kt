package com.notation.campusnote.semester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.notation.campusnote.R
import com.notation.campusnote.databinding.ActivitySemesterBinding

class SemesterActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySemesterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySemesterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val semesterList: ArrayList<SemesterList> = arrayListOf()
        binding.rvSemester.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSemester.adapter = SemesterRVAdapter(semesterList)
    }
}