package uz.ilkhomkhuja.footballappmvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.ilkhomkhuja.footballappmvvm.adapters.ClubInfoRvAdapter
import uz.ilkhomkhuja.footballappmvvm.databinding.FragmentTableBinding
import uz.ilkhomkhuja.footballappmvvm.models.club.FootballClub
import uz.ilkhomkhuja.footballappmvvm.models.club.Standing


private const val ARG_PARAM1 = "param1"


class TableFragment : Fragment() {

    private var footballClub: FootballClub? = null
    private var _binding: FragmentTableBinding? = null
    private val binding get() = _binding!!
    private lateinit var clubInfoRvAdapter: ClubInfoRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTableBinding.inflate(inflater, container, false)
        arguments?.let { footballClub = it.getSerializable(ARG_PARAM1) as FootballClub }
        setupAdapter()
        return binding.root
    }

    private fun setupAdapter() {
        clubInfoRvAdapter = ClubInfoRvAdapter(footballClub?.data?.standings as ArrayList<Standing>)
        binding.clubInfoRv.adapter = clubInfoRvAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: FootballClub) =
            TableFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}