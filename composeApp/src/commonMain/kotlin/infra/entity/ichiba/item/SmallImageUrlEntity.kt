package infra.entity.ichiba.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SmallImageUrlEntity(
    @SerialName("imageUrl")
    val imageUrl: String
)