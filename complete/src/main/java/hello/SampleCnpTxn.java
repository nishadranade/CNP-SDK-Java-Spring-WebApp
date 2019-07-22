package hello;

import com.cnp.sdk.*;
import com.cnp.sdk.generate.Sale;
import com.cnp.sdk.generate.*;
import com.cnp.sdk.generate.MethodOfPaymentTypeEnum;
public class SampleCnpTxn {
	public static void main(String[] args) {

		// Visa $10 Sale
		Sale sale = new Sale();
		sale.setReportGroup("Planets");
		sale.setOrderId("12344");
		sale.setAmount(1000L);
		sale.setOrderSource(OrderSourceType.ECOMMERCE);
		CardType card = new CardType();
		card.setType(MethodOfPaymentTypeEnum.VI);
		card.setNumber("4100000000000002");
		card.setExpDate("1210");
		sale.setCard(card);
		
		// Peform the transaction on the Vantiv eCommerce Platform
		SaleResponse response = new CnpOnline().sale(sale);

		// display result
		System.out.println("Message: " + response.getMessage());
		System.out.println("Vantiv eCommerce Transaction ID: " + response.getCnpTxnId());
	}
}