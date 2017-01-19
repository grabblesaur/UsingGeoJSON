
package com.example.bayar.usinggeojson.api.model.firms.cluster;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class FirmsCluster {

    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("features")
    @Expose
    List<Feature> features = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FirmsCluster() {
    }

    /**
     * 
     * @param features
     * @param type
     */
    public FirmsCluster(String type, List<Feature> features) {
        super();
        this.type = type;
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

}
