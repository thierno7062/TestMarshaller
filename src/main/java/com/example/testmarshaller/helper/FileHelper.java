package com.example.testmarshaller.helper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class FileHelper {

    public static void convertReportToXML(Object reportXML, String targetPath) throws JAXBException{

        int version = 1;
        String fileName = "Contract_JULY_2022.xml";

        File f = new File(targetPath, fileName);

        while (f.exists()) {
            version++;
            f = new File(targetPath, fileName);
        }

        JAXBContext context = JAXBContext.newInstance(reportXML.getClass());

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(reportXML, new File(targetPath, fileName));
    }
}
