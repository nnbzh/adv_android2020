package com.example.score.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.score.R
import kotlinx.android.synthetic.main.fragment_teams_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class TeamsListFragment : Fragment() {

    private val teamsListViewModel by viewModel<TeamsListViewModel>()
    private lateinit var teamsAdapter: TeamsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()
        getMovies()
    }

    private fun initAdapter() {
        teamsAdapter = TeamsAdapter()
        rv_teams_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv_teams_list.adapter = teamsAdapter
    }

    private fun getMovies() {
        teamsListViewModel.loadTeams()
        teamsListViewModel.teams.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                teamsAdapter.teams = it
                teamsAdapter.notifyDataSetChanged()
            }
        })
    }
}