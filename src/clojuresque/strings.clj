(ns clojuresque.strings
  (:require [clojure.string :as str]) ; can use short name 'str'
  )

(def str1 "Hello")
(def my-reg-expr2 #"[a-z]*")

(defn strings []
  ,,,(println "strings:")

  ,,, (println (type str1))  ; java.lang.String
  ,,, (println (format "This is a string %s" str1))  ; This is a string Hello
  ,,, (println (str/blank? str1))  ; false
  ,,, (println (str/includes? str1 "Hell"))  ; true
  ,,, (println (str/index-of str1 "llo"))  ; 2
  ,,, (println (str/split str1 #" "))  ; [Hello]
  ,,, (println (str/split str1 #"l"))  ; [He  o]
  ,,, (println (str/join " " ["The" "Big" "Cheese"]))  ; "The Big Cheese"
  ,,, (println (str/replace "I am 42" #"42", "43"))  ; "I am 43"
  ,,, (println (str/trim "  hi  "))  ; hi
  ,,, (println (str/trim-newline "  hi  "))  ; "  hi  "
  ,,, (println (str/trimr "  hi  "))  ;  hi
  ,,, (println (str/triml "  hi  "))  ; hi
  ,,, (println (str/upper-case "  hi  "))  ;  HI
  ,,, (println (str/lower-case "  HI  "))  ;  hi


  (println \Z)  ; single character  ; Z
  (println #"[A-Z]")  ; string that's a regex  ; #"[A-Z]" 

  (println (re-find my-reg-expr2 "state is NY"))  ; "state"
  (println (re-find my-reg-expr2 "01234 is zip"))  ; nil
  )
