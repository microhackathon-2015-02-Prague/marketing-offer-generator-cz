package com.ofg.marketing.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.base.Splitter;
import com.ofg.marketing.beans.ApplicationBean;
import com.ofg.marketing.beans.MarketingOfferBean;
import com.ofg.marketing.beans.MarketingOfferType;

@Repository
public class MarketingOfferRepository {

	public MarketingOfferBean getMarketingOfferForClient(String clientName) {
		List<String> splittedClientName = Splitter.on('_').omitEmptyStrings().trimResults().splitToList(clientName);
		
		return null;
	}

	public void storeMarketingOfferForApplication(ApplicationBean applicationBean, Long applicationId, MarketingOfferType marketingOfferType) {

	}
}
