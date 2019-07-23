package parse.sax;

import parse.model.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class UserHandler extends DefaultHandler
{
    private List<User> users;
    private User user;
    boolean bLogin = false;
    boolean bPassword = false;
    boolean bName = false;
    boolean bGender = false;
    boolean bMessage = false;

    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {

        if (qName.equalsIgnoreCase("User"))
        {
            String id = attributes.getValue("id");
            user = new User();
            user.setId(Integer.parseInt(id));
            if (users == null)
            {
                users = new ArrayList<>();
            }
        }
        else if (qName.equalsIgnoreCase("login"))
        {
            bLogin = true;
        }
        else if (qName.equalsIgnoreCase("password"))
        {
            bPassword = true;
        }
        else if (qName.equalsIgnoreCase("name"))
        {
            bName = true;
        }
        else if (qName.equalsIgnoreCase("gender"))
        {
            bGender = true;
        }
        else if (qName.equalsIgnoreCase("message"))
        {
            bMessage = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equalsIgnoreCase("User"))
        {
            users.add(user);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException
    {

        if (bLogin)
        {
            user.setLogin(new String(ch, start, length));
            bLogin = false;
        }
        else if (bPassword)
        {
            user.setPassword(new String(ch, start, length));
            bPassword = false;
        }
        else if (bName)
        {
            user.setName(new String(ch, start, length));
            bName = false;
        }
        else if (bGender)
        {
            user.setGender(new String(ch, start, length));
            bGender = false;
        }
        else if (bMessage)
        {
            user.setMessage(new String(ch, start, length));
            bMessage = false;
        }
    }
}
