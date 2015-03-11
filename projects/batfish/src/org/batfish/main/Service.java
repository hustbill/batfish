package org.batfish.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONArray;

@Path("/batfishservice")
public class Service {

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public JSONArray getInfo() {
      return new JSONArray(
            Arrays.asList(
                  "",
                  "Batfish service: enter ../application.wadl (relative to your URL) to see supported methods"));
   }

   @GET
   @Path("getstatus")
   @Produces(MediaType.APPLICATION_JSON)
   public JSONArray getStatus() {
      return new JSONArray(Arrays.asList("", "idle = " + Driver.getIdle()));
   }

   @GET
   @Path("run")
   @Produces(MediaType.APPLICATION_JSON)
   public JSONArray run(@Context UriInfo ui) {
      try {
         MultivaluedMap<String, String> queryParams = ui.getQueryParameters();

         List<String> argsList = new ArrayList<String>();

         for (MultivaluedMap.Entry<String, List<String>> entry : queryParams
               .entrySet()) {
            System.out.printf("key = %s value = %s\n", entry.getKey(),
                  entry.getValue());

            argsList.add("-" + entry.getKey());

            for (String value : entry.getValue()) {
               // don't add empty values; occurs for options that have no value
               if (!value.equals("")) {
                  argsList.add(value);
               }
            }
         }

         String[] args = argsList.toArray(new String[argsList.size()]);

         System.out.printf("Will run with args: %s\n", Arrays.toString(args));

         return new JSONArray(Driver.RunBatfish(args));
      }
      catch (Exception e) {
         return new JSONArray(Arrays.asList("failure", e.getMessage()));
      }
   }
}