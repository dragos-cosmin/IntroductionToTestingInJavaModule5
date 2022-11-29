package com.monotonic.testing.m5.spring_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.PrintStream;

public class SpringXmlSalesReportRunner {
    private static String fileLocation;

    public static void main(String[] args) {
        if (args.length<1){
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }

        fileLocation=args[0];

        ClassPathXmlApplicationContext xmlContext=new ClassPathXmlApplicationContext("com/monotonic/testing/m5/spring_xml/application-context.xml");
        SalesReport report=xmlContext.getBean(SalesReport.class);
        report.report();
    }
    public static PrintStream getOutput(){return System.out;}

    public static String getFileLocation(){return fileLocation;}
}
