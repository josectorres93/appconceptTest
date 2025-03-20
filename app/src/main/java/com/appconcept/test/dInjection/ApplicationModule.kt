package com.appconcept.test.dInjection

import android.app.Application
import com.appconcept.test.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


    @Module
    @InstallIn(SingletonComponent::class)
    class ApplicationModule {

        @Provides
        @Named("application")
        fun provideApplication(): Application {
            return MainApplication.application
        }
    }