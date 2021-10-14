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
class ProductDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ProductItemDataBase
    private lateinit var dao: ProductDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ProductItemDataBase::class.java
        ).allowMainThreadQueries().build()
        dao = database.productDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest {
        val sephoraItem = Product("1","description","location","urlimage")
        dao.insertProductItem(sephoraItem)

        val allShoppingItems = dao.getAllProductItems().getOrAwaitValue()

        assertThat(allShoppingItems).contains(sephoraItem)
    }




}
