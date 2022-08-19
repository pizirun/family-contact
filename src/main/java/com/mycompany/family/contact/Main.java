/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.family.contact;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pi0314
 */
public class Main {

    /**
     * https://howtodoinjava.com/jaxb/jaxb-exmaple-marshalling-and-unmarshalling-list-or-set-of-objects/
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 构造几个联系人对象
        Contact c1 = new Contact("皮智刚", "男", 46, "Programmer");

        Contact c2 = new Contact("皮培努", "男", 20, "Student");

        Contact c3 = new Contact("聂佳盛", "男", 24, "Programmer");

        FamilyContact fc = new FamilyContact();
        // add to list
        fc.getFamilyContact().add(c1);
        fc.getFamilyContact().add(c2);
        fc.getFamilyContact().add(c3);

        // write out
        marshalingFamilyContact(fc);
        
        try {
            // read back
            unMarshalingFamilyContact();
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void marshalingFamilyContact(FamilyContact fc) {
        // 保存到 XML 文件
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FamilyContact.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Marshal the employees list in file
            jaxbMarshaller.marshal(fc, new File("family-contact.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void unMarshalingFamilyContact() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FamilyContact.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // We had written this file in marshalling example
        FamilyContact fc = (FamilyContact) jaxbUnmarshaller.unmarshal(new File("family-contact.xml"));

        for (Contact c : fc.getFamilyContact()) {
            System.out.println(c.getName());
        }
    }

}
