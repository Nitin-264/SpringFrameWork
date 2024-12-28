package in.pwskills.nitin.calculator;

public class CalculatorApp {

	static {
		System.out.println("Calculatorapp.class file loading ..........");
	}
	public CalculatorApp() {
		// TODO Auto-generated constructor stub
		System.out.println("Calculator app created..........");
	}
	public int add(int a, int b) {
		return a+b;
	}
	
	public boolean isEven(int a) {
		return a % 2 == 0;
	}
}
