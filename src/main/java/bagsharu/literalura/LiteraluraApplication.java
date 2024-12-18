package bagsharu.literalura;

import bagsharu.literalura.main.Principal;
import bagsharu.literalura.repository.AutoresRepository;
import bagsharu.literalura.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivrosRepository repository;

	@Autowired
	private AutoresRepository autoresRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");

		Principal principal = new Principal(repository, autoresRepository);

		principal.IniciarMenu();
	}
}
