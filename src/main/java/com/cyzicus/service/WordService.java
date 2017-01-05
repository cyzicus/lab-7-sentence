package com.cyzicus.service;

import com.cyzicus.client.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    private final AdjectiveClient adjectiveClient;
    private final ArticleClient articleClient;
    private final NounClient nounClient;
    private final SubjectClient subjectClient;
    private final VerbClient verbClient;

    @Autowired
    public WordService(AdjectiveClient adjectiveClient, ArticleClient articleClient, NounClient nounClient,
                       SubjectClient subjectClient, VerbClient verbClient) {
        this.adjectiveClient = adjectiveClient;
        this.articleClient = articleClient;
        this.nounClient = nounClient;
        this.subjectClient = subjectClient;
        this.verbClient = verbClient;
    }
    @HystrixCommand(fallbackMethod = "getAdjectiveFallback")
    public String getAdjective() {
        return adjectiveClient.getAdjective();
    }

    @HystrixCommand(fallbackMethod = "getArticleFallback")
    public String getArticle() {
        return articleClient.getArticle();
    }

    @HystrixCommand(fallbackMethod = "getNounFallback")
    public String getNoun() {
        return nounClient.getNoun();
    }

    @HystrixCommand(fallbackMethod = "getSubjectFallback")
    public String getSubject() {
        return subjectClient.getSubject();
    }

    @HystrixCommand(fallbackMethod = "getVerbFallback")
    public String getVerb() {
        return verbClient.getVerb();
    }

    private String getSubjectFallback() {
        return "We";
    }

    private String getVerbFallback() {
        return "paddled";
    }

    private String getArticleFallback() {
        return "the";
    }

    private String getAdjectiveFallback() {
        return "red";
    }

    private String getNounFallback() {
        return "kayak";
    }

}
