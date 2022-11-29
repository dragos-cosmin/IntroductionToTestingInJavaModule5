package com.monotonic.testing.m5.spring_xml;

public class SimpleReportRunner {
    public static void main(String[] args) {
        if (args.length<1){
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }

        CsvSalesRepository repo=new CsvSalesRepository(args[0]);

        final SalesAnalysisService analyser=new SalesAnalysisService(repo);
        SalesReport report=new SalesReport(System.out, analyser);
        report.report();
    }
}
