package com.example.score.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.score.R
import com.example.score.data.models.Team
import com.example.score.ui.TeamsAdapter
import com.example.score.ui.TeamsListViewModel
import kotlinx.android.synthetic.main.fragment_teams_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class TeamsListFragment : Fragment(), TeamsAdapter.RvItemClickListener {

    private val teamsListViewModel by viewModel<TeamsListViewModel>()
    private lateinit var teamsAdapter: TeamsAdapter
    private var navController: NavController? = null

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    private fun initAdapter() {
        teamsAdapter = TeamsAdapter(rvItemClickListener = this)
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

    override fun itemClick(position: Int, team: Team) {
        val bundle = bundleOf(
            "team" to team
        )
        navController?.navigate(R.id.action_teamsListFragment_to_teamDetailsFragment, bundle)
    }
}