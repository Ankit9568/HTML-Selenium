//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.24 at 09:39:50 AM CEST 
//


package APIs.StbUnAssign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriberAPIType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriberAPIType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubscriberSTBUnassign" type="{}SubscriberSTBUnassignType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriberAPIType", propOrder = {
    "version",
    "subscriberSTBUnassign"
})
public class SubscriberAPIType {

    @XmlElement(required = true)
    protected String version;
    @XmlElement(name = "SubscriberSTBUnassign", required = true)
    protected SubscriberSTBUnassignType subscriberSTBUnassign;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the subscriberSTBUnassign property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberSTBUnassignType }
     *     
     */
    public SubscriberSTBUnassignType getSubscriberSTBUnassign() {
        return subscriberSTBUnassign;
    }

    /**
     * Sets the value of the subscriberSTBUnassign property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberSTBUnassignType }
     *     
     */
    public void setSubscriberSTBUnassign(SubscriberSTBUnassignType value) {
        this.subscriberSTBUnassign = value;
    }

}
