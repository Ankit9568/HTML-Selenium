//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.24 at 11:03:06 AM CEST 
//


package APIs.packageUnassign;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the APIs.packageUnassign package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubscriberAPI_QNAME = new QName("", "SubscriberAPI");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: APIs.packageUnassign
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubscriberAPIType }
     * 
     */
    public SubscriberAPIType createSubscriberAPIType() {
        return new SubscriberAPIType();
    }

    /**
     * Create an instance of {@link SubscriberPackageType }
     * 
     */
    public SubscriberPackageType createSubscriberPackageType() {
        return new SubscriberPackageType();
    }

    /**
     * Create an instance of {@link SubscriberDataAttributesType }
     * 
     */
    public SubscriberDataAttributesType createSubscriberDataAttributesType() {
        return new SubscriberDataAttributesType();
    }

    /**
     * Create an instance of {@link SubscriberPackageUnassignType }
     * 
     */
    public SubscriberPackageUnassignType createSubscriberPackageUnassignType() {
        return new SubscriberPackageUnassignType();
    }

    /**
     * Create an instance of {@link PackageDataType }
     * 
     */
    public PackageDataType createPackageDataType() {
        return new PackageDataType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriberAPIType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SubscriberAPI")
    public JAXBElement<SubscriberAPIType> createSubscriberAPI(SubscriberAPIType value) {
        return new JAXBElement<SubscriberAPIType>(_SubscriberAPI_QNAME, SubscriberAPIType.class, null, value);
    }

}