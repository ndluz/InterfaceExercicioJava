package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private Integer number;
	private LocalDate date;
	private Double totalValue;
	private List<Installment> installments = new ArrayList<>();
	
	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	public void registerInstallment(Installment installment) {
		this.installments.add(installment);
	}
	
	public List<Installment> getInstallments() {
		return this.installments;
	}
	
	public String getInstallment(int index) {
		Installment installment = this.installments.get(index);
		return installment.getDueDate() + " " + installment.getAmount();
	}

	public Integer getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public Double getTotalValue() {
		return totalValue;
	}
}
