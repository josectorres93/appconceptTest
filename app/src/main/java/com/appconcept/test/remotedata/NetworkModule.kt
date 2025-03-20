package com.appconcept.test.remotedata

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    fun provideCache(context: Application): Cache {
        val cacheDirectory = File(context.cacheDir, "httpcachedir")
        return Cache(cacheDirectory, 10L * 1024 * 1024)
    }

    @Provides
    fun provideOkHttpClient(application: Application): OkHttpClient {
        return OkHttpClient.Builder()
            .hostnameVerifier { _, _ -> true }
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(provideLoggingInterceptor())
            .cache(provideCache(application))
            .build()
    }

    @Provides
    fun provideRemoteContract(
        @Named("application") application: Application,
    ): RemoteContract {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient(application))
            .baseUrl("https://static.leboncoin.fr/")
            .build()
            .create(RemoteContract::class.java)
    }
}
