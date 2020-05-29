package com.renaldin.learn.wesolve.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.renaldin.learn.wesolve.FreelancerDetailActivity
import com.renaldin.learn.wesolve.R
import com.renaldin.learn.wesolve.models.Freelancer

class ListFreelancerAdapter(private val listFreelancer: ArrayList<Freelancer>) :
    RecyclerView.Adapter<ListFreelancerAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvLastOrder: TextView = itemView.findViewById(R.id.tv_item_last_order)
        var tvServices: TextView = itemView.findViewById(R.id.tv_item_services)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_freelancer, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val freelancer = listFreelancer[position]

        Glide.with(holder.itemView.context)
            .load(freelancer.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = freelancer.name
        holder.tvLastOrder.text = freelancer.lastOrder
        holder.tvServices.text = freelancer.services

        val parentContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val freelanceDetails = Intent(parentContext, FreelancerDetailActivity::class.java)
            freelanceDetails.putExtra(FreelancerDetailActivity.EXTRA_PHOTO, freelancer.photo)
            freelanceDetails.putExtra(FreelancerDetailActivity.EXTRA_NAME, freelancer.name)
            freelanceDetails.putExtra(FreelancerDetailActivity.EXTRA_SHORT_ADDRESS, freelancer.shortAddress)
            freelanceDetails.putExtra(FreelancerDetailActivity.EXTRA_DESCRIPTION, freelancer.description)
            freelanceDetails.putExtra(FreelancerDetailActivity.EXTRA_PRICE, freelancer.price)
            freelanceDetails.putExtra(FreelancerDetailActivity.EXTRA_PHONE_NUMBER, freelancer.phoneNumber)
            parentContext.startActivity(freelanceDetails)
        }
    }

    override fun getItemCount(): Int {
        return listFreelancer.size
    }

}