package calc;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data")
public class JSONService {

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDataInJSON(String res) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.addHistoryDB(res);
        String result = "Operation post: " + res;

        return Response.status(201).entity(result).build();
    }
}