package org.kp.digital.aem.personalization.modules;

import com.univocity.parsers.csv.CsvFormat;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/10/15.
 */
@Module
public class CsvFormatModule {

    private static final char PIPE = '|';

    @Provides
    @Singleton
    public CsvFormat provideCsvParserMerged() {
        CsvFormat csvFormat = new CsvFormat();
        csvFormat.setDelimiter(PIPE);
        return csvFormat;
    }
}
