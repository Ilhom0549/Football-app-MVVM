package uz.ilkhomkhuja.footballappmvvm.models.leagues

data class Data(
    val abbr: String,
    val id: String,
    val logos: Logos,
    val name: String,
    val slug: String
)