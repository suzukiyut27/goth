package infra.entity.ichiba.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemEntity(
    @SerialName("Item")
    val item: ItemDetailsEntity
) {
    @Serializable
    data class ItemDetailsEntity(

        @SerialName("affiliateRate")
        val affiliateRate: Int,
        @SerialName("affiliateUrl")
        val affiliateUrl: String,
        @SerialName("asurakuArea")
        val asurakuArea: String,
        @SerialName("asurakuClosingTime")
        val asurakuClosingTime: String,
        @SerialName("asurakuFlag")
        val asurakuFlag: Int,
        @SerialName("availability")
        val availability: Int,
        @SerialName("catchcopy")
        val catchCopy: String,
        @SerialName("creditCardFlag")
        val creditCardFlag: Int,
        @SerialName("endTime")
        val endTime: String,
        @SerialName("genreId")
        val genreId: String,
        @SerialName("giftFlag")
        val giftFlag: Int,
        @SerialName("imageFlag")
        val imageFlag: Int,
        @SerialName("itemCaption")
        val itemCaption: String,
        @SerialName("itemCode")
        val itemCode: String,
        @SerialName("itemName")
        val itemName: String,
        @SerialName("itemPrice")
        val itemPrice: Int,
        @SerialName("itemPriceBaseField")
        val itemPriceBaseField: String,
        @SerialName("itemPriceMax1")
        val itemPriceMax1: Int,
        @SerialName("itemPriceMax2")
        val itemPriceMax2: Int,
        @SerialName("itemPriceMax3")
        val itemPriceMax3: Int,
        @SerialName("itemPriceMin1")
        val itemPriceMin1: Int,
        @SerialName("itemPriceMin2")
        val itemPriceMin2: Int,
        @SerialName("itemPriceMin3")
        val itemPriceMin3: Int,
        @SerialName("itemUrl")
        val itemUrl: String,
        @SerialName("mediumImageUrls")
        val mediumImageUrls: List<MediumImageUrlEntity>,
        @SerialName("pointRate")
        val pointRate: Int,
        @SerialName("pointRateStartTime")
        val pointRateStartTime: String,
        @SerialName("pointRateEndTime")
        val pointRateEndTime: String,
        @SerialName("postageFlag")
        val postageFlag: Int,
        @SerialName("reviewAverage")
        val reviewAverage: Float,
        @SerialName("reviewCount")
        val reviewCount: Int,
        @SerialName("shipOverseasArea")
        val shipOverseasArea: String,
        @SerialName("shipOverseasFlag")
        val shipOverseasFlag: Int,
        @SerialName("shopAffiliateUrl")
        val shopAffiliateUrl: String,
        @SerialName("shopCode")
        val shopCode: String,
        @SerialName("shopName")
        val shopName: String,
        @SerialName("shopOfTheYearFlag")
        val shopOfTheYearFlag: Int,
        @SerialName("shopUrl")
        val shopUrl: String,
        @SerialName("smallImageUrls")
        val smallImageUrls: List<SmallImageUrlEntity>,
        @SerialName("startTime")
        val startTime: String,
        @SerialName("tagIds")
        val tagIds: List<Int>,
        @SerialName("taxFlag")
        val taxFlag: Int
    )
}
