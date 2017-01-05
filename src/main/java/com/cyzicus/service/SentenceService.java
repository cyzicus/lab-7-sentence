package com.cyzicus.service;

import com.cyzicus.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {

    private final WordService wordService;

    @Autowired
    public SentenceService(WordService wordService) {
        this.wordService = wordService;
    }

    public String getSentence() {

        String subject = correctWordSpacing(wordService.getSubject(), false);
        String verb = correctWordSpacing(wordService.getVerb(), false);
        String article = correctWordSpacing(wordService.getArticle(), false);
        String adjective = correctWordSpacing(wordService.getAdjective(), false);
        String noun = correctWordSpacing(wordService.getNoun(), true);

        return String.format("%s%s%s%s%s", subject, verb, correctArticle(article, adjective), adjective, noun);
    }

    private String correctArticle(String article, String adjective) {
        if (article.toLowerCase().equals("a")
                && adjective != null && adjective.length() > 0) {
            if (isVowel(adjective.charAt(0))) {
                return "an";
            }
        }
        return article;

    }

    private String correctWordSpacing(String wordIn, boolean endOfSentence) {
        String wordOut = "";
        if(wordIn != null && wordIn.length() > 0) {
            wordOut = wordIn;
            if(!endOfSentence) {
                wordOut += " ";
            }
        }
        return wordOut;
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

}
