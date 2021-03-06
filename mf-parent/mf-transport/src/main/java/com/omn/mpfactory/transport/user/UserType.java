//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.30 at 01:56:24 PM BST 
//


package com.omn.mpfactory.transport.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nick" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PasswordHash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CompanyId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ConfirmationString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UserRoles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = {
    "nick",
    "email",
    "passwordHash",
    "companyId",
    "confirmationString",
    "userRoles"
})
@XmlRootElement(name = "UserType")
public class UserType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "Nick", required = true)
    protected String nick;
    @XmlElement(name = "Email", required = true)
    protected String email;
    @XmlElement(name = "PasswordHash", required = true)
    protected String passwordHash;
    @XmlElement(name = "CompanyId")
    protected long companyId;
    @XmlElement(name = "ConfirmationString", required = true)
    protected String confirmationString;
    @XmlElement(name = "UserRoles", required = true)
    protected List<String> userRoles;

    /**
     * Gets the value of the nick property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNick() {
        return nick;
    }

    /**
     * Sets the value of the nick property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNick(String value) {
        this.nick = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the passwordHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Sets the value of the passwordHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswordHash(String value) {
        this.passwordHash = value;
    }

    /**
     * Gets the value of the companyId property.
     * 
     */
    public long getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     */
    public void setCompanyId(long value) {
        this.companyId = value;
    }

    /**
     * Gets the value of the confirmationString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmationString() {
        return confirmationString;
    }

    /**
     * Sets the value of the confirmationString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmationString(String value) {
        this.confirmationString = value;
    }

    /**
     * Gets the value of the userRoles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userRoles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUserRoles() {
        if (userRoles == null) {
            userRoles = new ArrayList<String>();
        }
        return this.userRoles;
    }

}
