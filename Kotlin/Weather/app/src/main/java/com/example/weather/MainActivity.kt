package com.example.weather

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var text: TextView
    private lateinit var button: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val note = Note("title", "name")
        val note1 = note.copy()
        val textToView = note1.title + " " + note1.note

        text = findViewById(R.id.text_view)
        button = findViewById(R.id.button)
        val cobbledString = nextCycle(cycle(), textToView)
        button.setOnClickListener { text.text = cobbledString }
    }

    private fun cycle(): List<String> {
        val daysOfWeek =
            listOf(resources.getString(R.string.app_name), "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val daysWithIndex = mutableListOf<String>()
        daysOfWeek.forEachIndexed { index, s ->
            val temp = "$s ${index + 1}"
            daysWithIndex.add(temp)
        }
        return daysWithIndex
    }

    private fun nextCycle(list: List<String>, textToView: String): String {
        val s = StringBuilder()
        for (i in list.indices) {
            s.append(list[i])
                .append(" ")
                .append(textToView)
                .append(" ")
                .append(i + 1)
                .append("\n")
        }
        return s.toString()
    }
}