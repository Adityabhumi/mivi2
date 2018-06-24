package com.android.mivi.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by adi.
 * API Call Here
 */
public interface ApiInterface {
    @GET("collection.json")
    public Call<ResponseBody> getPlanInfo();
}
