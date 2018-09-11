package com.welyab.tutorials.restful.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.welyab.tutorials.restful.Customer;
import com.welyab.tutorials.restful.service.CustomerService;

@Path("customers")
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET
    @Path("{customerCode}")
    public Customer get(@PathParam("customerCode") String customerCode) {
	return customerService.get(customerCode);
    }

    @GET
    @Produces({
	    MediaType.APPLICATION_JSON,
	    MediaType.APPLICATION_XML
    })
    public List<Customer> listCustomers() {
	return customerService.getCustomers();
    }

    @POST
    @Consumes({
	    MediaType.APPLICATION_JSON,
	    MediaType.APPLICATION_XML
    })
    public Response add(Customer customer, @Context UriInfo uriInfo) {
	customerService.addCostumer(customer);
	return Response.created(
		uriInfo.getAbsolutePathBuilder()
			.path(customer.getCode())
			.build()
	).build();
    }

    @PUT
    @Consumes({
	    MediaType.APPLICATION_JSON,
	    MediaType.APPLICATION_XML
    })
    public Response update(Customer customer) {
	customerService.update(customer);
	return Response.noContent().build();
    }

    @DELETE
    @Path("{customerCode}")
    public Response delete(@PathParam("customerCode") String customerCode) {
	customerService.removeCustomer(customerCode);
	return Response.noContent().build();
    }
}
