package com.napier.sem;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ReportUtilTest {

    @Test
    void peopleDistributionCountry() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<Population> resultList = ReportUtil.peopleDistributionCountry(con);
        assertEquals(1, resultList.size());
        String expected = "Name: Aruba Population: 103000 City: 29034 Not City: 73966";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If everything is working then tests Distribution of people per country
    @Test
    void continentByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<Country> resultList = ReportUtil.continentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If all working then tests population of continents
    @Test
    void worldByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<Country> resultList = ReportUtil.worldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If all working tests the population of the world
    @Test
    void regionByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<Country> resultList = ReportUtil.regionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If all working tests populations of regions

    @Test
    void capitalWorldByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<CapitalCity> resultList = ReportUtil.capitalWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If all working tests population of capital cities

    @Test
    void capitalContinentByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<CapitalCity> resultList = ReportUtil.capitalContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If all working test the population of capitals per continent

    @Test
    void capitalRegionByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<CapitalCity> resultList = ReportUtil.capitalRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If all working tests the population of capitals per region

    @Test
    void citiesDistrictByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<City> resultList = ReportUtil.citiesDistrictByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).toString());
    }
    //If all working tests population of capital districts

    @Test
    void citiesCountryByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<City> resultList = ReportUtil.citiesCountryByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).toString());
    }
    //if all working tests specific cities in countries population

    @Test
    void citiesRegionByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<City> resultList = ReportUtil.citiesRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).toString());
    }
    //if all working tests city region populations

    @Test
    void citiesContinentByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<City> resultList = ReportUtil.citiesContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).toString());
    }
    //if all working tests cities in continents by population

    @Test
    void citiesWorldByPopulation() throws SQLException {
        Connection con = new TestConnection();
        ArrayList<City> resultList = ReportUtil.citiesWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).toString());
    }
    //if all working tests cities of the world population
    class TestConnection extends Connection {
        @Override
        public Statement createStatement() throws SQLException {
            return new TestStatement();
        }
    }
    class TestStatement extends Statement {
        @Override
        public ResultSet executeQuery(String sql) throws SQLException {
            return new TestResultSet();
        }
    }
    class TestResultSet extends ResultSet {
        private boolean nextCalled = false;

        @Override
        public boolean next() throws SQLException {
            if (!nextCalled) {
                nextCalled = true;
                return true;
            }
            return false;
        }
        @Override
        public String getString(String columnLabel) throws SQLException {
            switch (columnLabel) {
                case "reportName":
                    return "Aruba";
                case "totalCity":
                    return "29034";
                case "totalPopulation":
                    return "103000";
                case "totalNotCity":
                    return "73966";
                case "Code":
                    return "BEL";
                case "Name":
                    return "Belgium";
                case "Continent":
                    return "Europe";
                case "Population":
                    return "10239000";
                case "Region":
                    return "Western Europe";
                case "Capital":
                    return "Brussels";
                case "Country":
                    return "JPN";
                case "District":
                    return "Tokyo-to";
                case "City":
                    return "Tokyo";
                default:
                    return null;
            }
        }
    }
}