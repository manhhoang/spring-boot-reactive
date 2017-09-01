package com.knapsack.controller;

import com.knapsack.model.Item;
import com.knapsack.service.KnapSackService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("/api")
public class KnapSackController {

    @Autowired
    private final KnapSackService knapSackService;

    @Autowired
    public KnapSackController(KnapSackService knapSackService) {
        this.knapSackService = knapSackService;
    }

    @ApiOperation(value = "Get optimizer.", notes = "", response = Item.class, tags = {"Item",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Item.class),
            @ApiResponse(code = 400, message = "Request failed.", response = Item.class),
            @ApiResponse(code = 401, message = "Authorization has been denied for this request.", response = Item.class),
            @ApiResponse(code = 422, message = "Model validation failed.", response = Item.class),
            @ApiResponse(code = 429, message = "Too many requests.", response = Item.class),
            @ApiResponse(code = 500, message = "Internal server error.", response = Item.class)})
    @RequestMapping(value = "/v1/knapsack/{capacity}", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public CompletableFuture<List<Item>> getOptimizer(@PathVariable("capacity") String capacity, @RequestBody List<Item> items) {
        return null;
    }

}