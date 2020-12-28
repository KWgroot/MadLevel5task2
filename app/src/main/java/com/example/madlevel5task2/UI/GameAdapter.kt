package com.example.madlevel5task2.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.MadLevel5Task2.R
import com.example.madlevel5task2.Viewmodel.Game
import kotlinx.android.synthetic.main.item_game.view.*
import java.time.ZoneId

class GameAdapter(private val games: List<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun databind(game: Game){
            itemView.tvGameTitle.text = game.title
            itemView.tvPlatform.text = game.platform
            val date = game.releaseDate
            val localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            val year = localDate.year
            val month = localDate.month
            val day = localDate.dayOfMonth

            itemView.tvRelease.text = "$day $month $year"
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_game,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])

    }
}