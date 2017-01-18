package com.example.bayar.usinggeojson.api;

import com.example.bayar.usinggeojson.api.model.FirmsCluster;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by qqq on 18.01.2017.
 */

// http://maps.kosmosnimki.ru/rest/ver1/layers/3E88643A8AC94AFAB4FD44941220B1CE/search?query="ClusterDate">='2017-01-17'and"ClusterDate"<'2017-01-18'&api_key=B73WTOPAW2

public interface ApiService {

    @GET("{layer_id}/search?query=\"ClusterDate\">='2017-01-17'and\"ClusterDate\"<'2017-01-18'")
    Call<FirmsCluster> getFirmsCluster(@Path("layer_id") String layerId, @Query("api_key") String apiKey);

}
