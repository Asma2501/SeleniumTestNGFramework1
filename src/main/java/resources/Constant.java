package resources;

public class Constant {
	//constants for verifyregistrationTestcases
	
	//ValiddataTestcases
	public static String firstname="test";
	public static String lastname="test";
	public static String phone="7676787878";
	public static String password="secure";
	public static String confirmpassword="secure";
	public static String expectedRegisteration="Your Account Has Been Created!";
	
	//InvaliddataTestCases
	public static String invalidPassword="djkfjkfknfkld";
	public static String fnExpected = "First Name must be between 1 and 32 characters!";
	public static String lnExpected = "Last Name must be between 1 and 32 characters!";
	public static String InvalidEmailExpected = "E-Mail Address does not appear to be valid!";
	public static String TlphnExpected = "Telephone must be between 3 and 32 characters!";
	public static String invalidpwdExpected = "Password must be between 4 and 20 characters!";
	
	//constants for loginTestcases
	
	//Invaliddata
	public static String ExpctedRslt="Warning: No match for E-Mail Address and/or Password.";
	//Validdata
	public static String expected ="My Account";
}


