package com.evg.ws.todoWs.endpoint;

import com.evg.ws.todoWs.repository.TodoRepository;
import com.evgenjin.xjc.GetToDoRequest;
import com.evgenjin.xjc.GetToDoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author evgen
 */

@Endpoint
public class TodoEndpoint {
    private static final String NAMESPACE_URI = "http://evgenjin.com";

    @Autowired
    private TodoRepository todoRepository;

//	@Autowired
//	public CountryEndpoint(CountryRepository countryRepository) {
//		this.countryRepository = countryRepository;
//	}

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getToDoRequest")
    @ResponsePayload
    public GetToDoResponse getCountry(@RequestPayload GetToDoRequest request) {
        GetToDoResponse response = new GetToDoResponse();
        response.setCountry(todoRepository.findCountry(request.getId()));
        return response;
    }
}