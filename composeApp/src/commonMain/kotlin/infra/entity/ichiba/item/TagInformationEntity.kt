package infra.entity.ichiba.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TagInformationEntity(
    @SerialName("tagGroupName")
    val tagGroupName: String,
    @SerialName("tagGroupId")
    val tagGroupId: String
)
