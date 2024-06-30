package io.debezium.time;

import io.debezium.spi.converter.RelationalColumn;
import io.debezium.spi.converter.CustomConverter;
import io.debezium.spi.converter.ConvertedField;
import org.apache.kafka.connect.data.SchemaBuilder;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class CustomTimestampConverter implements CustomConverter<SchemaBuilder, RelationalColumn> {

    private DateTimeFormatter formatter;

    @Override
    public void configure(Properties props) {
        String format = props.getProperty("format", "yyyy-MM-dd HH:mm:ss.SSS");
        ZoneId zoneId = ZoneId.of(props.getProperty("zone", "Asia/Shanghai"));
        formatter = DateTimeFormatter.ofPattern(format).withZone(zoneId);
    }
	private static final ZoneId SOURCE_ZONE = ZoneId.of("UTC");
	private static final ZoneId TRG_ZONE = ZoneId.of("Asia/Shanghai");

    @Override
    public void converterFor(RelationalColumn field, ConverterRegistration<SchemaBuilder> registration) {
        if ("TIMESTAMP".equalsIgnoreCase(field.typeName())) {
            registration.register(SchemaBuilder.string(), x -> {
                if (x == null) {
                    return null;
                }
                if (x instanceof Long) {
                    Instant instant = Instant.ofEpochMilli((Long) x);
                    return formatter.format(instant);
                } else if (x instanceof Instant) {
					Instant instant = (Instant) x;
					instant = instant.atZone(SOURCE_ZONE).withZoneSameLocal(TRG_ZONE).toInstant();
					String format = formatter.format(instant);
					return format;
				}
				/*Instant y = null;*/
                return x.toString();
            });
        }
    }
}