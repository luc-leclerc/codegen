package com.lleclerc.service.java;

import com.lleclerc.service.java.LazyReflectObjectMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class LazyReflectObjectMapTest {
    @Test
    public void map_onObject() {
        // GIVEN
        LazyReflectObjectMap map = new LazyReflectObjectMap(new LazyReflectObjectMapTestDummy());

        // THEN
        assertEquals("abcValue", map.get("abc"));
        assertEquals(Arrays.asList(1, 2, 3, 4), map.get("intArr"));

        Map<Object, Object> subObject = (Map) map.get("dummy");
        assertEquals("secondValue", subObject.get("abc"));

        List<LazyReflectObjectMapTestDummyDummy> list = (List<LazyReflectObjectMapTestDummyDummy>) map.get("potato");
        List<LazyReflectObjectMapTestDummyDummy> secondGet = (List<LazyReflectObjectMapTestDummyDummy>) map.get("potato");
        assertSame(list, secondGet);
    }

    public static class LazyReflectObjectMapTestDummy {
        String abc = "abcValue";
        List<Integer> intArr = Arrays.asList(1, 2, 3, 4);
        LazyReflectObjectMapTestDummyDummy dummy = new LazyReflectObjectMapTestDummyDummy();
        List<LazyReflectObjectMapTestDummyDummy> potato = Collections.singletonList(new LazyReflectObjectMapTestDummyDummy());
    }

    public static class LazyReflectObjectMapTestDummyDummy {
        String abc = "secondValue";
        List<Integer> intArr = Arrays.asList(2, 3);
    }
}