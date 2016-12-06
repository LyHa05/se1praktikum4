package se1app.applicationcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.filialeKomponente.Filiale;
import se1app.applicationcore.filialeKomponente.FilialeRepository;
import se1app.applicationcore.kontoKomponente.BuchungsPosition;
import se1app.applicationcore.kontoKomponente.Konto;
import se1app.applicationcore.kontoKomponente.KontoKomponenteInterface;

import java.util.Arrays;

@SpringBootApplication
public class Application {
	
    @Autowired
    private KontoKomponenteInterface kontoKomponenteInterface;

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, FilialeRepository filialeRepository) {
        return args -> {
            Customer mickey = new Customer("Mueller");
            Customer minnie = new Customer("Meier");
            Customer pluto = new Customer("Schulze");
            customerRepository.save(Arrays.asList(mickey, minnie, pluto));
            Filiale filiale = new Filiale();
            filialeRepository.save(filiale);
        	Konto k1 = new Konto("000123");
        	kontoKomponenteInterface.kontoSpeichern(k1);
        	BuchungsPosition bp1 = new BuchungsPosition(100);
        	kontoKomponenteInterface.newBuchungsPosition(k1, bp1);
    		Konto k2 = new Konto("000124");
    		kontoKomponenteInterface.kontoSpeichern(k2);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
