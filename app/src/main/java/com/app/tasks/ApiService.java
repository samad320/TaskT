package com.app.tasks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;

public interface ApiService {

    Call<List<StoreItem>> getStroreItems(@Header("XApiKey") String apiKey, @Body StoreUidRequest request)  ;
}
