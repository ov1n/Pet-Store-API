package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/petstype")
@Produces("application/json")
public class PetsTypeResource {
    List<PetsType> petsTypes = new ArrayList<>();

    public PetsTypeResource() {
        PetsType t1 = new PetsType();
        t1.setPetTypeId(1);
        t1.setPetType("Cat");

        PetsType t2 = new PetsType();
        t2.setPetTypeId(2);
        t2.setPetType("Dog");

        PetsType t3 = new PetsType();
        t3.setPetTypeId(2);
        t3.setPetType("Bird");

        PetsType t4 = new PetsType();
        t4.setPetTypeId(2);
        t4.setPetType("Hamster");

        petsTypes.add(t1);
        petsTypes.add(t2);
        petsTypes.add(t3);
        petsTypes.add(t4);
    }

    //	Add particular pet type
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pets Type Added successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetsType"))) })

    @POST
    public Response addPetType(@RequestBody (required = true) PetsType type) {
        petsTypes.add(type);

        return Response.ok(type).build();
    }

    //	View all available pet types
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "All pet types", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetsType"))) })

    @GET
    public Response getAllPetsTypes() {
        return Response.ok(petsTypes).build();
    }

    //	View one pet type by id
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet Type for id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "No Pet Type found for the id.") })

    @GET
    @Path("{petsTypeId}")
    public Response getPetsType(@PathParam("petsTypeId") int petsTypeId) {
        if (petsTypeId < 0) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            for (PetsType type : petsTypes) {
                if (type.getPetsTypeId() == petsTypeId) {

                    type.setPetTypeId(type.getPetsTypeId());
                    type.setPetType(type.getPetType());

                    return Response.ok(type).build();
                }
            }

            return Response.status(Status.NOT_FOUND).build();
        }
    }

    //	Update an existing pet type
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet Type Updated successfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetType"))),
            @APIResponse(responseCode = "404", description = "No Pet Type found for the id.") })

    @PUT
    @Path("{petsTypeId}")
    public Response updatePetsType(@PathParam("petsTypeId") int petsTypeId,  @RequestBody PetsType petsTypeUpdate) {
        if (petsTypeId < 0) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            for (PetsType type : petsTypes) {
                if (type.getPetsTypeId() == petsTypeId) {

                    petsTypes.remove(type);
                    petsTypes.add(petsTypeUpdate);

                    return Response.ok(type).build();
                }
            }

            return Response.status(Status.NOT_FOUND).build();
        }
    }

    //	Delete a particular pet type
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Pet Type Deleted ", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "PetsType"))),
            @APIResponse(responseCode = "404", description = "No Pet Type found for given id.") })

    @DELETE
    @Path("{petsTypeId}")
    public Response deletePettype(@PathParam("petsTypeId") int petsTypeId) {
        if (petsTypeId < 0) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            for (PetsType type : petsTypes) {
                if (type.getPetsTypeId() == petsTypeId) {

                    petsTypes.remove(type);

                    return Response.noContent().build();
                }
            }

            return Response.status(Status.NOT_FOUND).build();
        }
    }
}
