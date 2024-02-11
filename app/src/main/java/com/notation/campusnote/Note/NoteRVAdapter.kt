package com.notation.campusnote.Note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.notation.campusnote.databinding.ItemNoteBinding

class NoteRVAdapter(private val images: List<Int>) : RecyclerView.Adapter<NoteRVAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NoteRVAdapter.ImageViewHolder {
        val binding : ItemNoteBinding = ItemNoteBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    inner class ImageViewHolder(private val binding : ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageResId: Int) {
            binding.itemNoteIv.setImageResource(imageResId)
        }
    }
}