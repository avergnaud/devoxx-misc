package streamapi;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import marvel.api.CharactersAPI;
import marvel.api.request.CharactersRequest;

public class Reduction {

	public static void main(String[] args) {
		CharactersAPI api = CharactersAPI
				.configureKeys("ac627b5a9da2dd5127e9583595c671f9", "c2110625d1f04ad9cf37d57cd2e9e4e2bddc6fc1")
				.configureProxyHost("px-internet")/*optional*/
				.configureProxyPort("80")/*optional*/
				.rootUlr("http://gateway.marvel.com/v1/public/characters")/*optional*/
				.limiteMarvel(10)/*optional*/
				.init();
			
			CharactersRequest firstRequest = api.requestBuilder()
					.limite(500)/*optional*/
					.modifiedSince(LocalDate.of(2014, Month.JANUARY, 1))/*optional*/
					.build();
			
			List<marvel.model.Character> persos = firstRequest.get();
			
			System.out.println("nombre de characters retournés " + persos.size());
			
			//https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
			
			List<String> liste = persos.stream()
					.map(marvel.model.Character::getName)
					.collect(Collectors.toList());
			System.out.println(liste);
			
			// Compute sum of stories of characters
		     int total = persos.stream()
		                          .collect(Collectors.summingInt(c -> c.getStories().getAvailable()));
		     System.out.println("total " + total);
		     
		  // Compute sum of stories by character
		     Map<marvel.model.Character, Integer> totalBychar
		         = persos.stream()
		                    .collect(Collectors.groupingBy(c -> c,
		                    							   Collectors.<marvel.model.Character>summingInt(c -> c.getStories().getAvailable())));
			System.out.println("totalBychar " + totalBychar);
			
	}

}
