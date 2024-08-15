package com.tiagomdosantos.rickyandmorty.data.di

import com.airbnb.lottie.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tiagomdosantos.rickyandmorty.data.ApiService
import com.tiagomdosantos.rickyandmorty.data.utils.BASE_URL
import com.tiagomdosantos.rickyandmorty.domain.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private fun okHttpClient(): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()

        okHttpClient.connectTimeout(10, TimeUnit.SECONDS)
        okHttpClient.readTimeout(30, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(30, TimeUnit.SECONDS)

        when {
            BuildConfig.DEBUG -> {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                okHttpClient.addInterceptor(logging)
            }
        }

        return okHttpClient

    }

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesAPI(moshi: Moshi): ApiService {
        val httpClient = okHttpClient()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCharactersRepository(
        apiService: ApiService
    ): CharactersRepository {
        return CharactersRepository(apiService)
    }
}