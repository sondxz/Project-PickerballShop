package vn.hoangson.pickerballshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class PickerballApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickerballApplication.class, args);
	}

}
