package com.monotonic.testing.m5.before_refactor;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CsvSalesRepository implements SalesRepository{
    private final String fileLocation;
    private PrintStream error;
    private List<Sale>sales;

    public CsvSalesRepository(String fileLocation) {
        this.fileLocation = fileLocation;
        error=System.out;
    }

    public void setError(PrintStream error) {
        this.error = error;
    }

    private int parseInt(String value){return Integer.parseInt(value.trim());}

    @Override
    public List<Sale> loadSales(){
        if (sales==null){
            sales=new ArrayList<>();
            try (CSVReader reader=new CSVReader(new FileReader(fileLocation))){
                String[]nextLine;
                while ((nextLine=reader.readNext())!=null){

                    String product=nextLine[0].trim();
                    String store=nextLine[1].trim();
                    int number=parseInt(nextLine[2]);
                    int pricePerItem=parseInt(nextLine[3]);
                    sales.add(new Sale(product,store,number,pricePerItem));
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
        }

        return sales;
    }
}
