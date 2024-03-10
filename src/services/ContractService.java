package services;

import java.util.Date;	

import entities.Contract;
import entities.Installment;

public class ContractService {
	private OnlinePaymentSerivce paymentService;
	
	public ContractService(OnlinePaymentSerivce paymentSerivce) {
		this.paymentService = paymentSerivce;
	}
	
	public void processContract(Contract contract, Integer months) {
		Double amount;
		Date date = new Date();
		for (int i = 1; i<=months; i++) {
			date.setMonth(date.getMonth() + i);
			amount = this.paymentService.paymentFee(contract.getTotalValue());
			amount = this.paymentService.interest(amount, i);
			contract.registerInstallment(new Installment( date,amount));
		}
	}
}
