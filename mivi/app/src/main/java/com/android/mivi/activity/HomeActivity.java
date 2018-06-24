package com.android.mivi.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.mivi.BaseCompactActivity;
import com.android.mivi.R;
import com.android.mivi.net.Utils;
import com.android.mivi.adapter.InfoListAdapter;
import com.android.mivi.callback.APICallback;
import com.android.mivi.model.CollectionParse;
import com.android.mivi.model.Info;
import com.android.mivi.net.APICall;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by adi.
 */
public class HomeActivity extends BaseCompactActivity {
    public static String TAG = LoginActivity.class.getName();
    private CollectionParse collectionParse;

    private RecyclerView subscriptions;
    private List<Info> infoListSub;
    private InfoListAdapter infoListAdapter;

    private RecyclerView product;
    private List<Info> infoListProd;
    private InfoListAdapter infoListAdapterProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        new APICall(this).callAPIFunction(getAPIInterfaceService(), new APICallback() {
            @Override
            public void onSuccess(Response<ResponseBody> response) {
                collectionParse = new CollectionParse();
                if (response.isSuccessful()) {
                    try {
                        String responseStr = response.body().string();
                        Log.d(TAG, "callAPIFunction:onSuccess:signUpButton:-" + responseStr);
                        Gson gson = new Gson();
                        collectionParse = gson.fromJson(responseStr, CollectionParse.class);

                        findViewById(R.id.topView).setVisibility(View.VISIBLE);
                        initializeProfileInfo();

                        infoListSub = new ArrayList<>();
                        infoListSub = Utils.getSubProdData(collectionParse.getIncluded().get(1).getAttributes());
                        if (infoListSub.size() > 0) {
                            findViewById(R.id.subTitle).setVisibility(View.VISIBLE);
                            initializeSubsList();
                        }


                        infoListProd = new ArrayList<>();
                        infoListProd = Utils.getSubProdData(collectionParse.getIncluded().get(2).getAttributes());
                        if (infoListProd.size() > 0) {
                            findViewById(R.id.prodTitle).setVisibility(View.VISIBLE);
                            initializeCategoryList();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JsonParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d(TAG, new StringBuilder().append("callAPIFunction:onFailure:-").append(throwable.getMessage()).toString());
            }
        });

    }

    /**
     * Initialize profile info
     */
    private void initializeProfileInfo() {
        TextView name = findViewById(R.id.name);
        name.setText(collectionParse.getData().getAttributes().getTitle() + " "+ collectionParse.getData().getAttributes().getFirstName() + " "+ collectionParse.getData().getAttributes().getLastName());

        TextView email = findViewById(R.id.email);
        email.setText(collectionParse.getData().getAttributes().getEmailAddress());

        TextView contact = findViewById(R.id.contact);
        contact.setText(collectionParse.getData().getAttributes().getContactNumber());

        TextView dob = findViewById(R.id.dob);
        dob.setText(collectionParse.getData().getAttributes().getDateOfBirth());

        TextView plan = findViewById(R.id.plan);
        plan.setText(collectionParse.getData().getAttributes().getPaymentType());
    }

    /**
     * Initialize sub info
     */
    private void initializeSubsList() {
        subscriptions = (RecyclerView) findViewById(R.id.subscriptions);
        infoListAdapter = new InfoListAdapter(infoListSub, this);
        //subscriptions.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        subscriptions.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));
        subscriptions.setNestedScrollingEnabled(false);
        subscriptions.setItemAnimator(new DefaultItemAnimator());
        subscriptions.setHasFixedSize(false);
        subscriptions.setAdapter(infoListAdapter);
    }

    /**
     * Initialize prod info
     */
    private void initializeCategoryList() {
        product = (RecyclerView) findViewById(R.id.products);
        infoListAdapterProd = new InfoListAdapter(infoListProd, this);
        //product.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        product.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));
        product.setNestedScrollingEnabled(true);
        product.setItemAnimator(new DefaultItemAnimator());
        product.setHasFixedSize(false);
        product.setAdapter(infoListAdapterProd);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}