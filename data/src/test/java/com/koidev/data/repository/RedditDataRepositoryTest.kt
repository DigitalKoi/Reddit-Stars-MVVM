package com.koidev.data.repository

import com.koidev.data.factory.DataFactory
import com.koidev.data.model.ListingEntity
import com.koidev.data.model.RedditEntity
import com.koidev.data.repository.reddit.DefaultRedditRepository
import com.koidev.data.store.RedditDataStoreFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RedditDataRepositoryTest {

    private lateinit var factory: RedditDataStoreFactory

    private lateinit var repository: DefaultRedditRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        factory = RedditDataStoreFactory(
            redditRemote = mock(),
            redditCache = mock()
        )

        repository = DefaultRedditRepository(
            factory = factory
        )
    }

    @Test
    fun `fetch reddit calls from remote data store`() {

        val nextPage = DataFactory.randomInt()

        val result = Single.just(
            RedditEntity(
                kind = DataFactory.randomString(),
                listing = ListingEntity(
                    modhash = DataFactory.randomString(),
                    things = emptyList(),
                    after = DataFactory.randomString()
                )
            )
        )

        stubFetchReddit(result)

        repository.fetchReddit(nextPage).test().apply {
            assertComplete()
            assertNoErrors()
        }

        verify(factory.getCache(), never()).fetchReddit(nextPage)
        verify(factory.getRemote()).fetchReddit(nextPage)
    }

    private fun stubFetchReddit(single: Single<RedditEntity>) {
        whenever(factory.getRemote().fetchReddit(any())).thenReturn(single)
    }
}