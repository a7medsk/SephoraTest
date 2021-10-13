package com.example.sephoratest.data.local


/**
 *Created by haskhiri on 13/10/2021
 */


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.sephoratest.getOrAwaitValue

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class SephoraDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: SephoraItemDataBase
    private lateinit var dao: SephoraDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SephoraItemDataBase::class.java
        ).allowMainThreadQueries().build()
        dao = database.sephoraDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {
        val sephoraItem = SephoraItem(1,"description","location","urlimage")
        dao.insertSephoraItem(sephoraItem)

        val allShoppingItems = dao.observeAllSephoraItems().getOrAwaitValue()

        assertThat(allShoppingItems).contains(sephoraItem)
    }




}
