package services;

public class PayPalService implements OnlinePaymentSerivce {
	
	public PayPalService() {
		
	}
	
	@Override
	public Double paymentFee(Double amount) {
		return (amount * 0.02) + amount ;
	}
	
	@Override
	public Double interest(Double amount, Integer month) {
		return ((amount * 0.01) * month) + amount;
	}
}
