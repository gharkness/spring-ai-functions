package guru.springframework.springaifunctions.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.math.BigDecimal;

/**
 * {
 *   "ticker": "AAPL",
 *   "name": "Apple Inc.",
 *   "price": 192.42,
 *   "exchange": "NASDAQ",
 *   "updated": 1706302801,
 *   "currency": "USD"
 * }
 */
public record StockPriceResponse(
        @JsonPropertyDescription("Ticker name of the stock") String ticker,
        @JsonPropertyDescription("Name of the company") String name,
        @JsonPropertyDescription("Current stock price in USD") BigDecimal price,
        @JsonPropertyDescription("Exchange where the stock is traded") String exchange,
        @JsonPropertyDescription("Last updated time in epoch seconds") Long updated,
        @JsonPropertyDescription("Currency of the stock price") String currency
) {
}
