package com.dictionary.repository.impl;

import com.dictionary.model.Dictionary;
import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
   private static List<Dictionary> dictionaries = new ArrayList<>();

    static {
        dictionaries.add(new Dictionary("dog", "Con chó Này!"));
        dictionaries.add(new Dictionary("cat", "Con mèo"));
        dictionaries.add(new Dictionary("hello", "Xin chào"));
        dictionaries.add(new Dictionary("pig", "Con heo Này!"));
        dictionaries.add(new Dictionary("computer", "máy tính"));
        dictionaries.add(new Dictionary("mouse", "Con chuột Này!"));
    }
    @Override
    public String search(String word) {
        for (Dictionary dic : dictionaries){
            if(word.toLowerCase().equals(dic.getEnglish())){
                return dic.getVietnamese();
            }
        }
        return "not found!";
    }
}
