package com.appconcept.test.repository;

import com.appconcept.test.database.AlbumDao;
import com.appconcept.test.model.Album;
import com.appconcept.test.remotedata.RemoteDataSource;
import com.appconcept.test.remotedata.ResultWrapper;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/appconcept/test/repository/AlbumRepository;", "", "remoteDataSource", "Lcom/appconcept/test/remotedata/RemoteDataSource;", "albumDao", "Lcom/appconcept/test/database/AlbumDao;", "(Lcom/appconcept/test/remotedata/RemoteDataSource;Lcom/appconcept/test/database/AlbumDao;)V", "getAlbumsFromDb", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/appconcept/test/model/Album;", "getAlbuns", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AlbumRepository {
    @org.jetbrains.annotations.NotNull
    private final com.appconcept.test.remotedata.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.appconcept.test.database.AlbumDao albumDao = null;
    
    @javax.inject.Inject
    public AlbumRepository(@org.jetbrains.annotations.NotNull
    com.appconcept.test.remotedata.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    com.appconcept.test.database.AlbumDao albumDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.appconcept.test.model.Album>> getAlbumsFromDb() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAlbuns(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.appconcept.test.model.Album>> $completion) {
        return null;
    }
}