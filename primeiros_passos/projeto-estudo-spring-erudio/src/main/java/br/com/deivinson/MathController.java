package br.com.deivinson;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deivinson.exceptions.UnsupportedMathOperationException;


@RestController
@RequestMapping("/")
public class MathController {

	//private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
	
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			trhowsException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo")String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			trhowsException("Please set a numeric value");
		}
		
		if(convertToDouble(numberTwo) == 0) {
			trhowsException("Please set a value different from zero");
		}
		
		if(convertToDouble(numberTwo) < 0) {
			trhowsException("Please set a value greater than zero");
		}
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo")String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			trhowsException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo")String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			trhowsException("Please set a numeric value");
		}
		
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	// Raiz quadrada
	@GetMapping("/raiz/{numberOne}")
	public Double sqrt(@PathVariable(value = "numberOne") String numberOne
			) throws Exception{
		
		if(!isNumeric(numberOne)) {
			trhowsException("Please set a numeric value");
		}
		
		return Math.sqrt(convertToDouble(numberOne));
	}
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}	
	
	private void trhowsException(String message) {
		throw new UnsupportedMathOperationException(message);
	}
	
}
