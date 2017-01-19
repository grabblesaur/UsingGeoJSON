
package com.example.bayar.usinggeojson.api.model.firms.cluster;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Properties implements Serializable {

    @SerializedName("ClusterId")
    @Expose
    private Integer clusterId;
    @SerializedName("ParentClusterId")
    @Expose
    private Integer parentClusterId;
    @SerializedName("TotalPower")
    @Expose
    private Double totalPower;
    @SerializedName("HotSpotCount")
    @Expose
    private Integer hotSpotCount;
    @SerializedName("MaxArea")
    @Expose
    private Double maxArea;
    @SerializedName("PixelArea")
    @Expose
    private Double pixelArea;
    @SerializedName("ClusterDate")
    @Expose
    private String clusterDate;
    @SerializedName("IsIndustrial")
    @Expose
    private Integer isIndustrial;
    @SerializedName("FireType")
    @Expose
    private Integer fireType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Properties() {
    }

    /**
     * 
     * @param fireType
     * @param totalPower
     * @param parentClusterId
     * @param isIndustrial
     * @param maxArea
     * @param hotSpotCount
     * @param clusterDate
     * @param pixelArea
     * @param clusterId
     */
    public Properties(Integer clusterId, Integer parentClusterId, Double totalPower, Integer hotSpotCount, Double maxArea, Double pixelArea, String clusterDate, Integer isIndustrial, Integer fireType) {
        super();
        this.clusterId = clusterId;
        this.parentClusterId = parentClusterId;
        this.totalPower = totalPower;
        this.hotSpotCount = hotSpotCount;
        this.maxArea = maxArea;
        this.pixelArea = pixelArea;
        this.clusterDate = clusterDate;
        this.isIndustrial = isIndustrial;
        this.fireType = fireType;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public Integer getParentClusterId() {
        return parentClusterId;
    }

    public void setParentClusterId(Integer parentClusterId) {
        this.parentClusterId = parentClusterId;
    }

    public Double getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(Double totalPower) {
        this.totalPower = totalPower;
    }

    public Integer getHotSpotCount() {
        return hotSpotCount;
    }

    public void setHotSpotCount(Integer hotSpotCount) {
        this.hotSpotCount = hotSpotCount;
    }

    public Double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(Double maxArea) {
        this.maxArea = maxArea;
    }

    public Double getPixelArea() {
        return pixelArea;
    }

    public void setPixelArea(Double pixelArea) {
        this.pixelArea = pixelArea;
    }

    public String getClusterDate() {
        return clusterDate;
    }

    public void setClusterDate(String clusterDate) {
        this.clusterDate = clusterDate;
    }

    public Integer getIsIndustrial() {
        return isIndustrial;
    }

    public void setIsIndustrial(Integer isIndustrial) {
        this.isIndustrial = isIndustrial;
    }

    public Integer getFireType() {
        return fireType;
    }

    public void setFireType(Integer fireType) {
        this.fireType = fireType;
    }

}
