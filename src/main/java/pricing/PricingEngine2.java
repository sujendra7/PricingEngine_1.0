package pricing;

import Constants.PricingContstants;
import shopping.model.Competitor;
import shopping.model.Demand;
import shopping.model.Product;
import shopping.model.Supply;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PricingEngine2 {

    public static void main(String[] args) {

        PricingService pricingService = new PricingService();

        Product mp3 = new Product();
        mp3.setProductName(PricingContstants.MP3_PLAYER);
        mp3.setDemand(Demand.H);
        mp3.setSupply(Supply.H);

        Competitor company1 = new Competitor();
        company1.setCompetitorName("X");
        company1.setPrice(60.0);
        Competitor company2 = new Competitor();
        company2.setCompetitorName("Y");
        company2.setPrice(20.0);
        Competitor company3 = new Competitor();
        company3.setCompetitorName("Z");
        company3.setPrice(50.0);
        mp3.setCompetitorList(Arrays.asList(company1, company2, company3 ));

        Competitor company4 = new Competitor();
        company4.setCompetitorName("W");
        company4.setPrice(11.0);
        Competitor company5 = new Competitor();
        company5.setCompetitorName("X");
        company5.setPrice(12.0);
        Competitor company6 = new Competitor();
        company6.setCompetitorName("V");
        company6.setPrice(10.0);
        Competitor company7 = new Competitor();
        company7.setCompetitorName("Y");
        company7.setPrice(11.0);
        Competitor company8 = new Competitor();
        company8.setCompetitorName("Z");
        company8.setPrice(12.0);

        Product ssd1 = new Product();
        ssd1.setProductName(PricingContstants.SSD);
        ssd1.setDemand(Demand.L);
        ssd1.setSupply(Supply.L);

        ssd1.setCompetitorList(Arrays.asList(company4, company5, company6, company7, company8));

        List<Product> list = new ArrayList<>();
        list.add(mp3);
        list.add(ssd1);

        Map<String, Double> finalPrices = pricingService.getPricings(list);
        for (Map.Entry e : finalPrices.entrySet() ) {
            System.out.println(e.getKey() + " ***** " +e.getValue());
        }

    }
}
