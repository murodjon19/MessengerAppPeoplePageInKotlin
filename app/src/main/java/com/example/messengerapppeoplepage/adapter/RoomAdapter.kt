package com.example.messengerapppeoplepage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messengerapppeoplepage.R
import com.example.messengerapppeoplepage.model.Room
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(var context: Context, var items:ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_creat_room,parent,false)
            return CreateRoomViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_view,parent,false)
        return RoomViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]
        if (feed.isAvailavle) return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]

        if (holder is RoomViewHolder) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            iv_profile.setImageResource(room.profile)
            tv_fullname.text = room.fullname

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class RoomViewHolder(view: View):RecyclerView.ViewHolder(view) {
    var iv_profile : ShapeableImageView
    var tv_fullname : TextView

    init {
        iv_profile = view.findViewById(R.id.iv_profile1)
        tv_fullname = view.findViewById(R.id.fullname)
    }
}

class CreateRoomViewHolder(view: View):RecyclerView.ViewHolder(view) {

}