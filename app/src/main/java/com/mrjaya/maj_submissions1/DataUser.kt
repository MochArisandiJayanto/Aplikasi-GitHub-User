package com.mrjaya.maj_submissions1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DataUser : AppCompatActivity() {
    private var title: String = "Github User"
    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_user)
        setActionBarTitle(title)
        rvUser = findViewById(R.id.rv_users)
        rvUser.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private val listUsers: ArrayList<User>
        @SuppressLint("Recycle")
        get() {
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val listUser = ArrayList<User>()
            for (i in dataName.indices) {
                val user = User(
                    dataAvatar.getResourceId(i, -1),
                    dataName[i],
                    dataUsername[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataRepository[i],
                    dataCompany[i],
                    dataLocation[i]
                )
                listUser.add(user)
            }
            return listUser
        }
    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickListener(object :ListUserAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val profileIntent = Intent(this@DataUser, ProfilUser::class.java)
                profileIntent.putExtra("user_data", list[position])
                startActivity(profileIntent)
            }
        })

    }
}