package ua.spring.app.entity;

import java.sql.Date;
import java.util.Objects;

public class CustomerOrder {

    private int customerOrderId;
    private int customerId;
    private Date orderTime;
    private double price;
    private double discount;
    private double finalPrice;

    public CustomerOrder() {
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" + "customerOrderId=" + customerOrderId
                + ", customerId=" + customerId
                + ", orderTime=" + orderTime
                + ", price=" + price + ", discount=" + discount
                + ", finalPrice=" + finalPrice + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((o == null) || (getClass() != o.getClass())) {
            return false;
        } else {
            CustomerOrder that = (CustomerOrder) o;
            return customerOrderId == that.customerOrderId
                    && customerId == that.customerId
                    && Double.compare(that.price, price) == 0
                    && Double.compare(that.discount, discount) == 0
                    && Double.compare(that.finalPrice, finalPrice) == 0
                    && Objects.equals(orderTime, that.orderTime);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customerOrderId, customerId, orderTime, price,
                discount, finalPrice);
        return (27 + result * 3) / 4;
    }
}
