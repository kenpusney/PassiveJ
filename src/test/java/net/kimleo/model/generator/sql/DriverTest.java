package net.kimleo.model.generator.sql;

import net.kimleo.model.component.Entity;
import org.junit.Test;

public class DriverTest {

    private Driver driver = new DefaultDriver();

    @Test
    public void testDriver() throws Exception {
        Entity entity = new Entity();
        driver.gen(entity);
    }
}