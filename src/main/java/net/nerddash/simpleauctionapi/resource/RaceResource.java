package net.nerddash.simpleauctionapi.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nerddash.simpleauctionapi.dto.GenericForm;
import net.nerddash.simpleauctionapi.model.Race;
import net.nerddash.simpleauctionapi.service.RaceService;

@RestController
@RequestMapping("/races")
public class RaceResource extends ApiResourceImpl<Race, GenericForm<Race>, RaceService> {

}
