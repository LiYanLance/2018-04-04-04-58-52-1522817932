package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {

    private BigDecimal totalPrice;

    public BigDecimal calculate(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts, BigDecimal tax){
        calculateTotal(orderLineItemList);
        subtractDiscounts(discounts);
        calculateGrandTotal(tax);
        return totalPrice;
    }

    private void calculateTotal(List<OrderLineItem> orderLineItemList){
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

    private void calculateGrandTotal(BigDecimal tax){
        // calculate tax
        tax = totalPrice.multiply(tax);
        // calculate GrandTotal
        totalPrice = totalPrice.add(tax);
    }
}
