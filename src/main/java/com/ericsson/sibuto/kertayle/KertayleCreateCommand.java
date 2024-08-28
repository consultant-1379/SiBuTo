package com.ericsson.sibuto.kertayle;


/**
 * Created by lmieody on 26/07/16.
 */
public class KertayleCreateCommand {

    private static final String CREATE = "CREATE";
    private static final String OPENPARENTHASIS = "(";
    private static final String CLOSEPARENTHASIS = ")";
    private static final String PARENT = "parent";
    private static final String IDENTITY = "identity";
    private static final String MOTYPE = "moType";
    private static final String EXCEPTION = "exception";
    private static final String NROFATTRIBUTES = "nrOfAttributes";
    private static final String USERLABEL = "userLabel";
    private static final String NEWLINE = "\n";
    private static final String TAB = "\t";
    private static final String SPACE = " ";
    private static final String DOUBLEQUOTE = "\"";

    private String parent;
    private String identity;
    private String moType;
    private String exception;

    public static class Builder {


        private String parent;
        private String identity;
        private String moType;
        private String exception;

        public Builder parent(String parent) { this.parent = parent; return this; }
        public Builder identity(String identity) { this.identity = identity; return this; }
        public Builder moType(String moType) { this.moType = moType; return this; }

        public KertayleCreateCommand build() {
            return new KertayleCreateCommand(this);
        }
    }

    private KertayleCreateCommand(Builder builder) {
        this.parent = builder.parent;
        this.identity = builder.identity;
        this.moType = builder.moType;
        this.exception = builder.exception;
    }

    @Override
    public String toString() {
        StringBuilder kertayleCommandString = new StringBuilder();
        kertayleCommandString.append(CREATE);
        kertayleCommandString.append(NEWLINE);
        kertayleCommandString.append(OPENPARENTHASIS);
        kertayleCommandString.append(NEWLINE);
        kertayleCommandString.append(TAB + PARENT + SPACE + DOUBLEQUOTE + parent + DOUBLEQUOTE);
        kertayleCommandString.append(NEWLINE);
        kertayleCommandString.append(TAB + IDENTITY + SPACE + DOUBLEQUOTE + identity + DOUBLEQUOTE);
        kertayleCommandString.append(NEWLINE);
        kertayleCommandString.append(TAB + MOTYPE + SPACE + moType);
        kertayleCommandString.append(NEWLINE);
        kertayleCommandString.append(CLOSEPARENTHASIS);
        kertayleCommandString.append(NEWLINE);
        return kertayleCommandString.toString();
    }
}
