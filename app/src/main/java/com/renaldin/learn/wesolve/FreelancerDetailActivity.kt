package com.renaldin.learn.wesolve

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_freelancer_detail.*

class FreelancerDetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SHORT_ADDRESS = "extra_short_address"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_PHONE_NUMBER = "extra_phone_number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freelancer_detail)

        val actionbar = supportActionBar
        actionbar!!.title= "Detail Freelancer"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val btnDialFreelancer: Button = findViewById(R.id.btn_dial_freelancer)
        btnDialFreelancer.setOnClickListener(this)

        val imgPhoto: ImageView = findViewById(R.id.iv_freelancer_photo)
        val tvName: TextView = findViewById(R.id.tv_freelancer_name)
        val tvShortAddress: TextView = findViewById(R.id.tv_freelancer_short_address)
        val tvDescription: TextView = findViewById(R.id.tv_freelancer_description)
        val tvPrice: TextView = findViewById(R.id.tv_freelancer_price)

        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val shortAddress = intent.getStringExtra(EXTRA_SHORT_ADDRESS)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val price = intent.getStringExtra(EXTRA_PRICE)

        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(imgPhoto)
        tvName.text = name
        tvShortAddress.text = shortAddress
        tvDescription.text = description
        tvPrice.text = price
    }

    override fun onClick(v: View) {
        val phoneNumber = intent.getStringExtra(EXTRA_PHONE_NUMBER)
        when(v.id) {
            R.id.btn_dial_freelancer -> {
                val freelancerPhoneNumber = phoneNumber
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$freelancerPhoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

