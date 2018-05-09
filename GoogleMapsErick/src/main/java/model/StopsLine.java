/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author daw
 */
public class StopsLine {

    private String idClient;
    private String passKey;
    private String line;
    private String direction;
    private String statistics;
    private String cultureInfo;
    private String lineId;
    private String label;
    private String destination;
    private int incidents;
    private List<Stop> stop;
//    private Lsit<Line> line;

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public String getCultureInfo() {
        return cultureInfo;
    }

    public void setCultureInfo(String cultureInfo) {
        this.cultureInfo = cultureInfo;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getIncidents() {
        return incidents;
    }

    public void setIncidents(int incidents) {
        this.incidents = incidents;
    }

    public List<Stop> getStop() {
        return stop;
    }

    public void setStop(List<Stop> stop) {
        this.stop = stop;
    }

}
