package shopping.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Product {

    private String productName;
    private Demand demand;
    private  Supply supply;
    private List<Competitor> competitorList = new ArrayList<>();


}
