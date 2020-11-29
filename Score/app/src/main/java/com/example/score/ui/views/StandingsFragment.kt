package com.example.score.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.score.R
import com.example.score.ui.StandingsAdapter
import com.example.score.ui.StandingsViewModel
import kotlinx.android.synthetic.main.fragment_standings.*
import org.koin.android.viewmodel.ext.android.viewModel

class StandingsFragment : Fragment() {

    private val standingsViewModel by viewModel<StandingsViewModel>()
    private lateinit var standingsAdapter: StandingsAdapter
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()
        getStandings()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    private fun initAdapter() {
        standingsAdapter = StandingsAdapter()
        standings_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        standings_list.adapter = standingsAdapter
    }

    private fun getStandings() {
        standingsViewModel.loadStandings()
        standingsViewModel.standings.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                standingsAdapter.standings = it
                standingsAdapter.notifyDataSetChanged()
            }
        })
    }

}