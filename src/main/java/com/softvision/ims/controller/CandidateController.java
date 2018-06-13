package com.softvision.ims.controller;

import com.softvision.common.ServiceConstants;
import com.softvision.ims.entity.Candidate;
import com.softvision.ims.service.CandidateService;
import lombok.Synchronized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Path(ServiceConstants.BACK_SLASH + ServiceConstants.CANDIDATE_SERVICE)
public class CandidateController {

    @Inject
    private CandidateService candidateService;
/*
    @Autowired
    private Pageable pageable;*/

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidateController.class);

    @POST
    @Path(ServiceConstants.BACK_SLASH + ServiceConstants.CANDIDATE + ServiceConstants.BACK_SLASH
            + ServiceConstants.ADD)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCandidate(@Suspended AsyncResponse asyncResponse, Candidate candidate){
        LOGGER.info("In addCandidate() :: Saving the candidate to DB");
        CompletableFuture.supplyAsync(() -> candidateService.addCandidate(candidate))
                .thenApply(candidate1 -> asyncResponse.resume(candidate));
    }

    @POST
    @Path(ServiceConstants.BACK_SLASH + ServiceConstants.CANDIDATES + ServiceConstants.BACK_SLASH
            + ServiceConstants.ADD)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addAllCandidates(@Suspended AsyncResponse asyncResponse, List<Candidate> candidates){
        LOGGER.info("In addAllCandidates() :: Saving all the candidates to DB");
        CompletableFuture<List<Candidate>> future = CompletableFuture.supplyAsync(() -> candidateService.saveAllCandidates(candidates));
        asyncResponse.resume(future.join());
    }

    @GET
    @Path(ServiceConstants.BACK_SLASH + ServiceConstants.CANDIDATE + ServiceConstants.BACK_SLASH
            + ServiceConstants.OPENING_CURLY_BRACKET + ServiceConstants.ID
            + ServiceConstants.CLOSING_CURLY_BRACKET)
    @Produces(MediaType.APPLICATION_JSON)
    public void findCandidateById(@Suspended AsyncResponse asyncResponse, @PathParam("id") String id){
        LOGGER.info("In findCandidateById() :: Fetching candidate details for {} ", id);
        CompletableFuture<Candidate> future = CompletableFuture.supplyAsync(() -> candidateService.findCandidateById(id));
        asyncResponse.resume(future.join());
    }

    @DELETE
    @Path(ServiceConstants.BACK_SLASH + ServiceConstants.CANDIDATE + ServiceConstants.BACK_SLASH
            + ServiceConstants.DELETE + ServiceConstants.BACK_SLASH + ServiceConstants.OPENING_CURLY_BRACKET
            + ServiceConstants.ID + ServiceConstants.CLOSING_CURLY_BRACKET)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCandidateById(@Suspended AsyncResponse asyncResponse, @PathParam("id") String id){
        LOGGER.info("In deleteCandidateById() :: Deleting candidate {} ", id);
        CompletableFuture future = CompletableFuture.runAsync(() -> candidateService.deleteCandidateById(id));
        asyncResponse.resume(future.join());
    }

    @PUT
    @Path(ServiceConstants.BACK_SLASH + ServiceConstants.CANDIDATE + ServiceConstants.BACK_SLASH
            + ServiceConstants.UPDATE + ServiceConstants.BACK_SLASH + ServiceConstants.OPENING_CURLY_BRACKET
            + ServiceConstants.ID
            + ServiceConstants.CLOSING_CURLY_BRACKET)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateCandidate(@Suspended AsyncResponse asyncResponse, Candidate candidate, @PathParam("id") String id){
        LOGGER.info("In updateCandidate() :: Updating candidate {} ", id);
        CompletableFuture.supplyAsync(() -> candidateService.updateCandidate(candidate, id))
                .thenApply(candidate1 -> asyncResponse.resume(candidate));
    }

    @GET
    @Path(ServiceConstants.BACK_SLASH + ServiceConstants.CANDIDATES)
    @Produces(MediaType.APPLICATION_JSON)
    public void getAllCandidateDetails(final @Suspended AsyncResponse asyncResponse,
                                       @QueryParam("page") int page,
                                       @QueryParam("size") int size,
                                       @QueryParam("sortBy") String sortBy,
                                       @QueryParam("sortOrder") String sortOrder){
        final Pageable page1 = (Pageable) PageRequest.of(
                page, size, (sortOrder.equalsIgnoreCase("ASC")? Sort.Direction.ASC : Sort.Direction.DESC), sortBy);
        final CompletableFuture<Page<Candidate>> future = CompletableFuture
                .supplyAsync(() -> candidateService.findAllCandidates(page1));
        asyncResponse.resume(future.join());
    }



}
