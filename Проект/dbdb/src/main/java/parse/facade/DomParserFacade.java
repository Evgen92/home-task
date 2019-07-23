package parse.facade;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import parse.dom.DomParserUser;
import parse.model.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class DomParserFacade {

    private List<User> users;
    private static final String USER_XML = "users.xml";

    public List<User> convertXml(String xml) throws IOException, SAXException, XMLStreamException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(USER_XML);
        users = new DomParserUser().parse(document);
        return users;
    }
}
