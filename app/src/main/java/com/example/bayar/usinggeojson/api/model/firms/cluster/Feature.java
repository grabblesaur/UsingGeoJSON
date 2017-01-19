
package com.example.bayar.usinggeojson.api.model.firms.cluster;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Feature {

    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("geometry")
    @Expose
    Geometry geometry;
    @SerializedName("properties")
    @Expose
    Properties properties;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Feature() {
    }

    /**
     * 
     * @param properties
     * @param type
     * @param geometry
     */
    public Feature(String type, Geometry geometry, Properties properties) {
        super();
        this.type = type;
        this.geometry = geometry;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
