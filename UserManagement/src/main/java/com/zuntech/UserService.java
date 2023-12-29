package com.zuntech;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.apache.commons.json.JSONArray;
//import org.apache.commons.json.JSONException;
//import org.apache.commons.json.JSONObject;

@Path("/UserService")

public class UserService {

	RealDao dao = RealDao.getRealDao();

	/*
	 * @GET
	 * 
	 * @Path("/users")
	 * 
	 * @Produces( MediaType.APPLICATION_XML) public List<User> getUsers() { return
	 * dao.getUsers();
	 * 
	 * }
	 * 
	 * @GET
	 * 
	 * @Path("/users/{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_XML) public Response getUser(@PathParam("id")
	 * int id) { User user = dao.getUser(id); if (user == null) { return
	 * Response.status(Response.Status.NOT_FOUND).entity("Record with ID "
	 * +id+" is not available").build(); } return Response.ok(user).build(); }
	 * 
	 * @POST
	 * 
	 * @Path("create")
	 * 
	 * @Consumes(MediaType.APPLICATION_XML)
	 * 
	 * @Produces( MediaType.APPLICATION_XML ) public Response createUser(User u1) {
	 * int ID = u1.getId(); User existingUser = dao.getUser(ID); if (existingUser !=
	 * null) { return Response.status(Response.Status.BAD_REQUEST).entity("ID "
	 * +ID+" already exists").build(); } dao.create(u1); return
	 * Response.ok(u1).build(); }
	 * 
	 * @DELETE
	 * 
	 * @Path("/users/{id}")
	 * 
	 * @Produces(MediaType.APPLICATION_XML) public Response
	 * removeUser(@PathParam("id") int id) { User user = dao.getUser(id); if (user
	 * == null) { return
	 * Response.status(Response.Status.NOT_FOUND).entity("Record with ID "
	 * +id+" not found to delete").build(); } dao.removeUser(id); return
	 * Response.ok(user).build(); }
	 * 
	 * @PUT
	 * 
	 * @Path("update")
	 * 
	 * @Consumes(MediaType.APPLICATION_XML)
	 * 
	 * @Produces(MediaType.APPLICATION_XML) public Response updateUser(User u1) {
	 * int id = u1.getId(); User existingUser = dao.getUser(id); if (existingUser ==
	 * null) { return
	 * Response.status(Response.Status.NOT_FOUND).entity("Record with ID "
	 * +id+" not found to update").build(); } dao.updateUser(u1); return
	 * Response.ok(u1).build(); }
	 */
// ----------------------------------------------------------------
	
	
//  For JSON data
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsersJson() {
		return dao.getUsers();

	}
	
	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserJson(@PathParam("id") int id) {
	    User user = dao.getUser(id);
	    
	    if (user == null) {
	        throw new CustomException("E404", "ID "+id+" not found");
	    }
//	    else if (user != id) {
//	    	 throw new CustomException("E404", "ID "+id+" not found");
//		}
	    return Response.ok(user).build();
	}
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON )
	public Response createUserJson(User u1) {
	    int ID = u1.getId();
	    User existingUser = dao.getUser(ID);
	    if (existingUser != null) {
	    	throw new CustomException("E400", "ID "+ID+" already exists");
//	        return Response.status(Response.Status.BAD_REQUEST).entity("ID "+ID+" already exists").build();
	    }
	    dao.create(u1);
	    return Response.ok(u1).build();
	}

	@DELETE
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeUserJson(@PathParam("id") int id) {
	    User user = dao.getUser(id);
	    if (user == null) {
	    	throw new CustomException("E404", "Record with ID "+id+" not found to delete");
//	        return Response.status(Response.Status.NOT_FOUND).entity("Record with ID "+id+" not found to delete").build();
	    }
	    dao.removeUser(id);
	    return Response.ok(user).build();
	}

	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON )
	public Response updateUserJson(User u1) {
	    int id = u1.getId();
	    User existingUser = dao.getUser(id);
	    if (existingUser == null) {
	    	throw new CustomException("E400", "Record with ID "+id+" not found to update");
//	        return Response.status(Response.Status.NOT_FOUND).entity("Record with ID "+id+" not found to update").build();
	    }
	    dao.updateUser(u1);
	    return Response.ok(u1).build();
	}

	
	
//   @Path("/create")
//   @GET
//   @Produces(MediaType.APPLICATION_JSON)
//   public Response search(User user) throws JSONException {
//	  
//	   JSONObject jo = new JSONObject();
//       jo.put("Id", 1);
//       jo.put("Name", "zuntech");
//       jo.put("Profession", "developer");  
//      // JSONObject json = null// search by API
//       return Response.status(Response.Status.OK)
//                 .entity(jo.toString()).build();
//
//   }
}