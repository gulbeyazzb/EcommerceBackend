package com.workintech.ecommerce.ecommerce.validation;

import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import org.springframework.http.HttpStatus;

public class Validation {

    public static void checkString(String value, String field, int length){
        if(value == null || value.isEmpty()) throw new CommerceException(field + " cannot be null or empty! ", HttpStatus.BAD_REQUEST);
        if(value.length() <= 3 || value.length() > length) throw new CommerceException(field + " length cannot bigger than " + length + " and cannot smaller" +
                "than 0!", HttpStatus.BAD_REQUEST);
    }
    public static void checkPhone(long phoneNumber){
        String phoneStr = Long.toString(phoneNumber);
        char firstChar = phoneStr.charAt(0);
        if(firstChar == '0') throw new CommerceException("The phone number shouldn't begin with 0!", HttpStatus.BAD_REQUEST);
    }
    public static void checkRating(double rating){
        if(rating < 0 || rating > 5) throw new CommerceException("Rating must be between 0 and 5!", HttpStatus.BAD_REQUEST);
    }
    public static void checkPrice(double price){
        if (price < 0) throw new CommerceException("Price cannot smaller than 0!", HttpStatus.BAD_REQUEST);
    }
    public static void checkSellCountAndStock(int value){
        if(value < 0 ) throw new CommerceException("Sell count cannot smaller than 0!", HttpStatus.BAD_REQUEST);
    }
    public static void checkImageLength(String[] images){
        if (images.length == 0) throw new CommerceException("You must upload at least 1 picture!", HttpStatus.BAD_REQUEST);
        if (images.length > 3) throw new CommerceException("You can upload 3 urls for each picture!", HttpStatus.BAD_REQUEST);
    }
    public static void checkCategory(long id){
        if (id < 0 || id > 14) throw new CommerceException("You should enter a valid categoryID!", HttpStatus.BAD_REQUEST);
    }
    public static void checkPassword(String password){
        if (password.isEmpty()) throw new CommerceException("You should enter a valid password!", HttpStatus.BAD_REQUEST);
        if (password.length() < 8) throw new CommerceException("You should enter a valid password!", HttpStatus.BAD_REQUEST);
//        String REGEX = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[ -/:-@\[-`{-~]).{6,64}$/";
//        password.matches(REGEX);
    }
}
