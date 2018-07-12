package hello;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		List<Data> finalData = new ArrayList<Data>();
		Index firstPage = restTemplate.getForObject(
				"https://subscribe.bloombergindices.com/api/v1/public/index_members?page[size]=100&page[number]=1&filter[index_ticker]=LBUSTRUU&stats[total]=count", Index.class);
		finalData.addAll(firstPage.data);
		if (firstPage.meta.stats.total.count > 100)
		{
			int pages = (int) Math.ceil((double)firstPage.meta.stats.total.count/100);
			for (int i = 2; i < pages+1; i++)
			{
				Index newPage = new Index();
				newPage = restTemplate.getForObject(
						"https://subscribe.bloombergindices.com/api/v1/public/index_members?page[size]=100&page[number]="+i+"&filter[index_ticker]=LBUSTRUU&stats[total]=count", Index.class);
				finalData.addAll(newPage.data);
			}
		}
		
	
		return args -> {
			log.info(finalData.toString());
		};
	}
}