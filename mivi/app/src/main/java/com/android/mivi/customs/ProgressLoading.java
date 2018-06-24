package com.android.mivi.customs;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by adi.
 * show the progress bar on api call.
 */
public class ProgressLoading {
    private Context context;
    private ProgressDialog progressDialog;

    public ProgressLoading(Context context){
        this.context = context;
        this.progressDialog = new ProgressDialog(context);
    }

    public void onShow(){
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        //progressDialog.setTitle("Please Wait...");
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
    }

    public void dismiss(){
        progressDialog.dismiss();
    }
}