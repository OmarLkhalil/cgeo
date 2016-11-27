package cgeo.geocaching.models;

import static org.assertj.core.api.Java6Assertions.assertThat;

import cgeo.geocaching.sorting.GeocodeComparator;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

public class GeocodeComparatorTest extends TestCase {

    public void testSomething() {
        final List<Geocache> caches = new ArrayList<>();
        caches.add(createGeocache("GC1ABCD"));
        caches.add(createGeocache("OCFBD3"));
        caches.add(createGeocache("GC2345"));
        caches.add(createGeocache(null));
        caches.add(createGeocache("GC56EFG"));
        caches.add(createGeocache("OC117B6"));
        caches.add(createGeocache("GC77"));

        Collections.sort(caches, new GeocodeComparator());

        assertThat(caches.get(0).getGeocode()).isNull();
        assertThat(caches.get(1).getGeocode()).isEqualTo("GC77");
        assertThat(caches.get(2).getGeocode()).isEqualTo("GC2345");
        assertThat(caches.get(3).getGeocode()).isEqualTo("GC1ABCD");
        assertThat(caches.get(4).getGeocode()).isEqualTo("GC56EFG");
        assertThat(caches.get(5).getGeocode()).isEqualTo("OCFBD3");
        assertThat(caches.get(6).getGeocode()).isEqualTo("OC117B6");
    }

    @NonNull
    private Geocache createGeocache(final String geocode) {
        final Geocache geocache = new Geocache();
        geocache.setGeocode(geocode);
        return geocache;
    }
}
