io.coderate.accurest.dsl.GroovyDsl.make {
    request {
        method 'GET'
        url '/api/marketing/Janko_Hrasko'
        headers {
            header 'Content-Type': 'application/json'
        }
    }
    response {
        headers {
            header 'Content-Type': 'application/json'
        }
        body '''
        [{
            "marketingOffer" : "MARKETING_OFFER_1"
        }]
        '''
    }
}