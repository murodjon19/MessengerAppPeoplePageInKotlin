package com.example.messengerapppeoplepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messengerapppeoplepage.adapter.ChatAdapter
import com.example.messengerapppeoplepage.model.Chat
import com.example.messengerapppeoplepage.model.Message
import com.example.messengerapppeoplepage.model.Room
class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this,1))

        refreshAdapters(getAllChats())
    }

    private fun refreshAdapters(chats:ArrayList<Chat>) {
        val adapter = ChatAdapter(this,chats)
        recyclerView!!.adapter = adapter

    }

    private fun getAllChats(): ArrayList<Chat> {
        val stories: ArrayList<Room> = ArrayList<Room>()
        stories.add(Room(R.drawable.img22,"",true))
        stories.add(Room(R.drawable.img24,"Laziz Avazov"))
        stories.add(Room(R.drawable.img25,"Amir Avazov"))
        stories.add(Room(R.drawable.img22,"Said Avazov"))
        stories.add(Room(R.drawable.img27,"Jamshid Avazov"))
        stories.add(Room(R.drawable.img24,"Begzod Avazov"))
        stories.add(Room(R.drawable.img25,"Abdulhay Avazov"))
        stories.add(Room(R.drawable.img26,"Abdulhay Avazov"))
        stories.add(Room(R.drawable.img22,"Abdulhay Avazov"))
        stories.add(Room(R.drawable.img29,"Abdulhay Avazov"))
        stories.add(Room(R.drawable.img24,"Abdulhay Avazov"))

        val chats: ArrayList<Chat> = ArrayList()

        chats.add(Chat(stories))

        chats.add(Chat(Message(R.drawable.img22,"Murodjon",false)))
        chats.add(Chat(Message(R.drawable.img24,"Maqsit",true)))
        chats.add(Chat(Message(R.drawable.img22,"Jamol",false)))
        chats.add(Chat(Message(R.drawable.img22,"Karim",true)))
        chats.add(Chat(Message(R.drawable.img25,"Leyla",false)))
        chats.add(Chat(Message(R.drawable.img24,"Amanda",true)))
        chats.add(Chat(Message(R.drawable.img25,"Alex",false)))
        chats.add(Chat(Message(R.drawable.img26,"Bahodir",true)))
        chats.add(Chat(Message(R.drawable.img27,"Olim",false)))
        chats.add(Chat(Message(R.drawable.img22,"Zayniddin",true)))
        chats.add(Chat(Message(R.drawable.img24,"Javohir",false)))
        chats.add(Chat(Message(R.drawable.img26,"Umit",true)))
        chats.add(Chat(Message(R.drawable.img22,"Zaynab",false)))
        chats.add(Chat(Message(R.drawable.img29,"Sherali",false)))


        return chats
    }
}