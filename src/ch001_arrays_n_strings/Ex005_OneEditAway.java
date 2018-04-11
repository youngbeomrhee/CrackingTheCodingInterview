package ch001_arrays_n_strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ex005_OneEditAway {

    boolean oneEditAway(String first , String second) {
        /* 길이 제크 */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        /* 길이가 짧은 문자열과 긴 문자열 찾기 */
        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;
        int shorterIdx = 0;
        int longerIdx = 0;
        boolean foundDifference = false;
        while (longerIdx < longer.length() && shorterIdx < shorter.length()){
            char shorterIdxChar = shorter.charAt(shorterIdx);
            char longerIdxChar = longer.charAt(longerIdx);
            if (shorterIdxChar != longerIdxChar){  // 문자가 다를때
                if (foundDifference) return false;  // 한 번만 다른 문자여야 한다.
                foundDifference  = true;
                if (shorter.length() == longer.length()) { // 문자의 길이가 같은 경우에는 짧은 문자열의 포인터도 증가
                    shorterIdx++;
                }
            } else {
                shorterIdx++; // 두 개의 문자가 동일하다면 짧은 문자열의 포인터를 증가
            }
            longerIdx++; // 긴 문자열의 포인터는 언제나 증가
        }
        return true;
    }
    @Test
    public void test() {
        /*
            pale, ple -> true
            pales, pale -> true
            pale, bale -> true
            pale, bake -> false
        */
        Assert.assertTrue(this.oneEditAway("pale", "ple"));
        Assert.assertTrue(this.oneEditAway("pales", "pale"));
        Assert.assertTrue(this.oneEditAway("pale", "bale"));
        Assert.assertFalse(this.oneEditAway("pale", "bake"));
        Assert.assertTrue(this.oneEditAway("pale", "pole"));
    }
}