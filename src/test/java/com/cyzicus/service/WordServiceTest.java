package com.cyzicus.service;

import com.cyzicus.client.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordServiceTest {

    @Mock
    private AdjectiveClient adjectiveClient;

    @Mock
    private ArticleClient articleClient;

    @Mock
    private NounClient nounClient;

    @Mock
    private SubjectClient subjectClient;

    @Mock
    private VerbClient verbClient;

    private WordService wordService;

    @Before
    public void setup() throws Exception {
        wordService = new WordService(adjectiveClient, articleClient, nounClient, subjectClient, verbClient);
    }

    @Test
    public void getAdjective_callsAdjectiveClient() throws Exception {
        when(adjectiveClient.getAdjective()).thenReturn("blue");
        assertEquals("blue", wordService.getAdjective());
    }

    @Test
    public void getArticle_callsArticleClient() throws Exception {
        when(articleClient.getArticle()).thenReturn("a");
        assertEquals("a", wordService.getArticle());
    }

    @Test
    public void getNoun_callsNounClient() throws Exception {
        when(nounClient.getNoun()).thenReturn("boat");
        assertEquals("boat", wordService.getNoun());
    }

    @Test
    public void getSubject_callsSubjectClient() throws Exception {
        when(subjectClient.getSubject()).thenReturn("I");
        assertEquals("I", wordService.getSubject());
    }

    @Test
    public void getVerb_callsVerbClient() throws Exception {
        when(verbClient.getVerb()).thenReturn("saw");
        assertEquals("saw", wordService.getVerb());
    }

}