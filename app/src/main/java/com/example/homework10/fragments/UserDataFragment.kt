package com.example.homework10.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.homework10.R

class UserDataFragment : Fragment(R.layout.fragment_user_data) {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var userImage: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().getSharedPreferences("App_Preferences", Context.MODE_PRIVATE)

        username = view.findViewById(R.id.usernameTextView)
        email = view.findViewById(R.id.emailTextView)
        userImage = view.findViewById(R.id.userAvatar)

        initUI()
    }

    override fun onResume() {
        super.onResume()
        initUI()
    }

    private fun initUI() {
        Glide.with(requireView()).load(sharedPreferences.getString("photo_url", ""))
            .placeholder(R.drawable.ic_user_placeholder).into(userImage)

        username.text = sharedPreferences.getString("user_name", "name example")
        email.text = sharedPreferences.getString("email", "email example")
    }


}