package pricing;

import Constants.PricingContstants;
import shopping.model.Competitor;
import shopping.model.Demand;
import shopping.model.Product;
import shopping.model.Supply;

import java.util.*;

public class PricingEngine {

    public static void main(String[] args) {

        PricingService pricingService = new PricingService();

        Product flashDrive1 = new Product();
        flashDrive1.setProductName(PricingContstants.FLASH_DRIVE);
        flashDrive1.setDemand(Demand.H);
        flashDrive1.setSupply(Supply.H);

        Competitor company1 = new Competitor();
        company1.setCompetitorName("X");
        company1.setPrice(1.0);
        Competitor company2 = new Competitor();
        company2.setCompetitorName("Y");
        company2.setPrice(0.9);
        Competitor company3 = new Competitor();
        company3.setCompetitorName("Z");
        company3.setPrice(1.0);
        flashDrive1.setCompetitorList(Arrays.asList(company1, company2, company3 ));

        Competitor company4 = new Competitor();
        company4.setCompetitorName("X");
        company4.setPrice(10.0);
        Competitor company5 = new Competitor();
        company5.setCompetitorName("Y");
        company5.setPrice(12.5);

        Product ssd1 = new Product();
        ssd1.setProductName(PricingContstants.SSD);
        ssd1.setDemand(Demand.L);
        ssd1.setSupply(Supply.H);

        ssd1.setCompetitorList(Arrays.asList(company4, company5));

        List<Product> list = new ArrayList<>();
        list.add(flashDrive1);
        list.add(ssd1);

        Map<String, Double> finalPrices = pricingService.getPricings(list);
        for (Map.Entry e : finalPrices.entrySet() ) {
            System.out.println(e.getKey() + " ***** " +e.getValue());
        }
    }
}


