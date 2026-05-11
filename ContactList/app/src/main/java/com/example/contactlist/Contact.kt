package com.example.contactlist

data class Contact(
    val name: String,
    val phone: String,
    val imageResId: Int = android.R.drawable.ic_menu_myplaces
)