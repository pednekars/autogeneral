package fr.autogeneral.rest.api;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.autogeneral.rest.core.model.BalanceTestResult;


@RestController
@RequestMapping("/tasks")
public class TasksController {
	
	/**
     * 
     */
	@CrossOrigin
    @RequestMapping(value = "/validateBrackets", method = RequestMethod.GET)
    public ResponseEntity<BalanceTestResult> validateBrackets(@RequestParam String input) {
		System.out.println("The validateBrackets input is "+input);
		boolean result = true;
		if(input.length()>50) result= false;
    	  if ((input.length() % 2) == 1) result =false;
    	  else {
    	    Stack<Character> s = new Stack<>();
    	    for (char bracket : input.toCharArray())
    	      switch (bracket) {
    	        case '{': s.push('}'); break;
    	        case '(': s.push(')'); break;
    	        case '[': s.push(']'); break;
    	        default :
    	          if (s.isEmpty() || bracket != s.peek()) { result= false;}
    	          s.pop();
    	      }
    	    result=s.isEmpty();
    	    
    	  }
    	  return new ResponseEntity<>(new BalanceTestResult(input,result),HttpStatus.OK);
    }

}
