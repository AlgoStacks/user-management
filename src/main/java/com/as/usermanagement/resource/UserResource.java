package com.as.usermanagement.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//TODO : This is temporary resource just to test swagger,
// Delete it once the required resource created
@RestController
@RequestMapping("/user")
public class UserResource {

	@ApiOperation(value = "Get User name by Id", notes="Pass the user id to get the User details")
	@GetMapping(value = "/{user_id}", 
			produces = { MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	
	public String getUserName(@ApiParam(value = "User Id", required = true) @PathVariable("user_id") String userId) {
		return userId + " Hello";
	}
}
