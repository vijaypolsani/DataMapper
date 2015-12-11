package org.kp.digital.aem.personalization.modules;

import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvParserSettings;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by vijay on 12/10/15.
 */
@Module
public class CsvParserSettingsModule {
    private final CsvParserSettings csvParserSettings = new CsvParserSettings();

    @Inject
    CsvFormat csvFormat;

    @Provides
    @Singleton
    public CsvParserSettings provideCsvParserSettings() {

        csvParserSettings.setLineSeparatorDetectionEnabled(true);
        csvParserSettings.setParseUnescapedQuotes(true);
        csvParserSettings.setHeaderExtractionEnabled(true);
        csvParserSettings.setFormat(csvFormat);
        return csvParserSettings;
    }

}
