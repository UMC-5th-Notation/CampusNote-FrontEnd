package com.notation.campusnote.semester

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.notation.campusnote.databinding.ItemSemesterListBinding

class SemesterRVAdapter(private val semesterList: List<SemesterList>):
    RecyclerView.Adapter<SemesterRVAdapter.ViewHolder>() {
    class ViewHolder(private var binding: ItemSemesterListBinding): RecyclerView.ViewHolder(binding.root) {
        val semester = binding.semester
        val noteNum  = binding.noteNum
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSemesterListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = semesterList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.semester.text = semesterList[position].semester
        holder.noteNum.text = semesterList[position].noteNum.toString()
    }
}