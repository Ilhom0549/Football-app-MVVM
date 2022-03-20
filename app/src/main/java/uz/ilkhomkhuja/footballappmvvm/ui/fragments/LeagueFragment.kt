package uz.ilkhomkhuja.footballappmvvm.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import uz.ilkhomkhuja.footballappmvvm.R
import uz.ilkhomkhuja.footballappmvvm.adapters.ViewPagerAdapter
import uz.ilkhomkhuja.footballappmvvm.databinding.FragmentLeagueBinding
import uz.ilkhomkhuja.footballappmvvm.models.club.FootballClub


class LeagueFragment : Fragment() {

    private var footballClub: FootballClub? = null
    private var _binding: FragmentLeagueBinding? = null
    private val binding get() = _binding!!
    private var tabTitleList = arrayListOf("Matches", "Table")
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeagueBinding.inflate(inflater, container, false)
        footballClub = arguments?.getSerializable("football") as FootballClub
        initUI()
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        viewPagerAdapter = ViewPagerAdapter(this, footballClub!!)
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = tabTitleList[pos]
        }.attach()
    }

    @SuppressLint("SetTextI18n")
    private fun initUI() {
        binding.leaguesTv.text = "${footballClub?.data?.name} ${footballClub?.data?.seasonDisplay}"

        Picasso.get()
            .load(footballClub?.logo)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(binding.leagueFlagImg)

        binding.backImg.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}