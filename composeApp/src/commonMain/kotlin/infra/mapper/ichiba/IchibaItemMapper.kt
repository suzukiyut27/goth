package infra.mapper.ichiba

import domain.model.ichiba.GenreInformation
import domain.model.ichiba.Item
import domain.model.ichiba.Items
import domain.model.ichiba.MediumImageUrl
import domain.model.ichiba.SmallImageUrl
import domain.model.ichiba.TagInformation
import infra.entity.ichiba.item.ItemEntity
import infra.entity.ichiba.item.ItemsEntity
import infra.entity.ichiba.item.MediumImageUrlEntity
import infra.entity.ichiba.item.SmallImageUrlEntity

object IchibaItemMapper {
    fun translate(entity: ItemsEntity): Items {
        return Items(
            genreInformation = entity.genreInformation.map {
                GenreInformation(
                    genreId = it.genreId
                )
            },
            items = entity.items.map { translate(it) },
            tagInformation = entity.tagInformation.map {
                TagInformation(
                    tagGroupId = it.tagGroupId,
                    tagGroupName = it.tagGroupName
                )
            },
            carrier = entity.carrier,
            count = entity.count,
            first = entity.first,
            hits = entity.hits,
            last = entity.last,
            page = entity.page,
            pageCount = entity.pageCount
        )
    }

    private fun translate(itemEntity: ItemEntity): Item {
        return Item(
            affiliateRate = itemEntity.item.affiliateRate,
            affiliateUrl = itemEntity.item.affiliateUrl,
            asurakuFlag = itemEntity.item.asurakuFlag,
            asurakuArea = itemEntity.item.asurakuArea,
            asurakuClosingTime = itemEntity.item.asurakuClosingTime,
            availability = itemEntity.item.availability,
            catchCopy = itemEntity.item.catchCopy,
            creditCardFlag = itemEntity.item.creditCardFlag,
            endTime = itemEntity.item.endTime,
            genreId = itemEntity.item.genreId,
            giftFlag = itemEntity.item.giftFlag,
            imageFlag = itemEntity.item.imageFlag,
            itemCode = itemEntity.item.itemCode,
            itemCaption = itemEntity.item.itemCaption,
            itemName = itemEntity.item.itemName,
            itemPrice = itemEntity.item.itemPrice,
            itemPriceBaseField = itemEntity.item.itemPriceBaseField,
            itemPriceMax1 = itemEntity.item.itemPriceMax1,
            itemPriceMax2 = itemEntity.item.itemPriceMax2,
            itemPriceMax3 = itemEntity.item.itemPriceMax3,
            itemPriceMin1 = itemEntity.item.itemPriceMin1,
            itemPriceMin2 = itemEntity.item.itemPriceMin2,
            itemPriceMin3 = itemEntity.item.itemPriceMin3,
            itemUrl = itemEntity.item.itemUrl,
            pointRate = itemEntity.item.pointRate,
            pointRateStartTime = itemEntity.item.pointRateStartTime,
            pointRateEndTime = itemEntity.item.pointRateEndTime,
            reviewAverage = itemEntity.item.reviewAverage,
            reviewCount = itemEntity.item.reviewCount,
            postageFlag = itemEntity.item.postageFlag,
            shopOfTheYearFlag = itemEntity.item.shopOfTheYearFlag,
            shipOverseasFlag = itemEntity.item.shipOverseasFlag,
            shipOverseasArea = itemEntity.item.shipOverseasArea,
            shopAffiliateUrl = itemEntity.item.shopAffiliateUrl,
            shopCode = itemEntity.item.shopCode,
            shopName = itemEntity.item.shopName,
            shopUrl = itemEntity.item.shopUrl,
            smallImageUrls = itemEntity.item.smallImageUrls.map { translate(it) },
            mediumImageUrls = itemEntity.item.mediumImageUrls.map { translate(it) },
            startTime = itemEntity.item.startTime,
            tagIds = itemEntity.item.tagIds,
            taxFlag = itemEntity.item.taxFlag
        )
    }

    private fun translate(smallImageUrlEntity: SmallImageUrlEntity): SmallImageUrl {
        return SmallImageUrl(
            imageUrl = smallImageUrlEntity.imageUrl
        )
    }

    private fun translate(mediumImageUrlEntity: MediumImageUrlEntity): MediumImageUrl {
        return MediumImageUrl(
            imageUrl = mediumImageUrlEntity.imageUrl
        )
    }
}