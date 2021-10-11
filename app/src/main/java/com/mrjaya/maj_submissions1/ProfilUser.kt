package com.mrjaya.maj_submissions1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrjaya.maj_submissions1.databinding.ActivityProfilUserBinding

class ProfilUser : AppCompatActivity() {
    private lateinit var binding : ActivityProfilUserBinding
    private var title: String = "Detail User"

    companion object {
        const val USER_DATA = "user_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBarTitle(title)

        val user = intent.getParcelableExtra<User>(USER_DATA) as User

        val avatar = user.avatar
        val name = user.name
        val username = user.username
        val followers = user.followers
        val following = user.following
        val repository = user.repository
        val company = user.company
        val location = user.location

        binding.profilFoto.setImageResource(avatar)
        binding.profilName.text = name
        binding.profilUsername.text = username
        binding.followers.text = followers
        binding.following.text = following
        binding.repository.text = repository
        binding.company.text = company
        binding.location.text = location

    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}