package FuncionMain;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomHandler extends DefaultHandler {
	boolean bFemales = false;
    boolean bMales= false;
    
	int Total = 0;
	int S1 = 0;
	int S2 = 0;
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("(starts element:" + qName + ")");
        if (qName.equalsIgnoreCase("country")) {
            String id = attributes.getValue("coid");
            System.out.println("coid: " + id);
        }
        if (qName.equalsIgnoreCase("Females")) {
            bFemales = true;
        }
        if (qName.equalsIgnoreCase("Males")) {
            bMales = true;
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("ends element:" + qName);
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
    	
    	if (bFemales) {
    		S1 = Integer.parseInt(new String(ch, start, length));
            System.out.println("Females Population: " + new String(ch, start, length));
            bFemales = false;
        }
        if (bMales) {
        	S2 = Integer.parseInt(new String(ch, start, length));
            System.out.println("Males Population: " + new String(ch, start, length));
            
            //En el ultimo 'if', realizar los calculos totales de cada registro
            Total = S1 + S2;
            System.out.println("Total Population: " + Total);
            
            System.out.println("");
            bMales = false;
        }
        
    }
    
}
