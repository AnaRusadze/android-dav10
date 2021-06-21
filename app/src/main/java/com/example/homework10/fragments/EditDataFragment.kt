package com.example.homework10.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import com.example.homework10.R

class EditDataFragment : Fragment(R.layout.fragment_edit_data) {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var userImageUrl: EditText
    private lateinit var saveButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("App_Preferences", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        username = view.findViewById(R.id.usernameEditText)
        email = view.findViewById(R.id.emailEditText)
        userImageUrl = view.findViewById(R.id.imageUrlEditText)
        saveButton = view.findViewById(R.id.saveButton)

        setData()

        saveButton.setOnClickListener {
            if (checkIfEmpty()) {
                updateData()
                Toast.makeText(view.context, "data is saved", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(view.context, "please fill all fields", Toast.LENGTH_SHORT).show()


        }
    }

    private fun setData() {

        userImageUrl.setText(sharedPreferences.getString("photo_url", null))
        username.setText(sharedPreferences.getString("user_name", null))
        email.setText(sharedPreferences.getString("email", null))

    }

    private fun updateData() {
        with(editor) {
            putString("photo_url", userImageUrl.text.toString())
            putString("user_name", username.text.toString())
            putString("email", email.text.toString())
            apply()
        }

    }

    private fun checkIfEmpty(): Boolean {
        return !(username.text.isNullOrEmpty() || email.text.isNullOrEmpty() && userImageUrl.text.isNullOrEmpty())
    }

}