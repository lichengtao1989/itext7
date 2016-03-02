package com.itextpdf.kernel.parser;

import com.itextpdf.kernel.pdf.PdfPage;

import java.io.IOException;

public final class PdfTextExtractor {

    private PdfTextExtractor() {
    }

    /**
     * Extract text from a specified page using an extraction strategy.
     *
     * @param page     the page for the text to be extracted from
     * @param strategy the strategy to use for extracting text
     * @return the extracted text
     */
    public static String getTextFromPage(PdfPage page, TextExtractionStrategy strategy) {
        PdfCanvasProcessor parser = new PdfCanvasProcessor(strategy);
        parser.processPageContent(page);
        return strategy.getResultantText();
    }

    /**
     * Extract text from a specified page using the default strategy.
     * Node: the default strategy is subject to change. If using a specific strategy
     * is important, please use {@link PdfTextExtractor#getTextFromPage(PdfPage, TextExtractionStrategy)}.
     *
     * @param page the page for the text to be extracted from
     * @return the extracted text
     */
    public static String getTextFromPage(PdfPage page) throws IOException {
        return getTextFromPage(page, new LocationTextExtractionStrategy());
    }
}
