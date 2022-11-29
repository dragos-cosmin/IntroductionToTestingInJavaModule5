package com.monotonic.testing.m5.guice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Component
public class SalesAnalysisService {
    private String fileLocation;
    private final SalesRepository repo;

    @Inject
    public SalesAnalysisService(SalesRepository repository) {
        this.repo =repository;
    }

    public Map<String,Integer>tallyProductSales(){
        try {
            return tallySalesBy(Sale::getProduct);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String,Integer>tallyStoreSales(){
        try {
            return tallySalesBy(Sale::getStore);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String,Integer>tallySalesBy(Function<Sale,String>classifier) throws FileNotFoundException {

        return repo.loadSales()
                .stream()
                .collect(groupingBy(classifier,
                        summingInt(Sale::getValue)));

    }


}
