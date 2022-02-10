package com.example.messengerapppeoplepage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messengerapppeoplepage.R
import com.example.messengerapppeoplepage.model.Chat
import com.example.messengerapppeoplepage.model.Room
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(var context: Context, var items:ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewholder2(context,view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = items[position]

        if (holder is RoomViewholder2) {
            var recyclerView = holder.recyclerView
            refreshAdapter(message.rooms, recyclerView)
        }

        if (holder is MessageViewHolder) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            var is_online = holder.is_online

            iv_profile.setImageResource(message.message!!.profile)
            tv_fullname.text = message.message!!.fullname
            if (message.message!!.isOnline) {
                is_online.visibility = View.VISIBLE
            } else {
                is_online.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.rooms.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        val adapter = RoomAdapter(context, rooms)
        recyclerView!!.adapter = adapter
    }
}
class RoomViewholder2(context: Context,view: View) : RecyclerView.ViewHolder(view) {
    var recyclerView: RecyclerView

    init {
        recyclerView = view.findViewById(R.id.recyclerView2)
        val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setLayoutManager(manager)
    }
}

class MessageViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    var iv_profile : ShapeableImageView
    var tv_fullname: TextView
    var is_online : LinearLayout

    init {
        iv_profile = view.findViewById(R.id.iv_profile)
        tv_fullname = view.findViewById(R.id.tv_fullname)
        is_online = view.findViewById(R.id.is_online)
    }
}

