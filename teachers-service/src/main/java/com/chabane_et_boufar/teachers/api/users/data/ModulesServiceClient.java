package com.chabane_et_boufar.teachers.api.users.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chabane_et_boufar.teachers.api.users.ui.model.ModuleResponseModel;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name = "albums-ws", fallbackFactory = ModulesFallbackFactory.class)
public interface ModulesServiceClient {

	@GetMapping("/users/{id}/Modules")
	public List<ModuleResponseModel> getAlbums(@PathVariable String id);
}

@Component
class ModulesFallbackFactory implements FallbackFactory<ModulesServiceClient> {

	@Override
	public ModulesServiceClient create(Throwable cause) {
		// TODO Auto-generated method stub
		return new ModulesServiceClientFallback(cause);
	}

}

class ModulesServiceClientFallback implements ModulesServiceClient {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Throwable cause;

	public ModulesServiceClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<ModuleResponseModel> getAlbums(String id) {
		// TODO Auto-generated method stub

		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error took place when getModules was called with userId: " + id + ". Error message: "
					+ cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place: " + cause.getLocalizedMessage());
		}

		return new ArrayList<>();
	}

}
