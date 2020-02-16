package com.koidev.remote.mapper

import com.koidev.data.model.ListingEntity
import com.koidev.data.model.RedditEntity
import com.koidev.data.model.SubRedditEntity
import com.koidev.data.model.ThingEntity
import com.koidev.remote.model.response.ListingResponse
import com.koidev.remote.model.response.RedditResponse
import com.koidev.remote.model.response.SubRedditResponse
import com.koidev.remote.model.response.ThingResponse

fun RedditResponse.toEntity(): RedditEntity = RedditEntity(
    kind = kind,
    listing = listing?.toEntity()
)

private fun ListingResponse.toEntity(): ListingEntity = ListingEntity(
    modhash = modhash,
    things = things?.map(ThingResponse::toEntity),
    after = after,
    before = before
)

private fun ThingResponse.toEntity(): ThingEntity = ThingEntity(
    kind = kind,
    data = data?.toEntity()
)

private fun SubRedditResponse.toEntity(): SubRedditEntity = SubRedditEntity(
    bannerImg = bannerImg,
    userSrThemeEnabled = userSrThemeEnabled,
    submitTextHtml = submitTextHtml,
    userIsBanned = userIsBanned,
    wikiEnabled = wikiEnabled,
    showMedia = showMedia,
    id = id,
    submitText = submitText,
    displayName = displayName,
    headerImg = headerImg,
    descriptionHtml = descriptionHtml,
    title = title,
    collapseDeletedComments = collapseDeletedComments,
    over18 = over18,
    publicDescriptionHtml = publicDescriptionHtml,
    spoilersEnabled = spoilersEnabled,
    iconSize = iconSize,
    suggestedCommentSort = suggestedCommentSort,
    iconImg = iconImg,
    headerTitle = headerTitle,
    description = description,
    userIsMuted = userIsMuted,
    submitLinkLabel = submitLinkLabel,
    accountsActive = accountsActive,
    publicTraffic = publicTraffic,
    headerSize = headerSize,
    subscribers = subscribers,
    submitTextLabel = submitTextLabel,
    lang = lang,
    userIsModerator = userIsModerator,
    keyColor = keyColor,
    name = name,
    created = created,
    url = url,
    quarantine = quarantine,
    hideAds = hideAds,
    createdUtc = createdUtc,
    bannerSize = bannerSize,
    userIsContributor = userIsContributor,
    publicDescription = publicDescription,
    showMediaPreview = showMediaPreview,
    commentScoreHideMins = commentScoreHideMins,
    subredditType = subredditType,
    submissionType = submissionType,
    userIsSubscriber = userIsSubscriber
)