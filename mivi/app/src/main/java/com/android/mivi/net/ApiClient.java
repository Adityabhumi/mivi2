package com.android.mivi.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adi.
 * Class is use to create network connection.
 */
public class ApiClient {
    public static final String BASE_URL = "https://gitlab.com/mfebrianto/mivi-ios-android-test/raw/master/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
