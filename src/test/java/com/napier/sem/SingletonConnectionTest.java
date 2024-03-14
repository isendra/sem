package com.napier.sem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonConnectionTest
{
    @Test
    void testSingleton(){
        SingletonConnection connection1 = SingletonConnection.getInstance();
        SingletonConnection connection2 = SingletonConnection.getInstance();
        assertTrue(connection1 == connection2);
    }
}