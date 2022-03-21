package com.example.recyclesubmission

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class DetailDeveloperActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_developer)

        val imgDev:ImageView = findViewById(R.id.img_dev)
        val tvUserName:TextView = findViewById(R.id.tv_dev_username)
        val tvName:TextView = findViewById(R.id.tv_dev_name)
        val tvCompany:TextView = findViewById(R.id.tv_dev_company)
        val tvLocation:TextView = findViewById(R.id.tv_dev_location)
        val tvFollower:TextView = findViewById(R.id.tv_dev_followers)
        val tvFollowing:TextView = findViewById(R.id.tv_dev_following)
        val tvRepository:TextView = findViewById(R.id.tv_dev_repository)

        val Dev = intent.getParcelableExtra<Developer>(EXTRA_PERSON) as Developer

        Glide.with(this).load(Dev.avatar).circleCrop().into(imgDev)
        tvUserName.text = Dev.userName
        tvName.text = Dev.name
        tvCompany.text = Dev.company
        tvLocation.text = Dev.location
        tvFollower.text = Dev.followers
        tvFollowing.text = Dev.following
        tvRepository.text = Dev.repository
    }
}