package br.ufop.ntifront.ntiFront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.TimeZone;

@EntityScan( basePackageClasses = {NtiFrontApplication.class } )
@SpringBootApplication
public class NtiFrontApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		SpringApplication.run(NtiFrontApplication.class, args);
	}
}
