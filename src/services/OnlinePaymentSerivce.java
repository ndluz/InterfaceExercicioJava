package services;

public interface OnlinePaymentSerivce {
	public Double paymentFee(Double amount);
	public Double interest(Double amount, Integer month);
}
