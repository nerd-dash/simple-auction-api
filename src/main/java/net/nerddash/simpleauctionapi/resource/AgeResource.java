package net.nerddash.simpleauctionapi.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nerddash.simpleauctionapi.dto.GenericForm;
import net.nerddash.simpleauctionapi.model.Age;
import net.nerddash.simpleauctionapi.service.AgeService;

@RestController
@RequestMapping("/ages")
public class AgeResource extends ApiResourceImpl<Age, GenericForm<Age>, AgeService> {

}