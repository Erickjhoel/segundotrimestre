/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daw
 */
public class Arrive {

    private int stopId;
    private String lineId;
    private String isHead;
    private String destination;
    private String busId;
    private int busTimeLeft;
    private int busDistance;
    private double latitude;
    private double longitude;
    private int busPositionType;

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getIsHead() {
        return isHead;
    }

    public void setIsHead(String isHead) {
        this.isHead = isHead;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public int getBusTimeLeft() {
        return busTimeLeft;
    }

    public void setBusTimeLeft(int busTimeLeft) {
        this.busTimeLeft = busTimeLeft;
    }

    public int getBusDistance() {
        return busDistance;
    }

    public void setBusDistance(int busDistance) {
        this.busDistance = busDistance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getBusPositionType() {
        return busPositionType;
    }

    public void setBusPositionType(int busPositionType) {
        this.busPositionType = busPositionType;
    }
    
}
