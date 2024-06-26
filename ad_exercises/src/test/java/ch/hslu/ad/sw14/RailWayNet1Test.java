package ch.hslu.ad.sw14;

import nl.jqno.equalsverifier.internal.prefabvalues.Tuple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RailWayNet1Test {

    private RailWayNet1 net;
    private int stationCount;
    private int connectionCount;

    @BeforeEach
    public void init() {
        net = RailWayNetTestUtils.createAdjacencyMatrixRailwayNet();
        stationCount = RailWayNetTestUtils.getStationCount();
        connectionCount = RailWayNetTestUtils.getConnectionCount();
    }

    @Test
    public void testStationCount() {
        assertEquals(stationCount, net.getStationCount());
    }

    @Test
    public void testConnectionCount() {
        assertEquals(connectionCount, net.getConnectionCount());
    }

    @Test
    public void testHasConnectionBetweenConnected() {
        List<Tuple<String>> connected = new ArrayList<>();
        connected.add(new Tuple<String>("Olten", "Zürich", "Olten"));
        connected.add(new Tuple<String>("Pfäffikon", "Arth-Goldau", "Pfäffikon"));
        connected.add(new Tuple<String>("Rotkreuz", "Wohlen", "Rotkreuz"));
        connected.add(new Tuple<String>("Luzern", "Zofingen", "Luzern"));
        for (Tuple<String> t : connected) {
            assertTrue(net.hasConnectionBetween(t.getRed(), t.getBlue()));
        }
    }

    @Test
    public void testHasConnectionBetweenUnconnected() {
        List<Tuple<String>> unconnected = new ArrayList<>();
        unconnected.add(new Tuple<String>("Olten", "Pfäffikon","Olten" ));
        unconnected.add(new Tuple<String>("Zofingen", "Zürich", "Zofingen"));
        unconnected.add(new Tuple<String>("Luzern", "Brugg", "Luzern"));
        unconnected.add(new Tuple<String>("Dietikon", "Arth-Goldau", "Dietikon"));
        for (Tuple<String> t : unconnected) {
            assertFalse(net.hasConnectionBetween(t.getRed(), t.getBlue()));
        }
    }

    @Test
    public void testGetDirectlyConnectedStations() {
        String[] rotkreuzConnections = new String[]{"Luzern", "Wohlen", "Zug", "Arth-Goldau"};
        Collection<String> connected = net.getDirectlyConnectedStations("Rotkreuz");
        assertEquals(4, connected.size());
        for (String to : rotkreuzConnections) {
            assertTrue(connected.contains(to));
        }
    }

    @Test
    public void testGetDurationOltenZuerich() {
        assertEquals(36, net.getDuration("Olten", "Zürich"));
    }

    @Test
    public void testGetDurationBruggAarau() {
        assertEquals(13, net.getDuration("Brugg", "Aarau"));
    }

    @Test
    public void testGetDurationRotkreuzArthGoldau() {
        assertEquals(15, net.getDuration("Rotkreuz", "Arth-Goldau"));
    }
}