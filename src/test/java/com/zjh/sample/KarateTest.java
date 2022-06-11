package com.zjh.sample;

import com.intuit.karate.junit5.Karate;

public class KarateTest {

    @Karate.Test
    public Karate testPlayList() {
        return Karate.run("classpath:com/zjh/sample/feature/play_list.feature").relativeTo(getClass());
    }

    @Karate.Test
    public Karate testMediaType() {
        return Karate.run("classpath:com/zjh/sample/feature/media_type.feature").relativeTo(getClass());
    }

    @Karate.Test
    public Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}
