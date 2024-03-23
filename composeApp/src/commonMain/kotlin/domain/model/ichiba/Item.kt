package domain.model.ichiba

data class Item(
    val affiliateRate: Int,
    val affiliateUrl: String,
    val asurakuArea: String,
    val asurakuClosingTime: String,
    val asurakuFlag: Int,
    val availability: Int,
    val catchCopy: String,
    val creditCardFlag: Int,
    val endTime: String,
    val genreId: String,
    val giftFlag: Int,
    val imageFlag: Int,
    val itemCaption: String,
    val itemCode: String,
    val itemName: String,
    val itemPrice: Int,
    val itemPriceBaseField: String,
    val itemPriceMax1: Int,
    val itemPriceMax2: Int,
    val itemPriceMax3: Int,
    val itemPriceMin1: Int,
    val itemPriceMin2: Int,
    val itemPriceMin3: Int,
    val itemUrl: String,
    val mediumImageUrls: List<MediumImageUrl>,
    val pointRate: Int,
    val pointRateStartTime: String,
    val pointRateEndTime: String,
    val postageFlag: Int,
    val reviewAverage: Float,
    val reviewCount: Int,
    val shipOverseasArea: String,
    val shipOverseasFlag: Int,
    val shopAffiliateUrl: String,
    val shopCode: String,
    val shopName: String,
    val shopOfTheYearFlag: Int,
    val shopUrl: String,
    val smallImageUrls: List<SmallImageUrl>,
    val startTime: String,
    val tagIds: List<Int>,
    val taxFlag: Int
)