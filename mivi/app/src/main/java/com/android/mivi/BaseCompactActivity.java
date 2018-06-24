package com.android.mivi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.android.mivi.net.ApiClient;
import com.android.mivi.net.ApiInterface;

/**
 * Created by adi.
 */
public abstract class BaseCompactActivity extends AppCompatActivity {
    public ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ApiInterface getAPIInterfaceService() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        return apiInterface;
    }

}
