package pricing;

import shopping.model.Competitor;
import shopping.model.Demand;
import shopping.model.Product;
import shopping.model.Supply;

import java.util.*;
import java.util.stream.Collectors;

public class PricingService {


    public Map<String, Double> getPricings(List<Product> list) {

        Map<String, Double> resultMap = new HashMap<>();
        for (Product product : list) {
            resultMap.put(product.getProductName(), calculatePrice(product));
        }

        return resultMap;
    }

    private Double calculatePrice(Product product) {

        Double avgPrice = 0.0;
        Double lowestPrice = 0.0;
        Double price = 0.0;
        List<Competitor> tempList = new ArrayList<>();

        Set<Competitor> competitorSet = product.getCompetitorList().stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Competitor::getPrice))));
        List<Competitor> productList = new ArrayList<>(competitorSet);

        avgPrice = calculateAvgPrice(productList);
        for (Competitor d : productList) {
            if (!(d.getPrice() > (avgPrice + (avgPrice / 2))) && !(d.getPrice() < (avgPrice / 2))) {
                tempList.add(d);
            }
        }

        tempList.sort(Comparator.comparing(Competitor::getPrice));
        if (!tempList.isEmpty()) {
            lowestPrice = tempList.get(0).getPrice();
        }

        if (product.getDemand() == Demand.H && product.getSupply() == Supply.H) {
            price = lowestPrice;
        } else if (product.getDemand() == Demand.L && product.getSupply() == Supply.H) {
            price = lowestPrice + (lowestPrice / 20);
        } else if (product.getDemand() == Demand.H && product.getSupply() == Supply.L) {
            price = lowestPrice + (lowestPrice / 20);
        } else if (product.getDemand() == Demand.L && product.getSupply() == Supply.L) {
            price = lowestPrice + (lowestPrice / 10);
        }
        return price;
    }

    private Double calculateAvgPrice(List<Competitor> productList) {
        Double avgPrice = 0.0;
        if (!productList.isEmpty()) {
            for (Competitor d : productList) {
                avgPrice += d.getPrice();
            }
            avgPrice = avgPrice / productList.size();
        }
        return avgPrice;
    }
}

