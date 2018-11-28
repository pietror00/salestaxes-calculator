package it.salestaxes.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import it.salestaxes.Order;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateProcessor {

    private static final String RECEIPT_TEMPLATE = "receipt.ftl";

    private static final String TEMPLATE_DIRECTORY_PATH = "src/main/resources/templates/";

    private static Configuration configurationSingleton;

    private static synchronized Configuration getDefaultConfigurationInstance() throws IOException {
        if (configurationSingleton == null) {
            configurationSingleton = new Configuration(Configuration.VERSION_2_3_23);
            configurationSingleton.setDirectoryForTemplateLoading(new File(TEMPLATE_DIRECTORY_PATH));
        }
        return configurationSingleton;
    }

    public static String processReceiptTemplate(Order order) throws IOException, TemplateException {

        Template template = getDefaultConfigurationInstance().getTemplate(RECEIPT_TEMPLATE);

        Map<String, Object> model = new HashMap<>();
        model.put("order",order);

        StringWriter stringWriter = new StringWriter();
        template.process(model, stringWriter);
        return stringWriter.toString();
    }

}
