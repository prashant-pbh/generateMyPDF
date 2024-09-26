package com.pdfreportcard.service.impl;

import com.pdfreportcard.model.Student;
import com.pdfreportcard.service.MyReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

@Service
public class MyReportCardImpl implements MyReportCardService
{

    @Autowired
    SpringTemplateEngine templateEngine;



    @Override
    public String generatePdf(Student studentRC, String fileName) {
//        try{
//            Thread.sleep(6000);
//        }
//        catch (Exception e){
//
//        }




        Context context = new Context();
        context.setVariable("rollNum",studentRC.getRollNum());
        context.setVariable("name",studentRC.getName());
//        context.setVariable("subjects",studentRC.getSubjects());
        context.setVariable("math",studentRC.getSubjects().get("math"));
        context.setVariable("physics",studentRC.getSubjects().get("physics"));
        context.setVariable("che",studentRC.getSubjects().get("che"));
        context.setVariable("english",studentRC.getSubjects().get("english"));

        String htmlFile =  templateEngine.process("ReportCard",context);

        ByteArrayOutputStream object = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlFile);
        renderer.layout();

        try {
            renderer.createPDF(object);

            try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\MyDownloadFile\\"+studentRC.getName()+fileName+"_marksheet.pdf")) {
                object.writeTo(fileOutputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PDF generated successfully";

    }



    @Override
    public String genrateCharCert(Student student, String fileName) {

//        try{
//            Thread.sleep(6000);
//        }
//        catch (Exception e){
//
//        }




        Context context = new Context();
        context.setVariable("rollNum",student.getRollNum());
        context.setVariable("name",student.getName());

        String htmlFileForChar =  templateEngine.process("CharacterCertificate",context);

        ByteArrayOutputStream object1 = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlFileForChar);
        renderer.layout();

        try {
            renderer.createPDF(object1);

            try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\MyDownloadFile\\"+student.getName()+fileName+"_charCert.pdf")) {
                object1.writeTo(fileOutputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PDF for character certificate successfully generated ";
    }



    @Override
    public String genrateBirthcer(Student birthCertificate, String fileName) {

//        try{
//            Thread.sleep(6000);
//        }
//        catch (Exception e){
//
//        }




        Context context = new Context();
        context.setVariable("name",birthCertificate.getName());
        context.setVariable("fatherName",birthCertificate.getFatherName());
        context.setVariable("motherName",birthCertificate.getMotherName());
        context.setVariable("birthDate",birthCertificate.getBirthDate());
        context.setVariable("birthPlace",birthCertificate.getBirthPlace());

        String htmlFileForChar =  templateEngine.process("BirthCertificate",context);

        ByteArrayOutputStream object2 = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlFileForChar);
        renderer.layout();

        try {
            renderer.createPDF(object2);

            try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\MyDownloadFile\\"+birthCertificate.getName()+fileName+"_birthCert.pdf")) {
                object2.writeTo(fileOutputStream);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PDF for birth successfully certificate generated";
    }
}
