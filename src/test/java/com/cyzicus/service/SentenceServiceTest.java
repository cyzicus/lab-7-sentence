package com.cyzicus.service;

import com.cyzicus.client.*;
import com.cyzicus.config.SentenceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SentenceServiceTest {

    @Mock
    WordService wordService;

    SentenceService sentenceService;

    @Before
    public void setUp() throws Exception {
        sentenceService = new SentenceService(wordService);
    }

    @Test
    public void getSentence_returnsSentence() throws Exception {
        when(wordService.getAdjective()).thenReturn("red");
        when(wordService.getArticle()).thenReturn("the");
        when(wordService.getNoun()).thenReturn("pontoon");
        when(wordService.getSubject()).thenReturn("I");
        when(wordService.getVerb()).thenReturn("paddled");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I paddled the red pontoon", sentence);
    }

    @Test
    public void getSentence_handlesArticleCorrectly_a() throws Exception {
        when(wordService.getAdjective()).thenReturn("beautiful");
        when(wordService.getArticle()).thenReturn("a");
        when(wordService.getNoun()).thenReturn("cat");
        when(wordService.getSubject()).thenReturn("I");
        when(wordService.getVerb()).thenReturn("saw");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I saw a beautiful cat", sentence);
    }

    @Test
    public void getSentence_handlesArticleCorrectly_an() throws Exception {
        when(wordService.getAdjective()).thenReturn("ugly");
        when(wordService.getArticle()).thenReturn("a");
        when(wordService.getNoun()).thenReturn("cat");
        when(wordService.getSubject()).thenReturn("I");
        when(wordService.getVerb()).thenReturn("saw");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I saw an ugly cat", sentence);
    }

    @Test
    public void getSentence_handlesNullAdjectiveCorrectly() throws Exception {
        when(wordService.getAdjective()).thenReturn(null);
        when(wordService.getArticle()).thenReturn("a");
        when(wordService.getNoun()).thenReturn("cat");
        when(wordService.getSubject()).thenReturn("I");
        when(wordService.getVerb()).thenReturn("saw");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I saw a cat", sentence);
    }

    @Test
    public void getSentence_handlesEmptyAdjectiveCorrectly() throws Exception {
        when(wordService.getAdjective()).thenReturn("");
        when(wordService.getArticle()).thenReturn("a");
        when(wordService.getNoun()).thenReturn("cat");
        when(wordService.getSubject()).thenReturn("I");
        when(wordService.getVerb()).thenReturn("saw");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I saw a cat", sentence);
    }

}