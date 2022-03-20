package uz.ilkhomkhuja.footballappmvvm.models.club

data class Standing(
    val note: Note,
    val stats: List<Stat>,
    val team: Team
)