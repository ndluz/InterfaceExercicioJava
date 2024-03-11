package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;
import services.ContractService;
import services.PayPalService;

public class Program {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer contractNumber;
		String date;
		Double contractAmount;
		Integer installments;
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Número: ");
		contractNumber = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		date = sc.next();
		System.out.print("Valor do contrato: ");
		contractAmount = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		installments = sc.nextInt();
		
			Contract contract = new Contract(contractNumber, LocalDate.parse(date, formatDate), contractAmount);
			ContractService contractService = new ContractService(new PayPalService());
			contractService.processContract(contract, installments);
			for(int i = 0; i< contract.getInstallments().size(); i++) {
				System.out.println(contract.getInstallment(i));
			}
			
			sc.close();
	}
}
