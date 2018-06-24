package com.android.mivi.net;

import android.content.Context;
import android.util.Log;
import com.android.mivi.callback.APICallback;
import com.android.mivi.customs.ProgressLoading;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by adi.
 * Class will be use for all api call.
 */
public class APICall {
    public static String TAG = APICall.class.getName();

    private ProgressLoading loading;
    private Call<ResponseBody> callAPI = null;

    public APICall(Context context) {
        this.loading        = new ProgressLoading(context);
    }

    public void callAPIFunction(ApiInterface apiInterface, final APICallback apiCallback) {
        loading.onShow();
        callAPI = apiInterface.getPlanInfo();
        callAPI.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, new StringBuilder().append("callAll:onResponse:-").append(response.message()).append(response.code()).append(response.isSuccessful()).toString());
                loading.dismiss();
                apiCallback.onSuccess(response);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d(TAG, new StringBuilder().append("createUser:onFailure:-").append(t.getMessage()).toString());
                loading.dismiss();
                call.cancel();
                apiCallback.onFailure(t);
            }
        });
    }
}
