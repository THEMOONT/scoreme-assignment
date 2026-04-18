import java.util.*;

public class Task5 {

    // Simple logger substitute (since SLF4J may not be installed)
    static class Logger {
        void warn(String msg) { System.out.println("WARN: " + msg); }
        void error(String msg, Exception e) { System.out.println("ERROR: " + msg); e.printStackTrace(); }
    }

    private static final Logger logger = new Logger();

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                // FIX
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                // FIX
                throw new IllegalArgumentException("Empty content");
            }

            return new ValidationResult(true);

        } catch (IllegalArgumentException e) {
            // FIX
            logger.warn(e.getMessage());
            return new ValidationResult(false);

        } catch (Exception e) {
            // FIX
            logger.error("Unexpected error", e);
            throw e;
        }
    }

    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);

                // FIX
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {
                // FIX
                logger.error("Batch error", e);
            }
        }
    }

    void saveResult(ValidationResult r) {}
}

class Document {
    String extractContent() { return ""; }
}

class ValidationResult {
    private boolean valid;
    ValidationResult(boolean v) { valid = v; }
    boolean isValid() { return valid; }
}
