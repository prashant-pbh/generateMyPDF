package com.pdfreportcard.controller;


import com.pdfreportcard.model.*;
import com.pdfreportcard.service.MyReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/home")
public class MyReportCardController
{
    @Autowired
    MyReportCardService myReportCardPdf;


//    @RequestMapping("/getData/{name}/{students}")
//    public String getMyRepo(@PathVariable("name") String name, @PathVariable("students") List<StudentRC> students)
//    {
//        return myReportCardPdf.generatePdf(name,students);
//    }



    @PostMapping("/setData/{userName}/{password}")
    public String setMyrepo(@RequestBody InputRequest inputRequest, @PathVariable("userName") String userName, @PathVariable("password") int password)
    {
        System.out.println("userName=" + inputRequest.getUserName() + "" + "password=" + inputRequest.getPassword());
        if(!userName.equalsIgnoreCase("Prashant") || password != 12345)
        {
            return "Authentication Failed";
        }
        else {
            return myReportCardPdf.generatePdf(inputRequest.getStudent(),"abcd");
        }
    }

//    toDo:


    @PostMapping("/setDataHeader")
    public String setMyRepoByHeader(@RequestBody InputRequest inputRequest, @RequestHeader Map<String, String> header)
    {
        if(Integer.parseInt(header.get("password")) != 12345 || !header.get("username").equalsIgnoreCase("Prashant"))
        {
            return "Authentication Failed";
        }
        else {
            return myReportCardPdf.generatePdf(inputRequest.getStudent(),"abcd");
        }
    }


    @PostMapping("/createDocument/{userName}/{password}")
    public String createDocument(@RequestBody InputRequest inputRequest, @PathVariable("userName") String userName, @PathVariable("password") int password)
    {
//        Map<String,Integer> sbjts = new HashMap<>();
//        sbjts.put("Math",23);
//        sbjts.put("Science",34);
//        sbjts.put("History",12);
//        Student std = new Student(23,"raj","Ashish","Rinki","26-nov","Allahabad",sbjts);

        if (!userName.equalsIgnoreCase("Prashant") || password != 12345)
        {
            return "Authentication failed";
        }
        else {

//            myReportCardPdf.generatePdf(inputRequest.getStudent(),"1");
//            myReportCardPdf.genrateCharCert(inputRequest.getStudent(),"2");
//            myReportCardPdf.genrateBirthcer(inputRequest.getStudent(),"3");

            Thread thread1 = new Thread(()->myReportCardPdf.generatePdf(inputRequest.getStudent(),"1"));
            Thread thread2 = new Thread(()-> myReportCardPdf.genrateCharCert(inputRequest.getStudent(),"2"));
            Thread thread3 = new Thread(()->myReportCardPdf.genrateBirthcer(inputRequest.getStudent(),"3"));

            thread1.start();
            thread2.start();
            thread3.start();






            return "PDF generated successfully!";
        }
    }




}
