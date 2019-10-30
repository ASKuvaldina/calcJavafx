package calc;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class JavaRestActivator {

    protected void putToDBJournal(String operation) {

        try {

            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost:8080/helloJavafx/rest/data/post").path(operation);
            ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}