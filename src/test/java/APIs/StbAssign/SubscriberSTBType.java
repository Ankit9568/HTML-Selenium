//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.24 at 08:22:14 AM CEST 
//


package APIs.StbAssign;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subscriberSTBType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscriberSTBType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="equipmentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="macAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscriberSTBType", propOrder = {
    "equipmentId",
    "macAddress",
    "serialNumber"
})
public class SubscriberSTBType {

    protected int equipmentId;
    @XmlElement(required = true)
    protected String macAddress;
    protected int serialNumber;

    /**
     * Gets the value of the equipmentId property.
     * 
     */
    public int getEquipmentId() {
        return equipmentId;
    }

    /**
     * Sets the value of the equipmentId property.
     * 
     */
    public void setEquipmentId(int value) {
        this.equipmentId = value;
    }

    /**
     * Gets the value of the macAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Sets the value of the macAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress(String value) {
        this.macAddress = value;
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     */
    public void setSerialNumber(int value) {
        this.serialNumber = value;
    }

}
