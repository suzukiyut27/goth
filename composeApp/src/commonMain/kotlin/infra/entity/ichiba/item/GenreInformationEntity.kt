package infra.entity.ichiba.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreInformationEntity(
    @SerialName("genreId")
    val genreId: String
)
