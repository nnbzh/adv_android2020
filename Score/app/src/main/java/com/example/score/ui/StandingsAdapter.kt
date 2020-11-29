package com.example.score.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.score.R
import com.example.score.data.models.standings.Standing
import com.squareup.picasso.Picasso

class StandingsAdapter(var standings: List<Standing>? = null):
    RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder>() {

    var number = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.standing_item, parent, false)
        return StandingsViewHolder(view)
    }

    override fun getItemCount(): Int = standings?.size ?: 0

    override fun onBindViewHolder(holder: StandingsViewHolder, position: Int) {
        holder.bind(standings?.get(position))
    }

    inner class StandingsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(standing: Standing?) {
            val teamName = view.findViewById<TextView>(R.id.tvTeamName)
            val pts = view.findViewById<TextView>(R.id.tvPTS)
            val goalDiff = view.findViewById<TextView>(R.id.tvGoalDiff)
            val matchesPlayed = view.findViewById<TextView>(R.id.tvMatchesPlayed)
            val rank = view.findViewById<TextView>(R.id.tvNumber)

            teamName.text = standing?.teamName
            pts.text = standing?.pts.toString()
            goalDiff.text = "${standing?.all?.goalsFor.toString()}:${standing?.all?.goalsAgainst.toString()}"
            matchesPlayed.text = standing?.all?.matchesPlayed.toString()
            rank.text = "${standing?.rank.toString()}."

            Picasso.get()
                .load(standing?.logoUrl)
                .into(view.findViewById<ImageView>(R.id.ivLogo))
        }
    }

}