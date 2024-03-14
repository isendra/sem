package com.napier.sem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SQLUtilTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    void validSQL() {
        boolean valid = SQLUtil.isValid("test.sql");
        assertEquals(true, valid);
    }
    @Test
    void invalidSQL() {
        boolean valid = SQLUtil.isValid("invalidTest.sql");
        assertEquals(false, valid);
    }
    @Test
    void runSQL() throws SQLException {
        Connection con = new TestConnection();
        String[] params = {"test"};
        ResultSet result = SQLUtil.run(con, "test.sql", params);
        // Here you can check further if the correct SQL query is executed based on the provided parameters
        assertEquals(null, result);
    }
    @Test
    void runSQLError() {
        Connection con = new TestErrorConnection();
        String[] params = {"test"};
        ResultSet result = SQLUtil.run(con, "test.sql", params);
        assertNull(result);
        assertTrue(outputStreamCaptor.toString().contains("Statement execution failed!"));
    }

    static class TestConnection extends Connection {
        @Override
        public Statement createStatement() throws SQLException {
            return new TestStatement();
        }
    }
    static class TestStatement extends Statement {
        @Override
        public ResultSet executeQuery(String sql) throws SQLException {
            return new TestResultSet();
        }
    }
    static class TestResultSet extends ResultSet {
        @Override
        public boolean next() throws SQLException {
            return false;
        }
        @Override
        public String getString(String columnLabel) throws SQLException {
            // Return appropriate values based on the test case
            return null;
        }
    }
    static class TestErrorConnection extends Connection {
        @Override
        public Statement createStatement() throws SQLException {
            throw new SQLException();
        }
    }
}
