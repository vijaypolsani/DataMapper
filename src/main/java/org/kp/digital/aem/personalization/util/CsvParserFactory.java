package org.kp.digital.aem.personalization.util;

import com.univocity.parsers.common.processor.RowProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.kp.digital.aem.personalization.modules.CsvParserSettingsModule;

/**
 * Created by vijay on 11/11/15.
 */
public final class CsvParserFactory {
    private static final long serialVersionUID = 1L;
    private static volatile CsvParserFactory csvParserFactory = null;

    private final CsvParserSettings csvParserSettings = org.kp.digital.aem.personalization.components
            .DaggerCsvParserSettingsComponent.builder().csvParserSettingsModule(new CsvParserSettingsModule()).build
                    ().provideCsvParserSettings();

    private CsvParserFactory() {
    }

    public static CsvParser getCsvParser(RowProcessor rowProcessor) {
        return CsvParserFactory.CsvParserHolder.csvParserFactory.get(rowProcessor);
    }

    protected Object readResolve() {
        return csvParserFactory;
    }

    private CsvParser get(RowProcessor rowProcessor) {
        csvParserSettings.setRowProcessor(rowProcessor);
        return new com.univocity.parsers.csv.CsvParser(csvParserSettings);
    }

    private static class CsvParserHolder {
        private static final CsvParserFactory csvParserFactory = new CsvParserFactory();
    }

}
