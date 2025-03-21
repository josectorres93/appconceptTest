// Generated by Dagger (https://dagger.dev).
package com.appconcept.test.viewmodel;

import com.appconcept.test.repository.AlbumRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AlbumViewModel_Factory implements Factory<AlbumViewModel> {
  private final Provider<AlbumRepository> repositoryProvider;

  public AlbumViewModel_Factory(Provider<AlbumRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AlbumViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static AlbumViewModel_Factory create(Provider<AlbumRepository> repositoryProvider) {
    return new AlbumViewModel_Factory(repositoryProvider);
  }

  public static AlbumViewModel newInstance(AlbumRepository repository) {
    return new AlbumViewModel(repository);
  }
}
