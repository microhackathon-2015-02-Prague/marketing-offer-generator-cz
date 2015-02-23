package com.ofg.marketing.controller

import com.google.common.base.Splitter
import com.ofg.marketing.MarketingOfferGenerator
import com.ofg.marketing.beans.ApplicationBean
import com.ofg.marketing.beans.MarketingOfferBean
import com.ofg.marketing.repositories.MarketingOfferRepository
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.ws.rs.core.MediaType

import javax.validation.constraints.NotNull
import javax.ws.rs.core.Response

import static org.springframework.web.bind.annotation.RequestMethod.PUT
import static org.springframework.web.bind.annotation.RequestMethod.GET

@Slf4j
@RestController
@RequestMapping('/api')
@TypeChecked
@Api(value = "marketing", description = "Collects places from tweets and propagates them to Collerators")
class MarketingOfferController {

    private final MarketingOfferGenerator marketingOfferGenerator;

    private final MarketingOfferRepository marketingOfferRepository;

    @Autowired
    MarketingOfferController(MarketingOfferGenerator marketingOfferGenerator, MarketingOfferRepository marketingOfferRepository) {
        this.marketingOfferGenerator = marketingOfferGenerator;
        this.marketingOfferRepository = marketingOfferRepository;
    }

    @RequestMapping(
            value = '{loanApplicationId}',
            method = PUT,
            consumes = MediaType.APPLICATION_JSON
            )
    @ApiOperation(value = "Generate marketing offer for a given application",
            notes = "")
    Response processDecisionForApplication(@PathVariable @NotNull long loanApplicationId, @RequestBody @NotNull ApplicationBean applicationBean) {
       marketingOfferGenerator.generateOffer(loanApplicationId, applicationBean);
       return Response.ok().build();
    }

    @RequestMapping(
            value = '{firstname_lastname}',
            method = GET,
            produces = MediaType.APPLICATION_JSON
    )
    @ApiOperation(value = "Provide marketing offer for a given client",
            notes = "")
    Response getMarketingOfferForClient(@PathVariable @NotNull String clientName) {
        MarketingOfferBean marketingOffer = marketingOfferRepository.getMarketingOfferForClient(clientName);
        return Response.ok(marketingOffer).build();
    }

}
