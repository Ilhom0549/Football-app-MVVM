package uz.ilkhomkhuja.footballappmvvm.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.ilkhomkhuja.footballappmvvm.R
import uz.ilkhomkhuja.footballappmvvm.databinding.ClubInfoItemBinding
import uz.ilkhomkhuja.footballappmvvm.models.club.Standing

class ClubInfoRvAdapter(private val standingList: ArrayList<Standing>) :
    RecyclerView.Adapter<ClubInfoRvAdapter.Vh>() {

    inner class Vh(private val clubInfoItemBinding: ClubInfoItemBinding) :
        RecyclerView.ViewHolder(clubInfoItemBinding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(standing: Standing, position: Int) {
            clubInfoItemBinding.apply {

                countTv.text = (position + 1).toString()
                clubNameTv.text = standing.team.name

                Picasso.get()
                    .load(standing.team.logos[0].href)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(clubFlagImg)

                standing.stats.forEach {
                    when (it.abbreviation) {
                        "W" -> {
                            wins.text = it.value.toString()
                        }
                        "L" -> {
                            losses.text = it.value.toString()
                        }
                        "D" -> {
                            draw.text = it.value.toString()
                        }
                        "GP" -> {
                            gamePlayed.text = it.value.toString()
                        }
                        "P" -> {
                            pts.text = it.value.toString()
                        }
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ClubInfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(standingList[position], position)
    }

    override fun getItemCount(): Int {
        return standingList.size
    }
}