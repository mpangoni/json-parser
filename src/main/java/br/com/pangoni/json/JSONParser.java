package br.com.pangoni.json;

public class JSONParser {

    private int startSringLiteral;
    private int endStringLiteral;

    private boolean isStringLiteral = false;

    public void parse(String json, JSONParserCallback callback) {

        char[] array = json.toCharArray();

        for (int i = 0; i < array.length; i++) {

            char c = array[i];

            switch (c) {

            case '{':
            case '[':
                break;

            case ':':
                callback.handleKey(String.valueOf(array, startSringLiteral, endStringLiteral - startSringLiteral));
                startSringLiteral = endStringLiteral = 0;
                break;

            case '}':
            case ']':
            case ',':
                if (isStringLiteral && endStringLiteral > 0) {
                    callback.handleValue(
                            String.valueOf(array, startSringLiteral, endStringLiteral - startSringLiteral));
                    startSringLiteral = endStringLiteral = 0;
                }
                break;

            case '"':

                if (!isStringLiteral) {
                    startSringLiteral = i + 1;
                }

                isStringLiteral = !isStringLiteral;

            default:
                if (isStringLiteral)
                    endStringLiteral = i + 1;
            }
        }

    }
}
