package com.example.recyclesubmission

import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListDevAdapter.BtnDetailPage{
    private lateinit var rvDeveloper:RecyclerView
    private val list = ArrayList<Developer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDeveloper = findViewById(R.id.rv_developer)
        rvDeveloper.setHasFixedSize(true)

        list.addAll(listDevelopers)
        showRecycleList()
    }

    private val listDevelopers:ArrayList<Developer>
        get(){
            val dataUserName = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val listDeveloper = ArrayList<Developer>()
            for (i in dataUserName.indices){
                val Developer = Developer(dataUserName[i], dataName[i], dataLocation[i],
                    dataRepository[i], dataCompany[i], dataFollowers[i], dataFollowing[i],
                    dataAvatar.getResourceId(i, -1))
                listDeveloper.add(Developer)
            }
            return listDeveloper
        }

    private fun showRecycleList(){
        rvDeveloper.layoutManager = LinearLayoutManager(this)
        val listDeveloperAdapter = ListDevAdapter(list, this)
        rvDeveloper.adapter = listDeveloperAdapter
    }

    override fun clickedItem(id: Int) {
        val movedPage = Intent(this@MainActivity, DetailDeveloperActivity::class.java)
        movedPage.putExtra(DetailDeveloperActivity.EXTRA_PERSON,listDevelopers[id])
        startActivity(movedPage)
    }
}