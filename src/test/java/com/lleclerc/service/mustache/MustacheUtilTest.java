package com.lleclerc.service.mustache;

import com.lleclerc.service.java.ResourceUtil;
import org.junit.Test;

import java.io.Reader;
import java.io.StringWriter;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MustacheUtilTest implements ResourceUtil {
    @Test
    public void compileModels() {
        // GIVEN
        Reader reader = readResourceAsBufferedReader("swagger-codegen-sample.yml");
        StringWriter writer = new StringWriter();
        MustacheUtil.compile(reader, writer, null);
    }

    @Test
    public void compileStandalone_happyPath() {
        // GIVEN
        String template = "Hello {{escaped}} and {{{notEscaped}}}!";
        Map<String, Object> model = Map.of("escaped", "<John>", "notEscaped", "<Smith>");

        // WHEN
        String result = MustacheUtil.compile(template, model);

        // THEN
        assertEquals("Hello &lt;John&gt; and <Smith>!", result);
    }
}