package com.napier.sem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class ReportUtilTest
{
    @Test
    void peopleDistributionCountry() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("Aruba");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(103000L);
        Mockito.when(result.getLong("totalCity")).thenReturn(29034L);
        Mockito.when(result.getLong("totalNotCity")).thenReturn(73966L);
        Mockito.when(result.getFloat("percentageCity")).thenReturn((float)28.19);
        Mockito.when(result.getFloat("percentageNotCity")).thenReturn((float)71.81);
        ArrayList<Population> resultList = ReportUtil.peopleDistributionCountry(con);
        assertEquals(1, resultList.size());
        String expected = "Name: Aruba Population: 103000 City: 29034(28.19%) Not City: 73966(71.81%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void peopleDistributionContinent() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("North America");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(482993000L);
        Mockito.when(result.getLong("totalCity")).thenReturn(168250381L);
        Mockito.when(result.getLong("totalNotCity")).thenReturn(314742619L);
        Mockito.when(result.getFloat("percentageCity")).thenReturn((float)34.83);
        Mockito.when(result.getFloat("percentageNotCity")).thenReturn((float)65.17);
        ArrayList<Population> resultList = ReportUtil.peopleDistributionContinent(con);
        assertEquals(1, resultList.size());
        String expected = "Name: North America Population: 482993000 City: 168250381(34.83%) Not City: 314742619(65.17%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void peopleDistributionRegion() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("British Islands");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(63398500L);
        Mockito.when(result.getLong("totalCity")).thenReturn(23045714L);
        Mockito.when(result.getLong("totalNotCity")).thenReturn(40352786L);
        Mockito.when(result.getFloat("percentageCity")).thenReturn((float)36.35);
        Mockito.when(result.getFloat("percentageNotCity")).thenReturn((float)63.65);
        ArrayList<Population> resultList = ReportUtil.peopleDistributionRegion(con);
        assertEquals(1, resultList.size());
        String expected = "Name: British Islands Population: 63398500 City: 23045714(36.35%) Not City: 40352786(63.65%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void countryContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Code")).thenReturn("BEL");
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Continent")).thenReturn("Europe");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Region")).thenReturn("Western Europe");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<Country> resultList = ReportUtil.countryContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void countryWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Code")).thenReturn("BEL");
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Continent")).thenReturn("Europe");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Region")).thenReturn("Western Europe");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<Country> resultList = ReportUtil.countryWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void countryRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Code")).thenReturn("BEL");
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Continent")).thenReturn("Europe");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Region")).thenReturn("Western Europe");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<Country> resultList = ReportUtil.countryRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCountryWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Code")).thenReturn("BEL");
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Continent")).thenReturn("Europe");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Region")).thenReturn("Western Europe");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<Country> resultList = ReportUtil.nCountryWorldByPopulation(con, "10");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCountryContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Code")).thenReturn("BEL");
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Continent")).thenReturn("Europe");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Region")).thenReturn("Western Europe");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<Country> resultList = ReportUtil.nCountryContinentByPopulation(con, "param", "11");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCountryRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Code")).thenReturn("BEL");
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Continent")).thenReturn("Europe");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Region")).thenReturn("Western Europe");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<Country> resultList = ReportUtil.nCountryRegionByPopulation(con, "param", "8");
        assertEquals(1, resultList.size());
        String expected = "Country code: BEL Country name: Belgium Continent: Europe Region: Western Europe Population: 10239000 Capital: Brussels";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void capitalWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.capitalWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void capitalContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.capitalContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void capitalRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        ArrayList<CapitalCity> resultList = ReportUtil.capitalRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCapitalWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.nCapitalWorldByPopulation(con, "13");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCapitalContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        ArrayList<CapitalCity> resultList = ReportUtil.nCapitalContinentByPopulation(con, "param", "13");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCapitalRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Belgium");
        Mockito.when(result.getString("Capital")).thenReturn("Brussels");
        Mockito.when(result.getString("Population")).thenReturn("10239000");
        ArrayList<CapitalCity> resultList = ReportUtil.nCapitalRegionByPopulation(con, "param", "13");
        assertEquals(1, resultList.size());
        String expected = "City: Brussels Country: Belgium Population: 10239000";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesDistrictByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesDistrictByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesCountryByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesCountryByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void citiesRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesRegionByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    /*
    @Test
    void citiesContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesContinentByPopulation(con, "param");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }
    */

    @Test
    void citiesWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.citiesWorldByPopulation(con);
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesWorldByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.nCitiesWorldByPopulation(con, "13");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesContinentByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.nCitiesContinentByPopulation(con, "param", "12");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesRegionByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.nCitiesRegionByPopulation(con, "param", "9");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesCountryByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.nCitiesCountryByPopulation(con, "param", "11");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void nCitiesDistrictByPopulation() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Name")).thenReturn("Tokyo");
        Mockito.when(result.getString("Country")).thenReturn("JPN");
        Mockito.when(result.getString("District")).thenReturn("Tokyo-to");
        Mockito.when(result.getString("Population")).thenReturn("7980230");
        ArrayList<City> resultList = ReportUtil.nCitiesDistrictByPopulation(con, "param", "7");
        assertEquals(1, resultList.size());
        String expected = "City: Tokyo Country: JPN District: Tokyo-to Population: 7980230";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void totalPopulationWorld() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("World");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(6078749450L);
        ArrayList<Population> resultList = ReportUtil.totalPopulationWorld(con);
        assertEquals(1, resultList.size());
        String expected = "Name: World Population: 6078749450 City: 0(0.0%) Not City: 0(0.0%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void totalPopulationContinent() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("Europe");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(730074600L);
        ArrayList<Population> resultList = ReportUtil.totalPopulationContinent(con, "Europe");
        assertEquals(1, resultList.size());
        String expected = "Name: Europe Population: 730074600 City: 0(0.0%) Not City: 0(0.0%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void totalPopulationRegion() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("Caribbean");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(38140000L);
        ArrayList<Population> resultList = ReportUtil.totalPopulationRegion(con, "Caribbean");
        assertEquals(1, resultList.size());
        String expected = "Name: Caribbean Population: 38140000 City: 0(0.0%) Not City: 0(0.0%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void totalPopulationCountry() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("United Kingdom");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(59623400L);
        ArrayList<Population> resultList = ReportUtil.totalPopulationCountry(con, "United Kingdom");
        assertEquals(1, resultList.size());
        String expected = "Name: United Kingdom Population: 59623400 City: 0(0.0%) Not City: 0(0.0%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void totalPopulationDistrict() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("Scotland");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(1429620L);
        ArrayList<Population> resultList = ReportUtil.totalPopulationDistrict(con, "Scotland");
        assertEquals(1, resultList.size());
        String expected = "Name: Scotland Population: 1429620 City: 0(0.0%) Not City: 0(0.0%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void totalPopulationCity() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("reportName")).thenReturn("Edinburgh");
        Mockito.when(result.getLong("totalPopulation")).thenReturn(450180L);
        ArrayList<Population> resultList = ReportUtil.totalPopulationCity(con, "Edinburgh");
        assertEquals(1, resultList.size());
        String expected = "Name: Edinburgh Population: 450180 City: 0(0.0%) Not City: 0(0.0%)";
        assertEquals(expected, resultList.get(0).ToString());
    }

    @Test
    void languagePercentage() throws SQLException {
        Connection con = mock(Connection.class);
        ResultSet result = mock(ResultSet.class);
        Statement stmt = mock(Statement.class);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getString("Language")).thenReturn("Chinese");
        Mockito.when(result.getInt("noOfSpeakers")).thenReturn(1191843539);
        Mockito.when(result.getDouble("percentWorldPop")).thenReturn(60.55);
        ArrayList<Language> resultList = ReportUtil.languagePercentage(con);
        assertEquals(1, resultList.size());
        String expected = "Language: Chinese noOfSpeakers: 1191843539 percentWorldPop: 60.55%";
    }
}