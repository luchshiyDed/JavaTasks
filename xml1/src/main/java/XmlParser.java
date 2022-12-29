import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlParser {
    private XMLEventReader xmlEventReader;
    private XMLInputFactory xmlInputFactory;

    public XmlParser() {
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    public List<Person> parseXMLfile(String fileName) {

        List<Person> people = new ArrayList<>();
        Person person = null;

        try {
            xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "person" -> {
                            person = new Person();
                            Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                            if (idAttr != null)
                                person.setId(idAttr.getValue().trim());
                            Attribute fullnameAttr = startElement.getAttributeByName(new QName("name"));
                            if (fullnameAttr != null)
                                person.setFullName(fullnameAttr.getValue().trim());
                        }
                        case "id" -> person.setId(getValue(startElement));

                        case "first", "firstname" -> person.setName(getValue(startElement));

                        case "surname", "family", "family-name" -> person.setLstName(getValue(startElement));

                        case "gender" -> person.setGndr(getGndr(startElement));

                        case "brother" -> person.addSibling(getValue(startElement), "male");

                        case "sister" -> person.addSibling(getValue(startElement), "female");

                        case "siblings" -> {
                            String[] siblingsValue = null;
                            Iterator<Attribute> iterator = startElement.getAttributes();
                            if (iterator.hasNext()) {
                                Attribute attribute = iterator.next();
                                siblingsValue= attribute.getValue().trim().split(" ");
                                for (String id : siblingsValue)
                                    person.addSibling(id);
                            }
                        }


                        case "parent" -> {
                            String id = getValue(startElement);
                            if (id != null)
                                person.addParent(id);
                        }
                        case "mother" -> person.addParent(getValue(startElement), "female");

                        case "father" -> person.addParent(getValue(startElement), "male");

                        case "children", "fullname" -> {
                        }

                        case "spouce" -> {
                            String fullname = getValue(startElement);
                            if (fullname != null) {
                                person.setSpouse(fullname);
                            }
                        }
                        case "son" -> person.addChild(getValue(startElement), "male");

                        case "daughter" -> person.addChild(getValue(startElement), "female");

                        case "child" -> person.addChild(getValue(startElement));

                        case "wife" -> person.setWife(getValue(startElement));

                        case "husband" -> person.setHusband(getValue(startElement));

                        case "children-number" -> person.setChildCnt(Integer.parseInt(getValue(startElement)));

                        case "siblings-number" -> person.setSiblCnt(Integer.parseInt(getValue(startElement)));

                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement end = xmlEvent.asEndElement();
                    if (end.getName().getLocalPart().equals("person")) {
                        people.add(person);
                        people.addAll(person.getChilds());
                        people.addAll(person.getParents());
                        people.addAll(person.getSibs());
                        if (person.getSpouse() != null)
                            people.add(person.getSpouse());
                    }
                }
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return people;
    }


    private String unifyGendr(String gndr) throws Exception {
        if (gndr.equals("M") || gndr.equals("male"))
            return "male";
        if (gndr.equals("F") || gndr.equals("female"))
            return "female";
        throw new Exception("wrong gender");
    }

    private String getGndr(final StartElement start) throws Exception {
        Iterator<Attribute> iterator = start.getAttributes();
        if (iterator.hasNext()) {
            Attribute attribute = iterator.next();
            return unifyGendr(attribute.getValue().trim());
        } else {
            XMLEvent charsEvent = xmlEventReader.nextEvent();
            xmlEventReader.nextEvent();
            String gender = charsEvent.asCharacters().getData().trim();
            return unifyGendr(gender);
        }
    }


    private String getValue(final StartElement start) throws XMLStreamException {
        String value;
        Iterator<Attribute> iterator = start.getAttributes();
        if (iterator.hasNext()) {
            Attribute attribute = iterator.next();
            value = attribute.getValue().trim();
        } else {
            XMLEvent charsEvent = xmlEventReader.nextEvent();
            if (charsEvent.isEndElement())
                return null;
            xmlEventReader.nextEvent();
            value = charsEvent.asCharacters().getData().trim();
        }
        if (value.equals("NONE") || value.equals("UNKNOWN"))
            return null;
        else
            return value;
    }

}
