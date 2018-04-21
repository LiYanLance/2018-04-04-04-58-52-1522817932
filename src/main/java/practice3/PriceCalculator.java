package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCalculator {

    private BigDecimal totalPrice;

    public BigDecimal calculate(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts, BigDecimal tax){
        calculateTotalPrice(orderLineItemList);
        subtractDiscounts(discounts);
        addTax(tax);
        return totalPrice;
    }

    private void calculateTotalPrice(List<OrderLineItem> orderLineItemList){
        totalPrice = new BigDecimal(0);
        // Total up line items
        for (OrderLineItem lineItem : orderLineItemList) {
            totalPrice = totalPrice.add(lineItem.getPrice());
        }
    }

    private void subtractDiscounts(List<BigDecimal> discounts) {
        // Subtract discounts
        for (BigDecimal discount : discounts) {
            totalPrice = totalPrice.subtract(discount);
        }
    }

    private void addTax(BigDecimal tax){
        totalPrice.add(BigDecimal.valueOf(1).add(tax));
    }
}
