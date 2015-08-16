package com.ua.art.newsaggregator.model;

public class TemplateServer {

    public static String requestJsonNews(
            String moduleId, String categoryId, String sourceId,
            String pubDate, String quantity, String older)
    {
        String param = "{" +
                "\"moduleId\" : \"" + moduleId + "\"," +
                "\"categoryId\" : \"" + categoryId + "\"," +
                "\"sourceId\" : \"" + sourceId + "\"," +
                "\"pubDate\" : \"" + pubDate + "\"," +
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

    public static String requestJsonNews()
    {
        String param = "{}";
        return param;
    }
}
