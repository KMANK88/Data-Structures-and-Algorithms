Karten Pease
===================

I have used the method of doing a double for loop. In the first for loop it iterates through an array of substrings that has the smaller DNA code in it. The next for loop  iterates s though st.Keys() which is the suffixTire that holds all of the information on the original file with a letter removed each time. Inside both for loops there is an if statement that checks to see what strings in the suffixTrie start with the substrings in the array those that do stat with it are printed out with their location. The others are left out. 

My run time will be ~N^2 because of the two for loops and it takes N time to build and the suffix tree. 

The approach I could use to improve my dat a would be make a better version of the suffix Trie that holds the values by words and not just the single letters for example if the word is banana, the different leaves could hold na, nana,ana,nana, and a. Also I could have added a dollar sign at the end of the data structure to indicate that the string is done. 