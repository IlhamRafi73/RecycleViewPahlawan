package com.example.recycleviewpahlawan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewpahlawan.databinding.ItemLayoutBinding

typealias OnClickPahlawan = (Pahlawan) -> Unit

class PahlawanAdapter(private val listPahlawan: List<Pahlawan>, private val onClickPahlawan: OnClickPahlawan):
    RecyclerView.Adapter<PahlawanAdapter.ItemPahlawanViewHolder>() {

    inner class ItemPahlawanViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Pahlawan) {
            with(binding) {
                tvNama.text = data.pahlawanName
                tvDescription.text = data.pahlawanDesc
                ivImageView.setImageResource(data.pahlawanImage)
                itemView.setOnClickListener {
                    onClickPahlawan(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPahlawanViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemPahlawanViewHolder(binding)
    }

    override fun getItemCount(): Int = listPahlawan.size

    override fun onBindViewHolder(holder: ItemPahlawanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }
}