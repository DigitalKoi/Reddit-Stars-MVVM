package com.koidev.data.mapper

import com.koidev.data.model.ListingEntity
import com.koidev.data.model.RedditEntity
import com.koidev.data.model.SubRedditEntity
import com.koidev.data.model.ThingEntity
import com.koidev.domain.model.reddit.Listing
import com.koidev.domain.model.reddit.Reddit
import com.koidev.domain.model.reddit.SubReddit
import com.koidev.domain.model.reddit.Thing

fun RedditEntity.toDomain(): Reddit = Reddit(
    kind = kind,
    listing = listing?.toDomain()
)

private fun ListingEntity.toDomain(): Listing = Listing(
    modhash = modhash,
    things = things?.map(ThingEntity::toDomain),
    after = after,
    before = before
)

private fun ThingEntity.toDomain(): Thing = Thing(
    kind = kind,
    data = data?.toDomain()
)

private fun SubRedditEntity.toDomain(): SubReddit = SubReddit(
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