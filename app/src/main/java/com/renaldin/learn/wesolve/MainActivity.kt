package com.renaldin.learn.wesolve

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renaldin.learn.wesolve.adapter.ListFreelancerAdapter
import com.renaldin.learn.wesolve.models.Freelancer
import com.renaldin.learn.wesolve.models.FreelancerData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var rvFreelancer: RecyclerView
    private var list: ArrayList<Freelancer> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        rvFreelancer = findViewById(R.id.rv_freelancer)
        rvFreelancer.setHasFixedSize(true)

        list.addAll(FreelancerData.listData)
        showRecyclerList()

        menuOrders.setOnClickListener {
            val intentOrders = Intent(this@MainActivity, OrderActivity::class.java)
            startActivity(intentOrders)
        }

        bottomAppBar.replaceMenu(R.menu.main_menu)

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuAbout -> {
                    val intentAbout = Intent(this@MainActivity, AboutActivity::class.java)
                    startActivity(intentAbout)
                }
            }; true
        }
    }

    private fun showRecyclerList() {
        rvFreelancer.layoutManager = LinearLayoutManager(this)
        val listFreelancerAdapter = ListFreelancerAdapter(list)
        rvFreelancer.adapter = listFreelancerAdapter
    }
}
