package guru.springframework.springaifunctions.functions;

import guru.springframework.springaifunctions.model.StockPriceRequest;
import guru.springframework.springaifunctions.model.StockPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

import java.util.function.Function;

@RequiredArgsConstructor
public class StockQuoteFunction implements Function<StockPriceRequest, StockPriceResponse> {

    public final String STOCK_URL = "https://api.api-ninjas.com/v1/stockprice";

    private final String apiNinjasKey;

    @Override
    public StockPriceResponse apply(StockPriceRequest stockPriceRequest) {

        RestClient restClient = RestClient.builder()
                .baseUrl(STOCK_URL)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.set("X-Api-Key", apiNinjasKey);
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("Content-Type", "application/json");
                }).build();

        return restClient.get().uri(uriBuilder -> uriBuilder.queryParam("ticker", stockPriceRequest.ticker()).build())
                .retrieve()
                .body(StockPriceResponse.class);

    }
}
