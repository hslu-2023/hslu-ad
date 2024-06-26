package ch.hslu.ad.sw14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RailWayNet1 {

    private String[] stations;
    private int[][] connections;
    private int connectionCount;

    public RailWayNet1(String... stations) {
        this.stations = stations;
        final int n = this.stations.length;
        connections = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                connections[i][j] = 0;
            }
        }
    }

    public void addConnection(String from, String to, int duration) {
        int f = findStationIndex(from);
        int t = findStationIndex(to);
        if (connections[f][t] == 0 && connections[t][f] == 0) {
            connectionCount++;
        }
        connections[f][t] = duration;
        connections[t][f] = duration;
    }

    public int getStationCount() {
        return stations.length;
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public boolean hasConnectionBetween(String a, String b) {
        int i = findStationIndex(a);
        int j = findStationIndex(b);
        return connections[i][j] != 0;
    }

    public Collection<String> getDirectlyConnectedStations(String station) {
        List<String> connectedStations = new ArrayList<>();
        for (String other : stations) {
            if (hasConnectionBetween(station, other)) {
                connectedStations.add(other);
            }
        }
        return connectedStations;
    }

    public int getDuration(String from, String to) {
        if (hasConnectionBetween(from, to)) {
            int i = findStationIndex(from);
            int j = findStationIndex(to);
            return connections[i][j];
        }
        throw new IllegalStateException("'" + from + "'/'" + to + "' not connected");
    }

    private int findStationIndex(String station) {
        for (int i = 0; i < stations.length; i++) {
            if (stations[i].equals(station)) {
                return i;
            }
        }
        throw new IllegalArgumentException(" station '" + station + "' doesn't exist");
    }
}