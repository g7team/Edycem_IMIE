package fr.imie.edycem.controller;

import com.google.common.base.Preconditions;
import fr.imie.edycem.model.Request.PartnerRequest;
import fr.imie.edycem.model.Response.PartnerResponse;
import fr.imie.edycem.service.Interface.PartnerService;
import fr.imie.edycem.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @RequestMapping("/")
    public List<PartnerResponse> getPartner() {
        return partnerService.getAll();
    }

   @GetMapping(value = "/{id}")
    public PartnerResponse getById(@PathVariable("id") Integer id) {
        return RestPreconditions.checkFound(partnerService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PartnerResponse createPartner(@RequestBody PartnerRequest partnerRequest) {
        Preconditions.checkNotNull(partnerRequest);
        return this.partnerService.create(partnerRequest);
    }

    @PutMapping(value = "/{id}")
    public PartnerResponse updatePartner(@PathVariable( "id" ) Integer id, @RequestBody PartnerRequest partnerRequest) {
        Preconditions.checkNotNull(partnerRequest);
        RestPreconditions.checkFound(this.partnerService.getById(id));
        return this.partnerService.update(partnerRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePartner(@PathVariable("id") Integer id) {
        this.partnerService.delete(id);
    }
}
