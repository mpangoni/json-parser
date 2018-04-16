
package br.com.pangoni.json;

public interface JSONParserCallback{

    public void handleKey(String key);

    public void handleValue(String value);
}