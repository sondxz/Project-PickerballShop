package vn.hoangson.pickerballshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PickerballApplication {

	public static void main(String[] args) {

		//container
		ApplicationContext hoangson = SpringApplication.run(PickerballApplication.class, args);
		for(String s: hoangson.getBeanDefinitionNames())
		{
			System.out.println(s);
		}
	}

}
