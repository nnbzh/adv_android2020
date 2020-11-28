package com.example.score.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.score.R
import com.example.score.data.models.Team
import com.example.score.databinding.FragmentTeamDetailsBinding


class TeamDetailsFragment : Fragment() {

    private lateinit var team: Team


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        team = arguments?.getParcelable<Team>("team")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTeamDetailsBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_team_details, container, false)
        binding.team = team
        return binding.root
    }

}