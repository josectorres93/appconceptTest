package com.appconcept.test.remotedata;

import com.appconcept.test.model.Album;
import retrofit2.Response;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/appconcept/test/remotedata/RemoteDataSource;", "", "request", "Lcom/appconcept/test/remotedata/RemoteContract;", "(Lcom/appconcept/test/remotedata/RemoteContract;)V", "getAlbumList", "Lcom/appconcept/test/remotedata/ResultWrapper;", "Lretrofit2/Response;", "", "Lcom/appconcept/test/model/Album;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RemoteDataSource {
    @org.jetbrains.annotations.NotNull
    private final com.appconcept.test.remotedata.RemoteContract request = null;
    
    @javax.inject.Inject
    public RemoteDataSource(@org.jetbrains.annotations.NotNull
    com.appconcept.test.remotedata.RemoteContract request) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAlbumList(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.appconcept.test.remotedata.ResultWrapper<retrofit2.Response<java.util.List<com.appconcept.test.model.Album>>>> $completion) {
        return null;
    }
}