
package com.example.bayar.usinggeojson.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("geometry")
    @Expose
    private Geometry geometry;
    @SerializedName("properties")
    @Expose
    private Properties properties;

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
