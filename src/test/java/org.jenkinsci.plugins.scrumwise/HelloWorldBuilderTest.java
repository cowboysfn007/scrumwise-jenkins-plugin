package org.jenkinsci.plugins.scrumwise;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rob on 9/16/14.
 */
public class HelloWorldBuilderTest {
    HelloWorldBuilder helloWorldBuilder;

    @Before
    public void setUp(){
        helloWorldBuilder = new HelloWorldBuilder("Rob");
    }

    @Test
    public void testGetName(){
        assertEquals("Rob", helloWorldBuilder.getName());
    }

}
