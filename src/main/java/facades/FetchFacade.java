package facades;

import DTOs.SpeciesDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import utils.HttpUtils;

public class FetchFacade {

    class Default implements Callable<String> {

        String url;

        Default(String url) {
            this.url = url;
        }

        @Override
        public String call() throws Exception {
            String raw = HttpUtils.fetchData(url);
            return raw;
        }
    }

    public List<String> fetchParallel() throws InterruptedException, ExecutionException {
        String[] hostList = {"https://api.chucknorris.io/jokes/random", "https://icanhazdadjoke.com",
            "https://swapi.dev/api/planets/schema", "https://swapi.dev/api/vehicles/schema", "https://swapi.dev/api/species/schema"};
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> futures = new ArrayList<>();
        List<String> retList = new ArrayList();

        for (String url : hostList) {
            Callable<String> urlTask = new Default(url);
            Future future = executor.submit(urlTask);
            futures.add(future);
        }

        for (Future<String> fut : futures) {
            retList.add(fut.get());
        }
       
        return retList;
    }
    
    public static SpeciesDTO fetchSpecies() throws IOException{
        String person=HttpUtils.fetchData("https://swapi.dev/api/species/schema");
        Gson g=new Gson();
        System.out.println(person);
        
        SpeciesDTO SpeciesDTO=g.fromJson(person, SpeciesDTO.class);
        return SpeciesDTO;
    }
    public static void main(String[] args) throws IOException {
        FetchFacade f = new FetchFacade();
        System.out.println(f.fetchSpecies().toString());
    }
}
