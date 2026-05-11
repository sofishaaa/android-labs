package com.example.contactlist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = mutableListOf(
            Contact("Іван Петренко", "+380501234567"),
            Contact("Марія Коваленко", "+380671234567"),
            Contact("Олег Шевченко", "+380931234567"),
            Contact("Анна Бондаренко", "+380661234567"),
            Contact("Дмитро Мельник", "+380951234567"),
            Contact("Софія Гункало", "+380991234567"),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ContactAdapter(contacts) { contact ->
            Toast.makeText(this, "Вибрано: ${contact.name}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }
}