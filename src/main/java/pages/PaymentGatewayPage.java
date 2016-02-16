package pages;

public class PaymentGatewayPage extends BasePage{

	protected String filePathPaymentGatewayPage = "./src/main/resources/objectRepo/PaymentGatewayPage.json",
			creditCardTypePaymentgatewayClassName = helper.parseJSONToString("creditCardTypePaymentgatewayClassName", filePathPaymentGatewayPage),
			amountToBePaidId = helper.parseJSONToString("amountToBePaidId", filePathPaymentGatewayPage);
	
	public void isValid() {
		// TODO Auto-generated method stub
		
	}

	public String getCreditCardText() {
		return helper.findElementsByClassName(creditCardTypePaymentgatewayClassName).get(0).getText();
	}
	
	public String getAmountToBePaid() {
		return helper.findElementById(amountToBePaidId).getText();
	}
	
}
