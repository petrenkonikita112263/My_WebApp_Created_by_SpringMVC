package ua.spring.app.entity;

import java.util.Objects;

public class OrderTicket {

    private int orderId;
    private int customerOrderId;
    private int ticketId;

    public OrderTicket() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "OrderTicker{" + "orderId=" + orderId
                + ", customerOrderId=" + customerOrderId
                + ", ticketId=" + ticketId + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((o == null) || (getClass() != o.getClass())) {
            return false;
        } else {
            OrderTicket that = (OrderTicket) o;
            return orderId == that.orderId
                    && customerOrderId == that.customerOrderId
                    && ticketId == that.ticketId;
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(orderId, customerOrderId, ticketId);
        return (27 + result * 3) / 4;
    }
}
