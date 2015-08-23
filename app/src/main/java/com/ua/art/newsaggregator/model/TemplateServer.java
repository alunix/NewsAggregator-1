package com.ua.art.newsaggregator.model;

public class TemplateServer {

    public static String requestJsonNews(
            String moduleId, String categoryId, String sourceId,
            String idItem, String quantity, String older)
    {
        String param = "{" +
                "\"moduleId\" : \"" + moduleId + "\"," +
                "\"categoryId\" : \"" + categoryId + "\"," +
                "\"sourceId\" : \"" + sourceId + "\"," +
                "\"id\" : \"" + idItem + "\"," +
                "\"quantity\" : \"" + quantity + "\"," +
                "\"older\" : \"" + older + "\"" +
                "}";
        return param;
    }

    public static String requestJsonNews(
            String moduleId, String categoryId, String sourceId)
    {
        String param = "{" +
                "\"moduleId\" : \"" + moduleId + "\"," +
                "\"categoryId\" : \"" + categoryId + "\"," +
                "\"sourceId\" : \"" + sourceId + "\"" +
                "}";
        return param;
    }

    public static String requestJsonNews()  // pull
    {
        String param = "{}";
        return param;
    }
}
