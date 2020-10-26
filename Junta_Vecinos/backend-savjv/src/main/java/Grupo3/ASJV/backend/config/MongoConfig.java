/*package Grupo3.ASJV.backend.config;

import Grupo3.ASJV.backend.time.*;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    public MongoClient mongoClient() {
        return null;
    }

    @Override
    protected String getDatabaseName() {
        return null;
    }

    @Override
    public MongoCustomConversions customConversions() {
        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());
        return new MongoCustomConversions(converters);
    }
}
*/