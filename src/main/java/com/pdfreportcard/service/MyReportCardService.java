package com.pdfreportcard.service;

import com.pdfreportcard.model.Student;
import org.springframework.stereotype.Service;


public interface MyReportCardService
{
    public String generatePdf(Student studentRC, String fileName);

    public String genrateCharCert(Student charCertificate, String fileName);

    public String genrateBirthcer(Student birthCertificate, String fileName);

}
