package algo.trading.common.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object for a BackTest configuration. Contains the strategy name, selected
 * instruments, exchange, timeframes, date range, and strategy parameters.
 */
@Data
@Builder
public class BackTestDto {
  /** Unique identifier for the backtest configuration. */
  @NotNull(message = "Backtest ID must not be null")
  private Long id;

  /** The name of the trading strategy used in the backtest. */
  @NotBlank(message = "Strategy name must not be blank")
  private String strategyName;

  /** List of instrument symbols involved in the backtest. */
  @NotEmpty(message = "Symbols list must not be empty")
  private List<InstrumentDto> symbols;

  /** The exchange where the backtest will take place. */
  @NotNull(message = "Exchange must not be null")
  private Exchange exchange;

  /** Timeframes used for the backtest. */
  @NotEmpty(message = "Timeframes list must not be empty")
  private List<Timeframe> timeframes;

  /** Number of months to look back from the current date for backtest history. */
  @NotNull(message = "Backtest period must be specified")
  @Min(value = 1, message = "Period must be at least 1 month")
  private Integer periodInMonth;

  /** Strategy parameters for the backtest. */
  private Map<BackTestParams, String> params;
}
