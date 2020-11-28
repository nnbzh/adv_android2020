package com.example.score.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.score.R
import com.example.score.data.models.Team
import com.squareup.picasso.Picasso

class TeamsAdapter(var teams: List<Team>? = null,
                   var rvItemClickListener: RvItemClickListener? = null):
    RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>() {

    var number = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false)
        return TeamsViewHolder(view)
    }

    override fun getItemCount(): Int = teams?.size ?: 0

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(teams?.get(position))
    }

    inner class TeamsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(team: Team?) {
            val teamName = view.findViewById<TextView>(R.id.team_name)

            teamName.text = team?.name

            Picasso.get()
                .load(team?.imageUrl)
                .into(view.findViewById<ImageView>(R.id.team_logo))

            view.setOnClickListener {
                team?.let { rvItemClickListener?.itemClick(adapterPosition, it) }
            }
        }
    }

    interface RvItemClickListener {
        fun itemClick(position: Int, team: Team)
    }
}

