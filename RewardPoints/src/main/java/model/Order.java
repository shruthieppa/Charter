package model;

import java.time.LocalDate;


public class Order {

  private long orderId;

  private long customerId;

  private LocalDate date;

  private double amount;

public long getOrderId() {
	return orderId;
}

public void setOrderId(long orderId) {
	this.orderId = orderId;
}

public long getCustomerId() {
	return customerId;
}

public void setCustomerId(long customerId) {
	this.customerId = customerId;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}
}

