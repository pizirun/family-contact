/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.family.contact;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author pi0314
 */
@XmlRootElement(name = "FamilyContact")
@XmlAccessorType (XmlAccessType.FIELD)
public class FamilyContact {
    List<Contact> familyContact = new ArrayList<>();

    public void setFamilyContact(List<Contact> familyContact) {
        this.familyContact = familyContact;
    }

    public List<Contact> getFamilyContact() {
        return familyContact;
    }

}
