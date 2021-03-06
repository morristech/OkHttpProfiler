package com.itkacher.okprofilerexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
//    private static final String JSON_URL = "https://raw.githubusercontent.com/itkacher/OkHttpProfiler/master/large_random_json.json";
    private static final String JSON_URL = "https://raw.githubusercontent.com/itkacher/OkHttpProfiler/master/colors.json";
    private OkHttpClient mClient = new OkHttpClient.Builder().addInterceptor(
            new OkHttpProfilerInterceptor()
    ).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequest();
        findViewById(R.id.send_request).setOnClickListener(v -> {
            sendRequest();
        });
    }

    private void sendRequest() {
        Request request = new Request.Builder()
                .url(JSON_URL)
                .get()
                .build();

        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            }

            @SuppressWarnings("unused")
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                try {
                    if (response.body() != null) {
                        String unusedText = response.body().string();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
