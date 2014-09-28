package org.jenkinsci.plugins.scrumwise;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rob on 9/16/14.
 */
public class ScrumwiseBuilderTest {
    ScrumwiseBuilder scrumwiseBuilder;

    @Before
    public void setUp(){
        scrumwiseBuilder = new ScrumwiseBuilder("test@test.com", "key", "projectID");
    }

    @Test
    public void testGetEmail(){
        assertEquals("test@test.com", scrumwiseBuilder.getEmail());
    }

    @Test
    public void testGetKey(){
        assertEquals("key", scrumwiseBuilder.getKey());
    }

    @Test
    public void testGetProjectID(){
        assertEquals("projectID", scrumwiseBuilder.getProjectID());
    }

}
