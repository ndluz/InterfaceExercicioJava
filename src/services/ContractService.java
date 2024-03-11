package services;

import entities.Contract;
import entities.Installment;

public class ContractService {
	private OnlinePaymentSerivce paymentService;
	
	public ContractService(OnlinePaymentSerivce paymentSerivce) {
		this.paymentService = paymentSerivce;
	}
	
	public void processContract(Contract contract, Integer months) {
		Double amount;
		for (int i = 1; i<=months; i++) {
			amount = this.paymentService.paymentFee(contract.getTotalValue()/months);
			amount = this.paymentService.interest(amount, i);
			contract.registerInstallment(new Installment(contract.getDate().plusMonths(i),amount));
		}
	}
}
