package com.ofg.marketing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ofg.marketing.beans.ApplicationBean;
import com.ofg.marketing.repositories.MarketingOfferRepository;

import static com.ofg.marketing.beans.MarketingOfferType.*;

@Component
public class MarketingOfferGenerator {

	private MarketingOfferRepository marketingOfferRepository;

	@Autowired
	MarketingOfferGenerator(MarketingOfferRepository marketingOfferRepository) {
		this.marketingOfferRepository = marketingOfferRepository;
	}

	public void generateOffer(Long loanApplicationId, ApplicationBean applicationBean) {
		switch (applicationBean.getDecision()) {
			case SUCCESS:
				marketingOfferRepository.storeMarketingOfferForApplication(applicationBean, loanApplicationId, MARKETING_OFFER_1);
			case MANUAL:
				marketingOfferRepository.storeMarketingOfferForApplication(applicationBean, loanApplicationId, MARKETING_OFFER_2);
			case FAILURE:
				marketingOfferRepository.storeMarketingOfferForApplication(applicationBean, loanApplicationId, MARKETING_OFFER_3);
			default:
		}
	}

}
