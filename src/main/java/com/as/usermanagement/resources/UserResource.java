package com.as.usermanagement.resources;

import com.as.usermanagement.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

//TODO : This is temporary resource just to test swagger,
// Delete it once the required resource created
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserResource {
    /**
     * below line not required thanks to Lombok : @sl4j
     */
    //Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
    @ApiOperation(value = "Get User name by Id", notes = "Pass the user id to get the User details")
    @GetMapping(value = "/{user_id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})

    public String getUserName(@ApiParam(value = "User Id", required = true) @PathVariable("user_id") String userId) {
        //LOGGER.info("Info log");
        //LOGGER.error("Error log");
        //LOGGER.warn("Warn log");
        //LOGGER.debug("Debug log");
        //LOGGER.trace("trace log");
        log.info("INFO From Lombok.");
        return userId + " Hello";
    }

    @ApiOperation(value = "Get user details by Id", notes = "get the User details by user id")
    @GetMapping(value = "/test/{user_id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User getUser(@ApiParam(value = "User Id", required = true) @PathVariable("user_id") String userId){
        return null;
    }
}
