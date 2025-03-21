// Generated by Dagger (https://dagger.dev).
package com.appconcept.test.remotedata;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.Cache;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideCacheFactory implements Factory<Cache> {
  private final NetworkModule module;

  private final Provider<Application> contextProvider;

  public NetworkModule_ProvideCacheFactory(NetworkModule module,
      Provider<Application> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public Cache get() {
    return provideCache(module, contextProvider.get());
  }

  public static NetworkModule_ProvideCacheFactory create(NetworkModule module,
      Provider<Application> contextProvider) {
    return new NetworkModule_ProvideCacheFactory(module, contextProvider);
  }

  public static Cache provideCache(NetworkModule instance, Application context) {
    return Preconditions.checkNotNullFromProvides(instance.provideCache(context));
  }
}
