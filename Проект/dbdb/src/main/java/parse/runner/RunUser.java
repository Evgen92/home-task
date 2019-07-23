package parse.runner;//package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import parse.dom.DomParserUser;
import parse.model.User;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import parse.sax.UserHandler;
import parse.stax.StaxParserUser;


public class RunUser
{

    private static final String USER_XML = "users.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
            XMLStreamException
    {
        System.out.println(" ========================= SAX parser ==============================");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        UserHandler userHandler = new UserHandler();
        saxParser.parse(new File(USER_XML), userHandler);
        List<User> users = userHandler.getUsers();
        users.forEach(user -> System.out.println(user));

        System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(USER_XML));
        users = new StaxParserUser().parse(xmlEventReader);
        users.forEach(user -> System.out.println(user));

        System.out.println(" ============================== DOM parser =========================");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(USER_XML);
        users = new DomParserUser().parse(document);
        users.forEach(user -> System.out.println(user));
    }
}
