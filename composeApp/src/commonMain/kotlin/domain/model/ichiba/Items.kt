package domain.model.ichiba

data class Items(
    val genreInformation: List<GenreInformation>,
    val items: List<Item>,
    val tagInformation: List<TagInformation>,
    val carrier: Int,
    val count: Int,
    val first: Int,
    val hits: Int,
    val last: Int,
    val page: Int,
    val pageCount: Int
)