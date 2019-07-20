package runner;

import dom.DomParserCountry;
import model.Country;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import sax.CountryHandler;
import stax.StaxParserCountry;

import javax.xml.parsers.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class RunCountry
{

    private static final String COUNTRY_XML = "countries.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException
    {
        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        CountryHandler countryHandler = new CountryHandler();
        saxParser.parse(new File(COUNTRY_XML), countryHandler);
        List<Country> countries = countryHandler.getCountries();
        countries.forEach(country -> System.out.println(country));

        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(COUNTRY_XML));
        countries = new StaxParserCountry().parse(xmlEventReader);
        countries.forEach(country -> System.out.println(country));

        System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(COUNTRY_XML);
        countries = new DomParserCountry().parse(document);
        countries.forEach(country -> System.out.println(country));
    }

}
