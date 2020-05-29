package com.renaldin.learn.wesolve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class OrderActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val actionbar = supportActionBar
        actionbar!!.title= "Orders"

        actionbar.setDisplayHomeAsUpEnabled(true)

        val btnBackToHome: Button = findViewById(R.id.btnHome)
        btnBackToHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
            when(v?.id) {
                R.id.btnHome -> {
                    val intentHome = Intent(this@OrderActivity, MainActivity::class.java)
                    startActivity(intentHome)
                }
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
