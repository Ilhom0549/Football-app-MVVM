package uz.ilkhomkhuja.footballappmvvm.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.ilkhomkhuja.footballappmvvm.models.club.FootballClub
import uz.ilkhomkhuja.footballappmvvm.ui.fragments.MatchesFragment
import uz.ilkhomkhuja.footballappmvvm.ui.fragments.TableFragment

class ViewPagerAdapter(fragment: Fragment, val footballClub: FootballClub) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MatchesFragment.newInstance(footballClub)
            }
            else -> {
                TableFragment.newInstance(footballClub)
            }
        }
    }
}