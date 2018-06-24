package com.android.mivi.callback;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by adi.
 */

public interface APICallback {
    public void onSuccess(Response<ResponseBody> response);
    public void onFailure(Throwable throwable);
}
