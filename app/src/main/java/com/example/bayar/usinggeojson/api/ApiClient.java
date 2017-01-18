package com.example.bayar.usinggeojson.api;


// http://maps.kosmosnimki.ru/rest/ver1/layers/3E88643A8AC94AFAB4FD44941220B1CE/search?query="ClusterDate">='2017-01-17'and"ClusterDate"<'2017-01-18'&api_key=B73WTOPAW2

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://maps.kosmosnimki.ru/rest/ver1/layers/";
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
