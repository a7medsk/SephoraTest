package com.example.sephoratest.di

import android.content.Context
import androidx.room.Room
import com.example.sephoratest.data.local.ProductDao
import com.example.sephoratest.data.local.ProductItemDataBase
import com.example.sephoratest.data.remote.ProductApi
import com.example.sephoratest.data.repository.DefaultProductRepository
import com.example.sephoratest.data.repository.ProductRepository
import com.example.sephoratest.other.Constants.BASE_URL
import com.example.sephoratest.other.Constants.DATABASE_NAME
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 *Created by haskhiri on 14/10/2021
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideProductItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ProductItemDataBase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDefaultProductRepository(
        dao: ProductDao,
        api: ProductApi
    ) = DefaultProductRepository( api,dao) as ProductRepository



    @Singleton
    @Provides
    fun provideProductDao(
        database: ProductItemDataBase
    ) = database.productDao()



    @Singleton
    @Provides
    fun provideProductApi(): ProductApi {
        val gson :Gson= GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
            .create(ProductApi::class.java)
    }


}